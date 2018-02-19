package view;

import services.InputGetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class menuView extends View{
    private Map<String, String> mainMenu = new HashMap<String, String>();

    public void handleMainMenu() {
        clearScreen();
        prepareMainMenu();
        displayMainMenu();
    }

    private void prepareMainMenu() {
        mainMenu.put("1. ", "List books.");
        mainMenu.put("2. ", "Add new book.");
        mainMenu.put("3. ", "Remove a book from collection.");
        mainMenu.put("4. ", "Search for a book.");
        mainMenu.put("5. ", "Save this address book.");
        mainMenu.put("6. ", "Show books by given author.");
    }

    private void displayMainMenu() {
        for (String element : mainMenu.keySet()) {
            System.out.println(element + mainMenu.get(element));
        }
        System.out.println("0. Back to main menu.");
    }

    public int askForMenuOption() {
        return InputGetter.getIntegerInput("What would you like to do?\n");
    }

    public void displayBooksInCollection(List<String> books) {
        System.out.println("Books collection: ");

        for (String title : books) {
            System.out.println("Title: " + title);
        }
    }
}
