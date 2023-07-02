package it.unicam.cs.storyscape.helper;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class that polishes the properties of the ontology.
 */
public class Refactorizer {

    /**
     * Method that removes unwanted characters from the properties.
     *
     * @param property the property to be polished
     * @return the polished property
     */
    public static String polishProperty(String property) {

        property = property.replace("Thing", "");
        property = property.replace(", NameIndividual", "");
        return property;
    }

    /**
     * Method that removes the prefix from the properties.
     *
     * @param uri the property to be polished
     * @return the polished property
     */
    public static String removePrefix(String uri) {

        if (uri != null) {
            try {
                URI parsedUri = new URI(uri);
                String path = parsedUri.getPath();
                if (path != null && !path.isEmpty()) {
                    return path.substring(1);  // Remove the first character from the path
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return "null";
    }

    /**
     * Converts a string from camel case to white space separated words.
     *
     * @param camelCaseString the string to be converted
     * @return the converted string
     */
    public static String camelCaseToWords(String camelCaseString) {
        return camelCaseString.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    /**
     * This Method converts the first letter of a string to uppercase.
     *
     * @param string the string to be converted
     * @return the converted string
     */
    public static String firstLetterToUpperCase(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

}