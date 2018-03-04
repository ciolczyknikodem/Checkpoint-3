package view;

import model.Author;
import services.InputGetter;

import java.util.List;
import java.util.Map;

public class AuthorView extends View {
    private InputGetter inputGetter = new InputGetter();

    public void displayAuthors(List<Author> authors) {
        Iterator<Object> iterator = new Iterator<>(authors.toArray());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void displayAmountOfAuthorsBook(Map<String, Integer> booksAmount) {
        String tableInfo = String.format("%-17s %20s", "Author name", "Amount of written books:");
        System.out.println(tableInfo + "\n");

        for (String author : booksAmount.keySet()) {
            String line = String.format("%-15s %2s %-10s", author, "|", booksAmount.get(author));
            System.out.println(line);

        }
        inputGetter.promptUserToPressEnter();
    }

    public void displayAuthorsInfo(Map<String, String> authorsInfo) {
        for (String author : authorsInfo.keySet()) {
            String line = String.format("%-15s %-8s", author, authorsInfo.get(author));
            System.out.println(line);
        }
        inputGetter.promptUserToPressEnter();
    }

    public int askForAuthorID() { return inputGetter.getIntegerInput("Enter id of author you want to choose: "); }
}
