package it.unicam.cs.storyscape.view;

import it.unicam.cs.storyscape.parser.ParsedData;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * A renderer of a list of books into a {@link ListView}.
 */
public class BookList implements Render<ListView<BookList.BookRow>> {

    @Override
    public void render(ParsedData parsedData, ListView<BookList.BookRow> node) {
        node.getItems().clear();
        for (String key : parsedData.getKeys()) {
            node.getItems().add(new BookRow(key, parsedData.getProperty(key)));
        }

        node.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(BookRow item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.title());
                }
            }
        });
    }

    public record BookRow(String key, String title) {
    }
}