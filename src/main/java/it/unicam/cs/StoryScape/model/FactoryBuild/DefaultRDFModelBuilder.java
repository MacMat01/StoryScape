package it.unicam.cs.StoryScape.model.FactoryBuild;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;

import java.util.Objects;

/**
 * Class that represents the default RDF model builder.
 */
public class DefaultRDFModelBuilder implements RDFModelBuilder {

    private final FileManager fileManager = FileManager.getInternal();

    @Override
    public Model buildRDFModel() {
        return ModelFactory.createDefaultModel();
    }

    @Override
    public Model buildRDFModel(String path) {
        Model model = ModelFactory.createDefaultModel();
        RDFDataMgr.read(model, Objects.requireNonNull(fileManager.open(path)), null);
        return model;
    }

    @Override
    public Model buildOntologyModel(OntModelSpec modelSpec) {
        return ModelFactory.createOntologyModel(modelSpec);
    }

    @Override
    public Model buildOntologyModel(String path, OntModelSpec modelSpec) {
        Model model = ModelFactory.createOntologyModel(modelSpec);
        RDFDataMgr.read(model, Objects.requireNonNull(fileManager.open(path)), null);
        return model;
    }
}