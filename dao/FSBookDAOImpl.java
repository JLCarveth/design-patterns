package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * An implementation of the Book Data Access Object,
 * which persists data to a text file.
 */
public class FSBookDAOImpl implements BookDAO {
    // Where the file will be stored
    private String filename = "data.txt";

    private String path = System.getProperty("user.dir");

    private int entryCount;

    public FSBookDAOImpl() {
        try {
            // Initialize file if not yet exists
            Files.createFile(Paths.get(path, filename));
            entryCount = 0;
        } catch (FileAlreadyExistsException e) {
            // File already exists
            try {
                entryCount = Files.readAllLines(Paths.get(path, filename)).size();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Gets a Book with given ID
     * @param id the unique ID of the book
     * @return the book, or null if no ID was found
     */
    public Book getBookByID(long id) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(filename));

            for (String line : lines) {
                if (line.startsWith(String.valueOf(id))) {
                    return parseBook(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Persists a new Book to storage
     * @param book the book to insert
     * @return true if the collection has changed
     */
    public boolean insertBook(Book book) {
        try {
            String toWrite = "\n" + book.toString();
            Files.write(Paths.get(path, filename), toWrite.getBytes(),StandardOpenOption.APPEND);
            entryCount++;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Removes book with the given id
     * @param id the unique ID of the entry to be removed
     */
    public boolean deleteBook(long id) {
        File currentFile = new File(filename);
        File tempFile = new File("temp.txt");
        Boolean changeMade = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(Long.toString(id))) {
                    changeMade = true;
                    entryCount--;
                    continue;
                }
                writer.write(line);
            }

            writer.close();
            reader.close();
            currentFile.delete();
            tempFile.renameTo(currentFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return changeMade;
    }

    public Book[] getAllBooks() {
        Book[] books = new Book[entryCount];
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            int x = 0;
            for (String l : lines) {
                books[x] = parseBook(l.trim());
                x++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    /**
     * Updates data in a book entry.
     * @param book the book to be updated. ID cannot change
     * @return true if the collection has changed as a result of this call.
     */
    public boolean updateBook(Book book) {
        File currentFile = new File(filename);
        File tempFile = new File("temp.txt");
        Boolean changeMade = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(Long.toString(book.getID()))) {
                    changeMade = true;
                    writer.write(book.toString());
                    continue;
                }
                writer.write(line);
            }

            writer.close();
            reader.close();
            tempFile.renameTo(currentFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return changeMade;
    }

    public boolean isEmpty() {
        return entryCount == 0;
    }

    private static Book parseBook(String bookStr) {
        String[] array = bookStr.split("\\|");
        

        Book book = new Book(Long.parseLong(array[0]));
        book.setTitle(array[1]);
        book.setAuthor(array[2]);
        book.setPageCount(Integer.parseInt(array[3]));
        book.setPrice(Double.parseDouble(array[4]));  
        
        return book;
    }
}