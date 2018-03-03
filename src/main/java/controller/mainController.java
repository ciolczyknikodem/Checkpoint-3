package controller;

import dao.*;
import model.Author;
import model.Book;
import model.Publisher;
import services.ISBNgenerator;
import view.menuView;

import java.sql.SQLDataException;
import java.util.List;

public class mainController {
    private menuView view = new menuView();
    private BookDAO booksDAO = new DbBookDAO();
    private BookController bookController = new BookController();
    private AuthorController authorController = new AuthorController();

    public void runMainMenu() {
        boolean isExit = false;

        while(!isExit) {
            view.handleMainMenu();

            switch(view.askForMenuOption()) {

                case 1 :
                    bookController.getAllBookTitles();
                    break;

                case 2 :
                    bookController.addBook();
                    break;

                case 3 :
                    bookController.deleteBook();
                    break;

                case 4 :
                    bookController.searchForBookByPhrase();
                    break;

                case 5 :
                    bookController.getBooksByAuthor();
                    break;

                case 6 :
                    break;

                case 0 :
                    isExit = true;
                    break;
            }
        }
    }
}
