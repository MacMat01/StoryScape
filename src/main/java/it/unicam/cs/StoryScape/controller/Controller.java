package it.unicam.cs.StoryScape.controller;

import it.unicam.cs.StoryScape.model.FactoryBuild.InferredRDFModelBuilder;
import it.unicam.cs.StoryScape.model.URIs;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;

/**
 * Class that represents the controller of the StoryScape app.
 */
public class Controller {

    private final InferredRDFModelBuilder inferredRDFModelBuilder = new InferredRDFModelBuilder();
    //    private final OntologySPARQLExec sparqlExec = new OntologySPARQLExec();
    private Model model;

    public Controller() {
        this.model = inferredRDFModelBuilder.buildOntologyModel(URIs.SFO.getURI(), OntModelSpec.OWL_DL_MEM);
        this.startInference();
    }

    /**
     * Method that starts the inference.
     */
    public void startInference() {
        this.model = inferredRDFModelBuilder.buildInferredModel(model, PelletReasonerFactory.THE_SPEC.getReasoner());
    }

    /**
     * Method that checks if the model is consistent.
     *
     * @return true if the model is consistent, false otherwise.
     */
    public boolean isConsistent() {
        return inferredRDFModelBuilder.isConsistent((InfModel) model);
    }

}
