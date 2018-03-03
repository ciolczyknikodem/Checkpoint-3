package view;

import model.Book;
import services.InputGetter;

import java.util.List;

public class BookView extends View {
    private InputGetter inputGetter = new InputGetter();

    public void displayBookTitles(List<String> books) {
        System.out.println("Book titles in collection: ");
        for (String title : books) { System.out.println(title); }
    }

    public void displayBooksForDelete(List<Book> books) {
        System.out.println("Which book do you want to delete?");

        for (Book element : books) {
            System.out.println("ISBN number: " + element.getISBN() + ", title: " + element.getTitle());
        }
    }

    public void displayBooksInfo(List<Book> books) {
        for (Book element : books ) {
            System.out.println(element.toString());
        }
        inputGetter.promptUserToPressEnter();
    }



    public Long askForISBN() { return inputGetter.getLongInput("Enter ISBN number: "); }

    public String askForTitle() { return inputGetter.getStringInput("Enter title: "); }
    public String askForSearchPhrase() { return inputGetter.getStringInput("Enter phrase for search: "); }

    public int askForPublicationYear() { return inputGetter.getIntegerInput("Enter year of publication: "); }
    public int askForPrice() { return inputGetter.getIntegerInput("Enter price: "); }
    public int askForType() { return inputGetter.getIntegerInput("What type is this book?\n1 = E-book, 2 = PrintBook"); }
}
