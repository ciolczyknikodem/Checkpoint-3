package model;

public class Book {

    private Long ISBN;
    private int author;
    private String title;
    private String publisher;
    private int publicationYear;
    private int price;
    private int type;

    public Book(
            int author,
            String title,
            String publisher,
            int publicationYear,
            int price,
            int type
    ) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = type;
    }

    public Book(
            Long ISBN,
            int author,
            String title,
            String publisher,
            int publicationYear,
            int price,
            int typeID
    ) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = typeID;
    }

    public Long getISBN() { return ISBN; }
    public int getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }
    public int getPrice() { return price; }
    public int getType() { return type; }

    public String toString() {
        return "ISBN: " + ISBN + ", " +
                author + ", " +
                title + ", " +
                publisher + ", " +
                price + ", " +
                type;
    }
}
