package it.unicam.cs.storyscape.factorybuild;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.InputStream;
import java.util.Objects;

/**
 * Class that represents the default RDF model builder.
 */
public class DefaultRDFModelBuilder implements RDFModelBuilder {

    @Override
    public Model buildRDFModel() {
        return ModelFactory.createDefaultModel();
    }

    @Override
    public Model buildRDFModel(InputStream inputStream) {
        Model model = ModelFactory.createDefaultModel();
        RDFDataMgr.read(model, Objects.requireNonNull(inputStream), Lang.RDFXML);
        return model;
    }

    @Override
    public Model buildOntologyModel(OntModelSpec modelSpec) {
        return ModelFactory.createOntologyModel(modelSpec);
    }

    @Override
    public Model buildOntologyModel(InputStream inputStream, OntModelSpec modelSpec) {
        Model model = ModelFactory.createOntologyModel(modelSpec);
        RDFDataMgr.read(model, Objects.requireNonNull(inputStream), Lang.RDFXML);
        return model;
    }
}