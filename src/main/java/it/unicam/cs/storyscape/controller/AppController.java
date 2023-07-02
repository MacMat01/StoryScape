package it.unicam.cs.storyscape.controller;

import it.unicam.cs.storyscape.model.helper.Refactorizer;
import it.unicam.cs.storyscape.view.BookDetails;
import it.unicam.cs.storyscape.view.BookList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javax.inject.Inject;

/**
 * Controller class for the application.
 */
public class AppController {

    private final QuerySelector querySelector;

    private final BookList bookListRender;

    private final BookDetails bookDetailsRender;

    @FXML
    private Label ontologyStatus;

    @FXML
    private ListView<String> booksList;


    @FXML
    private TextField bookSearchBar;

    @FXML
    private GridPane bookDetailView;

    /**
     * Instantiates a new App controller.
     *
     * @param querySelector     the query selector
     * @param bookListRender    the book list render
     * @param bookDetailsRender the book details render
     */
    @Inject
    public AppController(QuerySelector querySelector, BookList bookListRender, BookDetails bookDetailsRender) {
        this.bookListRender = bookListRender;
        this.bookDetailsRender = bookDetailsRender;
        this.querySelector = querySelector;
    }

    public void initialize() {
        ontologyStatus.setText(querySelector.getConsistencyStatus());
        bookDetailView.setVisible(false);
        bookListRender.render(querySelector.getBooks(), booksList);
    }

    /**
     * Handles the click on a book in the list.
     */
    @FXML
    private void handleClickOnBook() {
        if (bookDetailView.isVisible()) {
            cleanBookDetailFields();
        }
        String selectedItem = booksList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            bookDetailsRender.render(querySelector.getBookDetails(selectedItem), bookDetailView);
            bookDetailView.setVisible(true);
        }
    }

    /**
     * Handles the key typed event on the search bar.
     */
    @FXML
    private void handleKeyTypedOnSearchBar() {
        String searchedText = bookSearchBar.getCharacters().toString();
        if (searchedText.isEmpty()) {
            bookListRender.render(querySelector.getBooks(), booksList);
        } else {
            searchedText = Refactorizer.firstLetterToUpperCase(searchedText);
            bookListRender.render(querySelector.searchBook(searchedText), booksList);
        }
    }

    /**
     * Cleans the book detail fields.
     */
    private void cleanBookDetailFields() {
        ObservableList<Node> bookDetails = bookDetailView.getChildren();
        for (Node node : bookDetails) {
            if (node instanceof Label label) {
                label.setText(Refactorizer.camelCaseToWords(node.getId()) + ": ");
            }
            if (node instanceof ImageView imageView) {
                imageView.setImage(null);
            }
        }
    }

}