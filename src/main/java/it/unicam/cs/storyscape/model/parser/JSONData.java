package it.unicam.cs.storyscape.model.parser;

import com.google.gson.Gson;

import java.util.Collection;

public record JSONData(String jsonData) implements ParsedData {

    public static JSONData fromObject(Object object) {
        Gson gson = new Gson();
        String jsonData = gson.toJson(object);
        return new JSONData(jsonData);
    }

    @Override
    public String getProperty(String property) {
        Gson gson = new Gson();
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.getProperty(property);
        }
        return null;
    }

    @Override
    public Collection<String> getValues() {
        Gson gson = new Gson();
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.getValues();
        }
        return null;
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
