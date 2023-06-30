package it.unicam.cs.StoryScape.controller;


import it.unicam.cs.StoryScape.model.SPARQL.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Model;

/**
 * Class that represents ontology SPARQL executor.
 */
public class OntologySPARQLExec implements SPARQLExecutor {

    @Override
    public QueryExecution executeSPARQLQuery(Query query, Model model) {
        return executeSPARQLQuery(query.getFullQuery(), model);
    }

    @Override
    public QueryExecution executeSPARQLQuery(Query query, Model model, Object... args) {
        String fullQuery = String.format(query.getFullQuery(), args);
        return executeSPARQLQuery(fullQuery, model);
    }

    private QueryExecution executeSPARQLQuery(String fullQuery, Model model) {
        return QueryExecutionFactory.create(fullQuery, model);
    }
}