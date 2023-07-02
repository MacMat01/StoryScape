package it.unicam.cs.storyscape.helper;

/**
 * Enumeration that contains all the URIs used in the ontology.
 */
public enum URIs {

    XSD("http://www.w3.org/2001/XMLSchema#"),
    RDF("http://www.w3.org/1999/02/22-rdf-syntax-ns#"),
    RDFS("http://www.w3.org/2000/01/rdf-schema#"),
    OWL("http://www.w3.org/2002/07/owl#"),
    DC("http://purl.org/dc/elements/1.1/"),
    DCTERMS("http://purl.org/dc/terms/"),
    SFO("sci-fi-ontology.rdf"),
    POWDER("http://www.w3.org/2007/05/powder-s#"),
    PROV("http://www.w3.org/ns/prov#"),
    XML("http://www.w3.org/XML/1998/namespace");

    private final String uri;

    URIs(String uri) {
        this.uri = uri;
    }

    public String getURI() {
        return uri;
    }
}
