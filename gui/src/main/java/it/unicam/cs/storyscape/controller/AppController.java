package it.unicam.cs.storyscape.controller;

import it.unicam.cs.storyscape.helper.Refactorizer;
import it.unicam.cs.storyscape.sparql.QuerySelector;
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
    private ListView<BookList.BookRow> booksList;

    @FXML
    private TextField bookSearchBar;

    @FXML
    private GridPane bookDetailView;

    /**
     * Instantiates a new App controller.
     */
    public AppController() {
        this.bookListRender = new BookList();
        this.bookDetailsRender = new BookDetails();
        this.querySelector = new QuerySelector();
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
        BookList.BookRow selectedItem = booksList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            bookDetailsRender.render(querySelector.getBookDetails(selectedItem.key()), bookDetailView);
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
