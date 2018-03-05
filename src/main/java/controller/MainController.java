package controller;

import view.MenuView;

public class MainController {
    private MenuView view = new MenuView();
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
                    authorController.showAmountOfAuthorsBooks();
                    break;

                case 7 :
                    bookController.getBooksFromLastTenYears();
                    break;

                case 8 :
                    bookController.getMostExpensiveBook();
                    break;

                case 9 :
                    authorController.getInfoAboutAuthors();
                    break;

                case 0 :
                    isExit = true;
                    break;
            }
        }
    }
}
