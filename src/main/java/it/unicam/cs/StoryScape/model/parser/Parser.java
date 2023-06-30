package it.unicam.cs.StoryScape.model.parser;

import org.apache.jena.query.QueryExecution;

/**
 * Interface that represents the parser wich parses the SPARQL query .
 */
public interface Parser {

    /**
     * Method that parses the SPARQL query.
     *
     * @param query the SPARQL query
     * @return the query execution
     */
    JSONData parse(QueryExecution query);
}