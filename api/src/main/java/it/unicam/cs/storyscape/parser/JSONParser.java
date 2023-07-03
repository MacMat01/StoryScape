package it.unicam.cs.storyscape.parser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

/**
 * Class that represents the JSON parser.
 */
public class JSONParser implements Parser {

    /**
     * Method that parses a query result node to a string.
     *
     * @param queryExecution the SPARQL query
     * @return the parsed data as JSONData
     */
    public JSONData parse(QueryExecution queryExecution) {
        JsonObject jsonData = new JsonObject();

        ResultSet results = queryExecution.execSelect();
        while (results.hasNext()) {
            QuerySolution result = results.nextSolution();
            String label = parseNodeToString(result.get("label"));
            String value = parseNodeToString(result.get("value"));

            // Concatenates multiple values of the same property
            if (jsonData.has(label)) {
                jsonData.addProperty(label, jsonData.get(label).getAsString() + ", " + value);
            } else {
                jsonData.addProperty(label, value);
            }
        }

        Gson gson = new Gson();
        String jsonString = gson.toJson(jsonData);
        return new JSONData(jsonString);
    }

    /**
     * Converts a Jena RDF node to a string.
     *
     * @param node the RDF node
     * @return the string representation of the node
     */
    private String parseNodeToString(RDFNode node) {
        if (node == null || (!node.isLiteral() && !node.isResource())) {
            return null;
        }
        return node.isLiteral() ? node.asLiteral().getString() : node.asResource().getLocalName();
    }
}