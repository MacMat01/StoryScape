package it.unicam.cs.storyscape.test.helper;

import it.unicam.cs.storyscape.helper.Refactorizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefactorizerTest {

    @Test
    public void testPolishProperty_WithUnwantedCharacters_ShouldRemoveCharacters() {
        String property = "ThingProperty, NameIndividual";
        String polishedProperty = Refactorizer.polishProperty(property);
        Assertions.assertEquals("Property", polishedProperty);
    }

    @Test
    public void testPolishProperty_WithoutUnwantedCharacters_ShouldReturnSameProperty() {
        String property = "SampleProperty";
        String polishedProperty = Refactorizer.polishProperty(property);
        Assertions.assertEquals(property, polishedProperty);
    }

    @Test
    public void testRemovePrefix_WithValidURI_ShouldRemovePrefix() {
        String uri = "http://example.com/ontology/Property";
        String polishedURI = Refactorizer.removePrefix(uri);
        Assertions.assertEquals("ontology/Property", polishedURI);
    }

    @Test
    public void testCamelCaseToWords_WithCamelCaseString_ShouldConvertToWords() {
        String camelCaseString = "camelCaseString";
        String convertedString = Refactorizer.camelCaseToWords(camelCaseString);
        Assertions.assertEquals("camel Case String", convertedString);
    }

    @Test
    public void testCamelCaseToWords_WithAlreadySeparatedWords_ShouldReturnSameString() {
        String camelCaseString = "already Separated Words";
        String convertedString = Refactorizer.camelCaseToWords(camelCaseString);
        String expectedString = "already Separated Words".replaceAll("\\s+", " ");
        String actualString = convertedString.replaceAll("\\s+", " ");
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testFirstLetterToUpperCase_WithLowerCaseString_ShouldConvertFirstLetterToUpperCase() {
        String lowercaseString = "string";
        String convertedString = Refactorizer.firstLetterToUpperCase(lowercaseString);
        Assertions.assertEquals("String", convertedString);
    }

    @Test
    public void testFirstLetterToUpperCase_WithAlreadyUpperCaseString_ShouldReturnSameString() {
        String uppercaseString = "STRING";
        String convertedString = Refactorizer.firstLetterToUpperCase(uppercaseString);
        Assertions.assertEquals(uppercaseString, convertedString);
    }
}
