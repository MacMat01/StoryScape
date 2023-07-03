package it.unicam.cs.storyscape.test;

import it.unicam.cs.storyscape.factorybuild.Controller;
import it.unicam.cs.storyscape.factorybuild.InferredRDFModelBuilder;
import it.unicam.cs.storyscape.helper.URIs;
import it.unicam.cs.storyscape.parser.ParsedData;
import it.unicam.cs.storyscape.sparql.Query;
import it.unicam.cs.storyscape.sparql.SelectionQueries;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {

    private Controller controller;

    @BeforeEach
    public void setup() {
        controller = new Controller();
    }

    @Test
    public void testIsConsistent_WithInferredModel_ShouldReturnTrue() {
        boolean isConsistent = controller.isConsistent();
        assertTrue(isConsistent);
    }

//    @Test
//    public void testGetConsistencyStatus_WithInferredModel_ShouldReturnConsistentStatus() {
//        String consistencyStatus = QuerySelector.getConsistencyStatus();
//        assertEquals("Ontology consistent ✓", consistencyStatus);
//    }

    @Test
    public void testGetData_WithSelectionQuery_ShouldReturnParsedData() {
        SelectionQueries queryOld = SelectionQueries.BOOK_LIST;
        Model model = new InferredRDFModelBuilder().buildOntologyModel(getClass().getClassLoader().getResourceAsStream(URIs.SFO.getURI()), OntModelSpec.OWL_DL_MEM);
        String prefixes = Query.getPrefixes();
        String query = "SELECT ?label ?value WHERE { ?book rdf:type <https://www.cs.unicam.it/matteo.machella/sci-fi-ontology.rdf#sfo:Book> . BIND(?book AS ?label) . ?book rdfs:label ?value . }"; //?label ?value WHERE { ?book rdf:type sfo:Book . BIND(?book AS ?label) . ?book rdfs:label ?value . }
        String fullQuery = prefixes + query;
        QueryExecution execution = QueryExecutionFactory.create(fullQuery, model);
        ResultSet resultSet = execution.execSelect();
        System.out.println("hasNext: " + resultSet.hasNext());
        while (resultSet.hasNext()) {
            System.out.println(resultSet.next());
        }
        //ParsedData parsedData = controller.getData(query);
        //assertNotNull(parsedData);
    }

    @Test
    public void testGetData_WithSelectionQueryAndArgs_ShouldReturnParsedData() {
        SelectionQueries query = SelectionQueries.BOOK_DETAILS;
        String subjectArg = URIs.SFO.getURI();
        ParsedData parsedData = controller.getData(query, subjectArg);
        assertNotNull(parsedData);
    }
}