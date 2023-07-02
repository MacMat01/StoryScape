package it.unicam.cs.storyscape.parser;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.Collections;

public record JSONData(String jsonData) implements ParsedData {

    static Gson gson = new Gson();

    public static JSONData fromObject(Object object) {
//        Gson gson = new Gson();
        String jsonData = gson.toJson(object);
        return new JSONData(jsonData);
    }

    @Override
    public String getProperty(String property) {
//        Gson gson = new Gson();
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.getProperty(property);
        }
        return "";
    }

    @Override
    public Collection<String> getValues() {
//        Gson gson = new Gson();
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null && dataObject.getValues() != null) {
            return dataObject.getValues();
        }
        return Collections.emptyList();
    }

    /**
     * Class that represents the DataObject used to parse the JSON data.
     */
    private static class DataObject {
        private String property;
        private Collection<String> values;

        public String getProperty(String property) {
            return this.property;
        }

        public Collection<String> getValues() {
            return this.values;
        }
    }
}
