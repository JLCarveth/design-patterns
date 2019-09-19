package dao;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * An example of how a DAO would be used.
 * This is not made with best software design practices in mind,
 * this was made to be a quick demonstration of data persistence with a DAO.
 */
public class DAOMain {
    /**
     * Our Data-Access Object
     */
    private BookDAO dao;

    public DAOMain() {
        dao = new FSBookDAOImpl();
        System.out.println("Welcome to the Library.");

        Scanner scanner = new Scanner(System.in);
        String input;

        printInfo(System.out);
        while ((input = scanner.nextLine().toLowerCase()) != null ) {
            switch (input) {
                case "1":
                    System.out.println("Getting all Books...");
                    Book[] books = dao.getAllBooks();
                    for (Book b : books) {
                        System.out.println("- " + b);
                    }
                    System.out.println("\n");
                    break;
                case "2":
                    System.out.println("Create a record: ");
                    bookInput(scanner);
                    break;
                case "exit":
                System.out.println("Exiting...");
                System.exit(0);
                break;
                default:
                System.out.println("Not a valid input.");
                break;
            }
            printInfo(System.out);
        }
    }

    private void bookInput(Scanner in) {
        System.out.println("Enter the following data, separated by commas:");
        System.out.println("Book Title, Author, Page Count, Price");
        String line = in.nextLine();
        String[] data = line.split(",");
        
        Book book  = new Book(data[0],data[1],Integer.parseInt(data[2].trim()), Double.parseDouble(data[3]));
        dao.insertBook(book);
    }

    private void printInfo(PrintStream s) {
        s.println("Enter a number to perform the cooresponding action, or type 'exit'.");
        s.println("1. Get all entries.");
        s.println("2. Create a record.");
        s.println("\n\n\n");
   }

    public static void main(String[] args) {
        DAOMain main = new DAOMain();
    }
}