package dao.statements;

import dao.entry.AuthorEntry;
import dao.entry.BookEntry;
import dao.entry.PublisherEntry;
import model.Author;
import model.Book;

public class SQLQueries {

    public static String add() {
        return "INSERT INTO " + BookEntry.Books.name() + " ( " +
                BookEntry.ISBN.name() + ", " +
                BookEntry.author.name() + ", " +
                BookEntry.title.name() + ", " +
                BookEntry.publisher.name() + ", " +
                BookEntry.publication_year.name() + ", " +
                BookEntry.price.name() + ", " +
                BookEntry.type.name() + ") " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?) ;";
    }

    public static String getBookTitles() {
        return "SELECT " + BookEntry.title.name() +
                " FROM " + BookEntry.Books.name() +
                " ORDER BY " + BookEntry.title.name() + " ASC; ";
    }

    public static String deleteBook() {
        return "DELETE FROM " + BookEntry.Books.name() +
                " WHERE " + BookEntry.ISBN.name() + " = ?";
    }

    public static String getAuthors() { return "SELECT *  FROM " + AuthorEntry.Authors.name() + "; "; }
    public static String getPublishers() { return "SELECT *  FROM " + PublisherEntry.Publishers.name() + "; "; }
    public static String getBooks() { return "SELECT * FROM " + BookEntry.Books.name() + "; "; }
}


