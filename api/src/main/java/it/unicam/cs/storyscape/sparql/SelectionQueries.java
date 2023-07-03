package it.unicam.cs.storyscape.sparql;

/**
 * Enum that represents all the selection queries.
 */
public enum SelectionQueries implements Query {

    BOOK_LIST("SELECT ?label ?value WHERE { ?book rdf:type <https://www.cs.unicam.it/matteo.machella/sci-fi-ontology.rdf#sfo:Book> . BIND(?book AS ?label) . ?book rdfs:label ?value . }"),
    BOOK_DETAILS("SELECT ?label ?value WHERE { ?book rdf:type <https://www.cs.unicam.it/matteo.machella/sci-fi-ontology.rdf#sfo:Book> . ?book rdfs:label \"%s\" . ?book ?label ?value . }"),
    SEARCH_BOOK("SELECT ?label ?value WHERE { ?book rdf:type <https://www.cs.unicam.it/matteo.machella/sci-fi-ontology.rdf#sfo:Book> . BIND(?book AS ?label) . ?book rdfs:label ?label . FILTER STRSTARTS(?value, \"%s\")}");

    private final String query;

    SelectionQueries(String query) {
        this.query = query;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public String getQuery(Object... args) {
        return query.formatted(args);
    }

    @Override
    public String getFullQuery() {
        return Query.super.getFullQuery();
    }

    @Override
    public String getFullQuery(Object... args) {
        return Query.super.getFullQuery(args);
    }
}
