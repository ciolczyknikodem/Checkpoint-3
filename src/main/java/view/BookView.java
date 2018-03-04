package view;

import model.Book;
import services.InputGetter;
import java.util.Arrays;
import java.util.List;

public class BookView extends View {
    private InputGetter inputGetter = new InputGetter();

    public void displayBookTitles(List<String> books) {
        Iterator<Object> iterator = new Iterator<>(books.toArray());

        System.out.println("Book titles in collection: ");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        inputGetter.promptUserToPressEnter();
    }

    public void displayBooksForDelete(List<Book> books) {
        Iterator<Object> iterator = new Iterator<>(books.toArray());

        System.out.println("Which book do you want to delete?");
        while (iterator.hasNext()) {

            Book book = (Book) iterator.next();
            System.out.println("ISBN number: " + book.getISBN() + ", title: " + book.getTitle());
        }
    }

    public void displayBooksInfo(List<Book> books) {
        Iterator<Object> iterator = new Iterator<>(books.toArray());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        inputGetter.promptUserToPressEnter();
    }

    public void displayBooksFromLastTenYears(List<Book> books) {
        Iterator<Object> iterator = new Iterator<>(books.toArray());

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            String line = String.format("%-32s %12s %-6d", book.getTitle(), "publication year: ", book.getPublicationYear());

            System.out.println(line);
        }
        inputGetter.promptUserToPressEnter();
    }



    public Long askForISBN() { return inputGetter.getLongInput("Enter ISBN number: "); }

    public String askForTitle() { return inputGetter.getStringInput("Enter title: "); }
    public String askForSearchPhrase() { return inputGetter.getStringInput("Enter phrase for search: "); }

    public int askForPublicationYear() { return inputGetter.getIntegerInput("Enter year of publication: "); }
    public int askForPrice() { return inputGetter.getIntegerInput("Enter price: "); }

    public int askForType() {
        String option[] = new String[] {"1", "2"};
        String input = "";

        boolean incorrectInput = true;
        while (incorrectInput) {
            input = inputGetter.getStringInput("What type is this book?\n1 = E-book, 2 = PrintBook");
            incorrectInput = !Arrays.asList(option).contains(input);
        }

        return Integer.parseInt(input);
    }
}
