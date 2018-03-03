package view;

import model.Publisher;
import services.InputGetter;

import java.util.List;

public class PublisherView extends View {
    private InputGetter inputGetter = new InputGetter();


    public void displayPublishers(List<Publisher> publishers) {
        for (Publisher element : publishers) { System.out.println(element.toString()); }
    }

    public String askForPublisher() { return inputGetter.getStringInput("Enter publisher: "); }
}
