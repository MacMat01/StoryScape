package it.unicam.cs.storyscape.view;

import it.unicam.cs.storyscape.model.helper.Refactorizer;
import it.unicam.cs.storyscape.model.parser.ParsedData;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

/**
 * A renderer of a book details into a {@link GridPane}.
 */
public class BookDetails implements Render<GridPane> {

    @Override
    public void render(ParsedData data, GridPane pane) {
        Map<String, Node> labeledNodes = getLabeledNodes(pane);
        for (String propertyName : labeledNodes.keySet()) {
            Node node = labeledNodes.get(propertyName);
            if (node.getId().equals("bookImage")) {
                Platform.runLater(() -> renderBookImage(node, data.getProperty("image url")));
            } else {
                Platform.runLater(() -> renderDataOnLabel(node, data, propertyName));
            }
        }
    }

    private Map<String, Node> getLabeledNodes(GridPane pane) {
        Map<String, Node> labeledNodes = new HashMap<>();
        for (Node node : pane.getChildren()) {
            if (node instanceof Label || node instanceof ImageView) {
                labeledNodes.put(node.getId(), node);
            }
        }
        return labeledNodes;
    }

    private void renderDataOnLabel(Node node, ParsedData data, String propertyName) {
        Label label = (Label) node;
        String property = data.getProperty(propertyName);
        if (property != null) {
            if (propertyName.equals("label") || propertyName.equals("comment")) {
                label.setText(property);
            } else {
                if (propertyName.equals("type")) {
                    property = Refactorizer.polishProperty(property);
                }
                label.setText(propertyName + ": " + property);
            }
        }
    }

    private void renderBookImage(Node node, String url) {
        ImageView bookImageView = (ImageView) node;
        Image bookImage = new Image(url, true);
        bookImageView.setPreserveRatio(true);
        bookImageView.setFitWidth(280);
        bookImageView.setFitHeight(280);
        bookImageView.setImage(bookImage);
    }

}
