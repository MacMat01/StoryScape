package it.unicam.cs.storyscape.test.factorybuild;

import it.unicam.cs.storyscape.factorybuild.DefaultRDFModelBuilder;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class DefaultRDFModelBuilderTest {

    private final DefaultRDFModelBuilder rdfModelBuilder = new DefaultRDFModelBuilder();

    @Test
    void buildRDFModel_ShouldCreateDefaultModel() {
        Model model = rdfModelBuilder.buildRDFModel();

        Assertions.assertNotNull(model);
    }

    @Test
    void buildRDFModel_WithValidPath_ShouldReadModelFromFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sci-fi-ontology.rdf");

        Model model = rdfModelBuilder.buildRDFModel(inputStream);

        Assertions.assertNotNull(model);
    }

    @Test
    void buildRDFModel_WithInvalidPath_ShouldThrowNullPointerException() {
        InputStream invalidPath = getClass().getClassLoader().getResourceAsStream("invalid/path/to/ontology/file.owl");

        Assertions.assertThrows(NullPointerException.class, () -> rdfModelBuilder.buildRDFModel(invalidPath));
    }

    @Test
    void buildOntologyModel_ShouldCreateOntologyModel() {
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        Model model = rdfModelBuilder.buildOntologyModel(modelSpec);

        Assertions.assertNotNull(model);
    }

    @Test
    void buildOntologyModel_WithValidPathAndModelSpec_ShouldReadOntologyModelFromFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sci-fi-ontology.rdf");
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        Model model = rdfModelBuilder.buildOntologyModel(inputStream, modelSpec);

        Assertions.assertNotNull(model);
    }

    @Test
    void buildOntologyModel_WithInvalidPathAndModelSpec_ShouldThrowNullPointerException() {
        InputStream invalidPath = getClass().getClassLoader().getResourceAsStream("invalid/path/to/ontology/file.owl");
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        Assertions.assertThrows(NullPointerException.class, () -> rdfModelBuilder.buildOntologyModel(invalidPath, modelSpec));
    }
}

