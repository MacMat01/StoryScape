package it.unicam.cs.storyscape.parser;

import java.util.Collection;

/**
 * Interface that represents the parsed data from the SPARQL query.
 */
public interface ParsedData {

    /**
     * Returns a specific property of the parsed data.
     *
     * @param property the property to be returned
     *                 (e.g. "name")
     * @return the property
     */
    String getProperty(String property);

    /**
     * Returns all values from the parsed data.
     *
     * @return the values
     */
    Collection<String> getValues();

    /**
     * Returns all keys from the parsed data.
     *
     * @return the keys
     */
    Collection<String> getKeys();
}
