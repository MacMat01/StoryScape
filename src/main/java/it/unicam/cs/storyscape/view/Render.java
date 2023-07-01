package it.unicam.cs.storyscape.view;

import it.unicam.cs.storyscape.model.parser.ParsedData;
import javafx.scene.Node;

/**
 * A functional interface that represents a renderer of data into a UI component.
 *
 * @param <T> the type of the UI component to render the data into
 */
public interface Render<T extends Node> {

    /**
     * Renders the given data into the specified UI component.
     *
     * @param parsedData the data to render
     * @param node       the UI component to render the data into
     */
    void render(ParsedData parsedData, T node);

}
