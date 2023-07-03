package it.unicam.cs.storyscape.sparql;

import it.unicam.cs.storyscape.factorybuild.Controller;
import it.unicam.cs.storyscape.parser.ParsedData;

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

    /**
     * Returns the ontology consistency status
     *
     * @return the ontology consistency status as a string
     */
    public String getConsistencyStatus() {
        if (controller.isConsistent()) {
            return "Ontology consistent";
        } else {
            return "Inconsistent ontology";
        }
    }

}
