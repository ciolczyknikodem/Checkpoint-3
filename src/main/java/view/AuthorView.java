package view;

import model.Author;
import services.InputGetter;

import java.util.List;

public class AuthorView extends View {
    private InputGetter inputGetter = new InputGetter();

    public void displayAuthors(List<Author> authors) {
        for (Author person : authors) {
            System.out.println(person.toString());
        }
    }

    public int askForAuthor() { return inputGetter.getIntegerInput("Enter id of author you want to choose: "); }
}
