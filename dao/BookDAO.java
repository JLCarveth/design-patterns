package dao;

public interface BookDAO {
    /**
     * Gets a book with given ID
     * @param id the unique ID of the book
     * @return the book, fi ti exists
     */
    public Book getBookByID(long id);

    /**
     * Perists a new Book to storage
     * @param book the book to be stored
     * @return true if the collection has changed as a result of this call.
     */
    public boolean insertBook(Book book);

    /**
     * Removes book with given id
     * @param id the id of the book to delete
     * @return true if the collection has changed as a result of this call.
     */
    public boolean deleteBook(long id);

    /**
     * Returns an array of all books
     * @return all books
     */
    public Book[] getAllBooks();

    /**
     * @param book the book to update. 
     * @return true if an entry has been changed as a result of this call
     */
    public boolean updateBook(Book book);
}