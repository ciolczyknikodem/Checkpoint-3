package controller;

import dao.*;
import model.Author;
import model.Book;
import model.Publisher;
import services.ISBNgenerator;
import view.menuView;

import java.util.List;

public class mainController {
    private menuView view = new menuView();
    private BookDAO booksDAO = new DbBookDAO();

    public void runMainMenu() {
        boolean isExit = false;

        while(!isExit) {
            view.handleMainMenu();

            switch(view.askForMenuOption()) {

                case 1 :
                    List<String> books = booksDAO.getAllBookTitles();
                    view.displayBooksInCollection(books);
                    break;

                case 2 :
                    addNewBook();
                    break;

                case 3 :
                    break;

                case 4 :
                    break;

                case 5 :
                    break;

                case 6 :
                    break;

                case 0 :
                    isExit = true;
                    break;
            }
        }
    }

    private void addNewBook() {
        Book book = createBook();
        booksDAO.add(book);
    }

    private Book createBook() {
        try {
            return new Book(
                    generateISBForNewBook(),
                    pickAuthor().getId(),
                    view.askForTitle(),
                    pickPublisher().getPublisherId(),
                    view.askForPublicationYear(),
                    view.askForPrice(),
                    view.askForType()
            );
        } catch (IllegalArgumentException e) { System.out.println("Operation has been failed!"); }

        return null;
    }

    private Author pickAuthor() throws IllegalArgumentException {
        AuthorDAO authorDAO = new DbAuthorDAO();
        List<Author> authors = authorDAO.getAuthors();

        view.displayAuthors(authors);
        int author_id = view.askForAuthor();

        for (Author person : authors) {
            if (person.getId() == author_id) return person;
        }
        throw new IllegalArgumentException();
    }

    private Publisher pickPublisher() throws IllegalArgumentException {
        PublisherDAO publisherDAO = new DbPublisherDAO();
        List<Publisher> publishers = publisherDAO.getPublishers();

        view.displayPublishers(publishers);
        String publisher_id = view.askForPublisher();

        for (Publisher element : publishers) {
            if (element.getPublisherId().equals(publisher_id)) return element;
        }
        throw new IllegalArgumentException();
    }

    private Long generateISBForNewBook() {
        ISBNgenerator generator = new ISBNgenerator();
        return generator.numberGenerator();
    }
}
