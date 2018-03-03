package view;

import services.InputGetter;
import java.util.HashMap;
import java.util.Map;


public class MenuView extends View {
    private Map<String, String> mainMenu = new HashMap<>();
    private InputGetter inputGetter = new InputGetter();

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
        mainMenu.put("5. ", "Show books by given author.");
        mainMenu.put("6. ", "");
    }

    private void displayMainMenu() {
        for (String element : mainMenu.keySet()) {
            System.out.println(element + mainMenu.get(element));
        }
        System.out.println("0. Exit.");
    }

    public int askForMenuOption() {
        return inputGetter.getIntegerInput("What would you like to do?\n");
    }
}
