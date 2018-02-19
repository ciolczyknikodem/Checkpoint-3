package model;

public class Book extends TypeBook {

    private int ISBN;
    private String author;
    private String title;
    private String publisher;
    private int publicatioinYear;
    private int price;

    public Book(String type, int typeID, int ISBN, String author, String title, String publisher, int publicatioinYear, int price) {
        super(type, typeID);
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicatioinYear = publicatioinYear;
        this.price = price;
    }
}
