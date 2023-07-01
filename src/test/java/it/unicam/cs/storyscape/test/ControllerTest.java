package it.unicam.cs.storyscape.test;

import it.unicam.cs.storyscape.controller.Controller;
import it.unicam.cs.storyscape.model.helper.URIs;
import it.unicam.cs.storyscape.model.parser.ParsedData;
import it.unicam.cs.storyscape.model.sparql.SelectionQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testGetConsistencyStatus_WithInferredModel_ShouldReturnConsistentStatus() {
        String consistencyStatus = controller.getConsistencyStatus();
        assertEquals("Ontology consistent ✓", consistencyStatus);
    }

    @Test
    public void testGetData_WithSelectionQuery_ShouldReturnParsedData() {
        SelectionQueries query = SelectionQueries.BOOK_LIST;
        ParsedData parsedData = controller.getData(query);
        assertNotNull(parsedData);
    }

    @Test
    public void testGetData_WithSelectionQueryAndArgs_ShouldReturnParsedData() {
        SelectionQueries query = SelectionQueries.BOOK_DETAILS;
        String subjectArg = URIs.SFO.getURI();
        ParsedData parsedData = controller.getData(query, subjectArg);
        assertNotNull(parsedData);
    }
}