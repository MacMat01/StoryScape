package it.unicam.cs.storyscape.factorybuild;

import it.unicam.cs.storyscape.helper.URIs;
import it.unicam.cs.storyscape.parser.JSONParser;
import it.unicam.cs.storyscape.parser.ParsedData;
import it.unicam.cs.storyscape.sparql.OntologySPARQLExec;
import it.unicam.cs.storyscape.sparql.SelectionQueries;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;

/**
 * Class that represents the controller of the StoryScape app.
 */
public class Controller {

    private final InferredRDFModelBuilder inferredRDFModelBuilder = new InferredRDFModelBuilder();
    private final OntologySPARQLExec sparqlExec = new OntologySPARQLExec();
    private Model model;

    public Controller() {
        this.model = inferredRDFModelBuilder.buildOntologyModel(getClass().getClassLoader().getResourceAsStream(URIs.SFO.getURI()), OntModelSpec.OWL_DL_MEM);
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

    /**
     * Gets data from the ontology.
     *
     * @param query the query to execute
     * @return the data
     */
    public ParsedData getData(SelectionQueries query) {
        JSONParser parser = new JSONParser();
        try (QueryExecution queryExecution = sparqlExec.executeSPARQLQuery(query, model)) {
            return parser.parse(queryExecution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets data from the ontology with arguments.
     *
     * @param query the query to execute
     * @param args  the arguments of the query
     * @return the data
     */
    public ParsedData getData(SelectionQueries query, Object... args) {
        JSONParser parser = new JSONParser();
        try (QueryExecution queryExecution = sparqlExec.executeSPARQLQuery(query, model, args)) {
            return parser.parse(queryExecution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}