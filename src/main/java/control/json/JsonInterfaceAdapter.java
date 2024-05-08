package control.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class JsonInterfaceAdapter implements JsonSerializer, JsonDeserializer {

    private static final String CLASS_NAME = "className";
    private static final String DATA = "data";

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive classNamePrimitive = (JsonPrimitive) jsonObject.get(CLASS_NAME);
        String className = classNamePrimitive.getAsString();

        Class classType;
        try {
            classType = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }

        return context.deserialize(jsonObject.get(DATA), classType);
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASS_NAME, src.getClass().getName());
        jsonObject.add(DATA, context.serialize(src));
        return jsonObject;
    }
}
