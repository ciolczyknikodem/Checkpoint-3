package view;

import model.Author;
import services.InputGetter;

import java.util.List;

public class AuthorView extends View {
    private InputGetter inputGetter = new InputGetter();

    public void displayAuthors(List<Author> authors) {
        Iterator<Object> iterator = new Iterator<>(authors.toArray());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public int askForAuthorID() { return inputGetter.getIntegerInput("Enter id of author you want to choose: "); }
}
