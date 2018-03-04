package controller;

import dao.AuthorDAO;
import dao.DbAuthorDAO;
import view.AuthorView;

import java.util.Map;

public class AuthorController {
    private AuthorDAO authorDAO = new DbAuthorDAO();
    private AuthorView authorView = new AuthorView();

    public void showAmountOfAuthorsBooks() {
        Map<String, Integer> amountOfAuthorsBooks = authorDAO.getAmountOfAuthorBooks();
        authorView.displayAmountOfAuthorsBook(amountOfAuthorsBooks);
    }

    public void getInfoAboutAuthors() {
        Map<String, String> authorsInfo = authorDAO.getInfoAboutAuthors();
        authorView.displayAuthorsInfo(authorsInfo);
    }
}
