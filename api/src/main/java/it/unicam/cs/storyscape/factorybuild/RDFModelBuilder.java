package it.unicam.cs.storyscape.factorybuild;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;

import java.io.InputStream;

/**
 * Interface that represents the RDF model builder.
 */
public interface RDFModelBuilder {

    /**
     * Method that builds the RDF model.
     *
     * @return the RDF model
     */
    Model buildRDFModel();

    /**
     * Method that builds the RDF from the stream of a file resource.
     *
     * @param inputStream the stream of the file resource
     * @return the RDF model
     */
    Model buildRDFModel(InputStream inputStream);

    /**
     * Method that builds an ontology model.
     *
     * @param modelSpec the model specification
     *                  (e.g. OntModelSpec.OWL_MEM)
     * @return the ontology model
     */
    Model buildOntologyModel(OntModelSpec modelSpec);

    /**
     * Method that builds an ontology model from a stream of a file resource.
     *
     * @param inputStream      the stream of the file resource
     * @param modelSpec the model specification
     *                  (e.g. OntModelSpec.OWL_MEM)
     * @return the ontology model
     */
    Model buildOntologyModel(InputStream inputStream, OntModelSpec modelSpec);
}