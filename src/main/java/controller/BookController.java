package controller;


import dao.*;
import model.Author;
import model.Book;
import model.Publisher;
import services.ISBNgenerator;
import view.AuthorView;
import view.BookView;
import view.PublisherView;

import java.sql.SQLDataException;
import java.util.List;

public class BookController {
    private BookDAO bookDAO = new DbBookDAO();
    private BookView bookView = new BookView();
    private AuthorView authorView = new AuthorView();
    private PublisherView publisherView = new PublisherView();

    public void getAllBookTitles() {
        List<String> bookTitles = bookDAO.getAllBookTitles();
        bookView.displayBookTitles(bookTitles);
    }

    public void addBook() {
        Book book = createBook();
        if (book != null) bookDAO.add(book);
    }

    private Book createBook() {
        try {
            return new Book(
                    generateISBForNewBook(),
                    pickAuthor().getId(),
                    bookView.askForTitle(),
                    pickPublisher().getPublisherId(),
                    bookView.askForPublicationYear(),
                    bookView.askForPrice(),
                    bookView.askForType()
            );
        } catch (IllegalArgumentException e) { System.out.println("Operation has been failed!"); }

        return null;
    }

    private Long generateISBForNewBook() {
        ISBNgenerator generator = new ISBNgenerator();
        return generator.numberGenerator();
    }

    private Author pickAuthor() throws IllegalArgumentException {
        AuthorDAO authorDAO = new DbAuthorDAO();
        List<Author> authors = authorDAO.getAuthors();

        authorView.displayAuthors(authors);
        int author_id = authorView.askForAuthorID();

        for (Author person : authors) {
            if (person.getId() == author_id) return person;
        }
        throw new IllegalArgumentException();
    }


    private Publisher pickPublisher() throws IllegalArgumentException {
        PublisherDAO publisherDAO = new DbPublisherDAO();
        List<Publisher> publishers = publisherDAO.getPublishers();

        publisherView.displayPublishers(publishers);
        String publisher_id = publisherView.askForPublisher();

        for (Publisher element : publishers) {
            if (element.getPublisherId().equals(publisher_id)) return element;
        }
        throw new IllegalArgumentException();
    }

    public void deleteBook() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            bookView.displayBooksForDelete(books);

            Long ISBN = bookView.askForISBN();
            bookDAO.deleteBookBy(ISBN);

        } catch (SQLDataException e) { System.out.println("Records loading has been failed!"); }
    }

    public void searchForBookByPhrase() {
        String searchPhrase = bookView.askForSearchPhrase();
        List<Book> books = bookDAO.getBookBy(searchPhrase);
        bookView.displayBooksInfo(books);
    }

    public void getBooksByAuthor() {
        try {
            Author author = pickAuthor();

            List<Book> books = bookDAO.getBookBy(author.getId());
            bookView.displayBooksInfo(books);

        } catch (IllegalArgumentException e) {
            System.err.println("Operation has been failed!");
        }
    }
}
