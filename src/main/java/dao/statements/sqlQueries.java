package dao.statements;

import dao.entry.BookEntry;

public class sqlQueries {

    public static String add() {
        return "INSERT INTO " + BookEntry.Books.name() + " ( " +
                BookEntry.ISBN.name() + ", " +
                BookEntry.author.name() + ", " +
                BookEntry.title.name() + ", " +
                BookEntry.publisher.name() + ", " +
                BookEntry.publication_year.name() + ", " +
                BookEntry.price.name() + ", " +
                BookEntry.type.name() + ") " +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ? ); ";

    }

    public static String showBooks() {
        return "SELECT " + BookEntry.title.name() + " FROM " + BookEntry.Books.name() + "; ";
    }
}
