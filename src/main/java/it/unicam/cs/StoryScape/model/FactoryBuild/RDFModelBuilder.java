package it.unicam.cs.StoryScape.model.FactoryBuild;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;

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
     * Method that builds the RDF model from a file.
     *
     * @param path the path of the file
     * @return the RDF model
     */
    Model buildRDFModel(String path);

    /**
     * Method that builds an ontology model.
     *
     * @param modelSpec the model specification
     *                  (e.g. OntModelSpec.OWL_MEM)
     * @return the ontology model
     */
    Model buildOntologyModel(OntModelSpec modelSpec);

    /**
     * Method that builds an ontology model from a file.
     *
     * @param path      the path of the file
     * @param modelSpec the model specification
     *                  (e.g. OntModelSpec.OWL_MEM)
     * @return the ontology model
     */
    Model buildOntologyModel(String path, OntModelSpec modelSpec);
}