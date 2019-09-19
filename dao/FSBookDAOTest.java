package dao;

/**
 * This class tests the functionality and accuracy of the FSBookDAOImpl class.
 */
public class FSBookDAOTest {
    public FSBookDAOImpl daoImpl;

    public FSBookDAOTest() {
        daoImpl = new FSBookDAOImpl();
    }

    public boolean testGetBookByID(long id) {
        Book result = daoImpl.getBookByID(id);
        return result != null;
    }
    public boolean testInsertBook() {
        Book book = new Book("Harry Potter and the Gay Dumbledore",
        "J. K. Rowling",250,12.5);

        return daoImpl.insertBook(book);
    }

    /**
     * Tests FSBookDAOImpl.getAllBooks()
     * @param expectedSize the expected number of elements to be returned
     * @return true if the collection returned is the correct size.
     */
    public boolean testGetAllBooks(int expectedSize) {
        Book[] books = daoImpl.getAllBooks();
        return expectedSize == books.length;
    }

    /**
     * Tests FSBookDAOImpl.deleteBook()
     */
    public boolean testDeleteBook(long id) {
        int initialCount = daoImpl.getAllBooks().length;
        daoImpl.deleteBook(id);

        return daoImpl.getAllBooks().length == (initialCount -1);
    }

    public boolean testUpdateBook(Book book) {
        return daoImpl.updateBook(book);
    }

    public static void main(String[] args) {
        FSBookDAOTest test = new FSBookDAOTest();

        System.out.print("Testing insertBook() ");
        System.out.println(test.testInsertBook());

        // Store the ID to be deleted later
        long id = test.daoImpl.getAllBooks()[0].getID();

        System.out.print("Testing getAllBooks() ");
        System.out.println(test.testGetAllBooks(1));// Expected to have one 

        Book book = test.daoImpl.getBookByID(id);
        book.setTitle("New " + book.getTitle());
        System.out.print("Tetsing updateBook() ");
        System.out.println(test.testUpdateBook(book));

        System.out.print("Testing deleteBook() ");
        System.out.println(test.testDeleteBook(id));
    }
}