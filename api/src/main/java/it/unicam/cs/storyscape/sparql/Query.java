package it.unicam.cs.storyscape.sparql;

/**
 * Interface that represents a SPARQL query.
 */
public interface Query {

    /**
     * Get the prefixes of the query.
     *
     * @return the prefixes of the query.
     */
    static String getPrefixes() {
        return """
                PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                PREFIX owl: <http://www.w3.org/2002/07/owl#>
                PREFIX dc: <http://purl.org/dc/elements/1.1/>
                PREFIX dcterms: <http://purl.org/dc/terms/>
                PREFIX sfo: <https://www.cs.unicam.it/matteo.machella/sci-fi-ontology.rdf#>
                PREFIX powder: <http://www.w3.org/2007/05/powder-s#>
                PREFIX prov: <http://www.w3.org/ns/prov#>
                PREFIX xml: <http://www.w3.org/XML/1998/namespace>
                PREFIX person: <http://dbpedia.org/ontology/Person/>
                PREFIX ontology: <http://dbpedia.org/ontology/>
                """;
    }

    /**
     * Returns the query as a string.
     *
     * @return the query as a string.
     */
    String getQuery();

    /**
     * Returns the query formatted with the specified arguments.
     *
     * @param args the arguments to be used in the query.
     * @return the query formatted with the specified arguments.
     */
    String getQuery(Object... args);

    /**
     * Returns the full query.
     * The full query is the query with the prefixes.
     *
     * @return the full query.
     */
    default String getFullQuery() {
        return getPrefixes() + getQuery();
    }

    /**
     * Returns the full query formatted with the specified arguments.
     * The full query is the query with the prefixes.
     *
     * @param args the arguments to be used in the query.
     * @return the full query formatted with the specified arguments.
     */
    default String getFullQuery(Object... args) {
        return getPrefixes() + getQuery(args);
    }
}
