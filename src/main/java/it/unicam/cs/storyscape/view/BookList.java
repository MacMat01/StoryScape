package it.unicam.cs.storyscape.view;

import it.unicam.cs.storyscape.model.parser.ParsedData;
import javafx.scene.control.ListView;

/**
 * A renderer of a list of books into a {@link ListView}.
 */
public class BookList implements Render<ListView<String>> {

    @Override
    public void render(ParsedData parsedData, ListView<String> node) {

        node.getItems().clear();
        node.getItems().addAll(parsedData.getValues());
    }
}