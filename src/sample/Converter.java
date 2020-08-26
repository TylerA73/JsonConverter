package sample;

import com.google.gson.*;

/**
 * A singleton class created to handle the conversion of pretty-printed JSON to
 * a single-line JSON String, and vice versa
 */
public class Converter {

    /**
     * Converts JSON to a single-line string format
     *
     * @param j JSON String
     * @return String
     */
    public static String toString(String j) {
        Gson gson = new Gson();
        JsonElement elem = JsonParser.parseString(j);
        return gson.toJson(elem);
    }

    /**
     * Converts a single-line JSON String to pretty-printed JSON
     *
     * @param s JSON String
     * @return String
     */
    public static String toJson(String s) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement elem = JsonParser.parseString(s);
        return gson.toJson(elem);
    }

}
