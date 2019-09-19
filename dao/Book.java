package dao;

public class Book {
    // ID cannot change once set
    private final long id;
    private String title, author;
    private int pageCount;
    private double price;

    public Book(String title, String author, int pageCount, double price) {
        id = System.currentTimeMillis();
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    public Book(long id) {
        this.id = id;
    }

    public String toString() {
        return id+"|"+title +"|"+author+"|"+pageCount+"|"+price;
    }

    public long getID () {
        return id;
    }

    public String getTitle() {
		return this.title;
	}

    public void setTitle(String title) {
		this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}