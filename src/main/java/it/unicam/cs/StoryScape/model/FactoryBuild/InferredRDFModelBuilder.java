package it.unicam.cs.StoryScape.model.FactoryBuild;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;

/**
 * Class that represents the inferred RDF model builder.
 */
public class InferredRDFModelBuilder extends DefaultRDFModelBuilder {

    /**
     * Creates a new inferred RDF model.
     *
     * @param model    the model to be inferred
     * @param reasoner the reasoner to be used
     * @return the inferred model
     */
    public InfModel buildInferredModel(Model model, Reasoner reasoner) {
//        reasoner = reasoner.bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }

    /**
     * Checks if the model is consistent.
     *
     * @return true if the model is consistent, false otherwise.
     */
    public boolean isConsistent(InfModel model) {
        return model.validate().isValid();
    }

    /**
     * Checks if the inference is valid.
     *
     * @return true if the inference is valid, false otherwise.
     */
    public boolean isValidInference(InfModel model, Resource subject, Property predicate, Resource object) {
        return model.contains(subject, predicate, object);
    }
}