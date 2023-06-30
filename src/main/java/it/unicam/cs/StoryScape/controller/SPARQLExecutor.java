package it.unicam.cs.StoryScape.controller;

import it.unicam.cs.StoryScape.model.SPARQL.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.Model;

/**
 * Interface that represents the SPARQL executor.
 */
public interface SPARQLExecutor {

    /**
     * Method that executes a SPARQL query on the RDF model.
     *
     * @param query the SPARQL query
     * @param model the RDF model
     * @return the query execution
     */
    QueryExecution executeSPARQLQuery(Query query, Model model);

    /**
     * Method that executes a SPARQL query on the RDF model with arguments.
     *
     * @param query the SPARQL query
     * @param model the RDF model
     * @param args  the arguments of the query
     * @return the query execution
     */
    QueryExecution executeSPARQLQuery(Query query, Model model, Object... args);
}
