package control.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.stats.StatBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class JsonInterpreter {

    public static <ObjectType> ObjectType readFromResource(String resourceName, Class<ObjectType> type) {
        Gson gson = new Gson();

        try {
            ClassLoader thisClass = JsonInterpreter.class.getClassLoader();
            InputStream file = thisClass.getResourceAsStream(resourceName);
            Reader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            return  gson.fromJson(reader, type);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static <ObjectType> ObjectType loadFile(File file, Class<ObjectType> type) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(StatBase.class, new JsonInterfaceAdapter());
        Gson gson = gsonBuilder.create();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            return gson.fromJson(reader, type);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static String serialize (Object data) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(StatBase.class, new JsonInterfaceAdapter());
        Gson gson = gsonBuilder.create();

        return gson.toJson(data);
    }
}
