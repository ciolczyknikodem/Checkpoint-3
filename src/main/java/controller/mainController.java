package controller;

import dao.BookDAO;
import dao.DBBookDAO;
import view.menuView;

import java.util.List;

public class mainController {
    private menuView view = new menuView();
    private BookDAO booksDAO = new DBBookDAO();

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
}
