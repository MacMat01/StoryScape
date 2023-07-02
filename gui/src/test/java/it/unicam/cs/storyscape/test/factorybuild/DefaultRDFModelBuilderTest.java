package it.unicam.cs.storyscape.test.factorybuild;

import it.unicam.cs.storyscape.factorybuild.DefaultRDFModelBuilder;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultRDFModelBuilderTest {

    private final DefaultRDFModelBuilder rdfModelBuilder = new DefaultRDFModelBuilder();

    @Test
    void buildRDFModel_ShouldCreateDefaultModel() {
        // Arrange

        // Act
        Model model = rdfModelBuilder.buildRDFModel();

        // Assert
        Assertions.assertNotNull(model);
    }

    @Test
    void buildRDFModel_WithValidPath_ShouldReadModelFromFile() {
        // Arrange
        String filePath = "src/test/resources/sci-fi-ontology.rdf";

        // Act
        Model model = rdfModelBuilder.buildRDFModel(filePath);

        // Assert
        Assertions.assertNotNull(model);
    }

    @Test
    void buildRDFModel_WithInvalidPath_ShouldThrowNullPointerException() {
        // Arrange
        String invalidPath = "invalid/path/to/rdf/file.rdf";

        // Act and Assert
        Assertions.assertThrows(NullPointerException.class, () -> rdfModelBuilder.buildRDFModel(invalidPath));
    }

    @Test
    void buildOntologyModel_ShouldCreateOntologyModel() {
        // Arrange
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        // Act
        Model model = rdfModelBuilder.buildOntologyModel(modelSpec);

        // Assert
        Assertions.assertNotNull(model);
    }

    @Test
    void buildOntologyModel_WithValidPathAndModelSpec_ShouldReadOntologyModelFromFile() {
        // Arrange
        String filePath = "src/test/resources/sci-fi-ontology.rdf";
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        // Act
        Model model = rdfModelBuilder.buildOntologyModel(filePath, modelSpec);

        // Assert
        Assertions.assertNotNull(model);
    }

    @Test
    void buildOntologyModel_WithInvalidPathAndModelSpec_ShouldThrowNullPointerException() {
        // Arrange
        String invalidPath = "invalid/path/to/ontology/file.owl";
        OntModelSpec modelSpec = OntModelSpec.OWL_DL_MEM;

        // Act and Assert
        Assertions.assertThrows(NullPointerException.class, () -> rdfModelBuilder.buildOntologyModel(invalidPath, modelSpec));
    }
}

