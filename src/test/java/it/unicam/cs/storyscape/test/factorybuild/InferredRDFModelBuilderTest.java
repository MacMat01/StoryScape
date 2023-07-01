package it.unicam.cs.storyscape.test.factorybuild;

import it.unicam.cs.storyscape.model.factorybuild.InferredRDFModelBuilder;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InferredRDFModelBuilderTest {

    private InferredRDFModelBuilder inferredRDFModelBuilder;
    private Model baseModel;

    @BeforeEach
    void setUp() {
        inferredRDFModelBuilder = new InferredRDFModelBuilder();
        baseModel = ModelFactory.createDefaultModel();
        // Add test data to the base model if needed
    }

    @Test
    void buildInferredModel_ShouldReturnInferredModel() {
        // Arrange
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();

        // Act
        InfModel inferredModel = inferredRDFModelBuilder.buildInferredModel(baseModel, reasoner);

        // Assert
        Assertions.assertNotNull(inferredModel);
        // Additional assertions if needed
    }

    @Test
    void isConsistent_WithConsistentModel_ShouldReturnTrue() {
        // Arrange
        InfModel model = ModelFactory.createInfModel(PelletReasonerFactory.theInstance().create(), baseModel);

        // Act
        boolean isConsistent = inferredRDFModelBuilder.isConsistent(model);

        // Assert
        Assertions.assertTrue(isConsistent);
    }

    /*@Test
    void isConsistent_WithInconsistentModel_ShouldReturnFalse() {
        // Arrange
        InfModel model = ModelFactory.createInfModel(PelletReasonerFactory.theInstance().create(), baseModel);

        // Act
        boolean isConsistent = inferredRDFModelBuilder.isConsistent(model);

        // Assert
        Assertions.assertFalse(isConsistent);
    }*/

    @Test
    void isValidInference_WithValidInference_ShouldReturnTrue() {
        // Arrange
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();
        InfModel model = inferredRDFModelBuilder.buildInferredModel(baseModel, reasoner);
        Resource subject = null; // Initialize with the subject resource
        Property predicate = null; // Initialize with the predicate property
        Resource object = null; // Initialize with the object resource

        // Act
        boolean isValidInference = inferredRDFModelBuilder.isValidInference(model, subject, predicate, object);

        // Assert
        Assertions.assertTrue(isValidInference);
    }

    /*@Test
    void isValidInference_WithInvalidInference_ShouldReturnFalse() {
        // Arrange
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();
        InfModel model = inferredRDFModelBuilder.buildInferredModel(baseModel, reasoner);
        Resource subject = null; // Initialize with the subject resource
        Property predicate = null; // Initialize with the predicate property
        Resource object = null; // Initialize with the object resource

        // Act
        boolean isValidInference = inferredRDFModelBuilder.isValidInference(model, subject, predicate, object);

        // Assert
        Assertions.assertFalse(isValidInference);
    }*/
}
