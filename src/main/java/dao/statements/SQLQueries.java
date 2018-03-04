package dao.statements;

import dao.entry.AuthorEntry;
import dao.entry.BookEntry;
import dao.entry.PublisherEntry;
import model.Author;
import model.Book;

public class SQLQueries {

    public static String add() {
        return "INSERT INTO " + BookEntry.Books + " ( " +
                BookEntry.ISBN + ", " +
                BookEntry.author + ", " +
                BookEntry.title + ", " +
                BookEntry.publisher + ", " +
                BookEntry.publication_year + ", " +
                BookEntry.price + ", " +
                BookEntry.type + ") " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?) ;";
    }

    public static String getBookTitles() {
        return "SELECT " + BookEntry.title +
                " FROM " + BookEntry.Books +
                " ORDER BY " + BookEntry.title + " ASC; ";
    }

    public static String deleteBook() {
        return "DELETE FROM " + BookEntry.Books.name() +
                " WHERE " + BookEntry.ISBN.name() + " = ?";
    }

    public static String getAuthors() { return "SELECT *  FROM " + AuthorEntry.Authors + "; "; }
    public static String getPublishers() { return "SELECT *  FROM " + PublisherEntry.Publishers + "; "; }
    public static String getBooks() { return "SELECT * FROM " + BookEntry.Books + "; "; }

    public static String getBooksBySearchPhrase() {
        return "SELECT " +
                BookEntry.ISBN + ", " +
                BookEntry.author + ", " +
                BookEntry.title + ", " +
                BookEntry.publisher + ", " +
                BookEntry.publication_year + ", " +
                BookEntry.price + ", " +
                BookEntry.type +
                " FROM " + BookEntry.Books +
                " WHERE " +
                BookEntry.ISBN + " LIKE ? " + " OR " +
                BookEntry.title + " LIKE ? " + " OR " +
                BookEntry.publisher + " LIKE ? " + " OR " +
                BookEntry.publication_year + " LIKE ? " + " OR " +
                BookEntry.price + " LIKE ? " +
                " ORDER BY " + BookEntry.title + " ASC; ";
    }

    public static String getBooksByAuthor() {
        return "SELECT * FROM " + BookEntry.Books + " JOIN " + AuthorEntry.Authors +
                " ON " +
                BookEntry.Books + "." + BookEntry.author + " = " +
                AuthorEntry.Authors + "." + AuthorEntry.author_id +
                " WHERE " + AuthorEntry.author_id + " = ?; ";
    }

    public static String getAmountOfAuthorsBook() {
        return "SELECT (" +
                AuthorEntry.Authors + "." + AuthorEntry.name + " || \' \' || " + AuthorEntry.Authors + "." + AuthorEntry.surname +
                ") AS " + AuthorEntry.fullname + ", " + " COUNT(*) AS " + BookEntry.booksAmount +

                " FROM " +  BookEntry.Books + " LEFT JOIN " + AuthorEntry.Authors + " ON " +
                AuthorEntry.Authors + "." + AuthorEntry.author_id + " = " +
                BookEntry.Books + "." + BookEntry.author +

                " GROUP BY " + AuthorEntry.fullname +
                " HAVING COUNT(" + BookEntry.Books + "." + BookEntry.title + ") > 0;";
    }

    public static String getBooksFromLastTenYears() {
        return "SELECT *, strftime('%Y', 'now')-10 as year FROM " + BookEntry.Books +
                " WHERE " + BookEntry.publication_year + "> year;";
    }

    public static String getMostExpensiveBook() {
        return "SELECT * FROM " + BookEntry.Books +
                " WHERE " + BookEntry.price + " = " +
                "(SELECT MAX(" + BookEntry.price + ") FROM " + BookEntry.Books + ");";
    }

    public static String getAuthorsInfo() {
        return "SELECT (" + AuthorEntry.name + " ||\' \'|| " + AuthorEntry.surname + ") AS " + AuthorEntry.fullname +
                ", " + AuthorEntry.brith_year + " FROM " + AuthorEntry.Authors + "; ";

    }
}


