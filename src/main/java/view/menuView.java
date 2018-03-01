package view;

import model.Author;
import model.Book;
import model.Publisher;
import services.InputGetter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class menuView extends View{
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
        return inputGetter.getIntegerInput("What would you like to do?\n");
    }

    public void displayBooksInCollection(List<String> books) {
        System.out.println("Books titles collection: ");
        for (String title : books) { System.out.println(title); }
    }

    public void displayBooksForDelete(List<Book> books) {
        System.out.println("Which book do you want to delete?");

        for (Book element : books) {
            System.out.println("ISBN number: " + element.getISBN() + ", title: " + element.getTitle());
        }
    }

    public String askForAuthorName() { return inputGetter.getStringInput("Enter author name: "); }
    public String askForTitle() { return inputGetter.getStringInput("Enter title: "); }
    public String askForPublisher() { return inputGetter.getStringInput("Enter publisher: "); }
    public Long askForISBN() { return inputGetter.getLongInput("Enter ISBN number: "); }
    public int askForPublicationYear() { return inputGetter.getIntegerInput("Enter year of publication: "); }
    public int askForPrice() { return inputGetter.getIntegerInput("Enter price: "); }
    public int askForType() { return inputGetter.getIntegerInput("What type is this book?\n1 = E-book, 2 = PrintBook"); }


    public void displayAuthors(List<Author> authors) {
        for (Author person : authors) {
            System.out.println(person.toString());
        }
    }

    public int askForAuthor() { return inputGetter.getIntegerInput("Enter id of author you want to choose: "); }

    public void displayPublishers(List<Publisher> publishers) {
        for (Publisher element : publishers) { System.out.println(element.toString()); }
    }
}
