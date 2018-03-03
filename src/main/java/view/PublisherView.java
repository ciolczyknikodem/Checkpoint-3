package view;

import model.Publisher;
import services.InputGetter;

import java.util.List;

public class PublisherView extends View {
    private InputGetter inputGetter = new InputGetter();


    public void displayPublishers(List<Publisher> publishers) {
        Iterator<Object> iterator = new Iterator<>(publishers.toArray());
        while(iterator.hasNext()) { System.out.println(iterator.next().toString()); }
    }

    public String askForPublisher() { return inputGetter.getStringInput("Enter publisher: "); }
}
