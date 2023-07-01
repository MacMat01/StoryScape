package it.unicam.cs.storyscape.controller;

import it.unicam.cs.storyscape.model.sparql.SelectionQueries;
import it.unicam.cs.storyscape.model.parser.ParsedData;

/**
 * Class that represents the query selector.
 */
public class QuerySelector {

    private final Controller controller = new Controller();

    /**
     * Returns the list of books in the ontology.
     *
     * @return the list of books
     */
    public ParsedData getBooks() {
        return controller.getData(SelectionQueries.BOOK_LIST);
    }

    /**
     * Returns the details of a book.
     *
     * @param book the book
     * @return the details of the book
     */
    public ParsedData getBookDetails(String book) {
        return controller.getData(SelectionQueries.BOOK_DETAILS, book);
    }

    /**
     * Returns the list of books that start with the given string.
     *
     * @param book the book
     * @return the list of books that start with the given string
     */
    public ParsedData searchBook(String book) {
        return controller.getData(SelectionQueries.SEARCH_BOOK, book);
    }

}
