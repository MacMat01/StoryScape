package it.unicam.cs.storyscape.parser;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public record JSONData(String jsonData) implements ParsedData {

    static Gson gson = new Gson();

    public static JSONData fromObject(Object object) {
        String jsonData = gson.toJson(object);
        return new JSONData(jsonData);
    }

    @Override
    public String getProperty(String property) {
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.get(property);
        }
        return "";
    }

    @Override
    public Collection<String> getValues() {
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.values();
        }
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getKeys() {
        DataObject dataObject = gson.fromJson(jsonData, DataObject.class);
        if (dataObject != null) {
            return dataObject.keySet();
        }
        return Collections.emptyList();
    }

    /**
     * Class that represents the DataObject used to parse the JSON data.
     */
    private static class DataObject extends HashMap<String, String> {
    }
}
