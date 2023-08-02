package hexlet.code.schemas;

import hexlet.code.schemas.map.MapRequired;
import hexlet.code.schemas.map.MapShape;
import hexlet.code.schemas.map.MapSizeOf;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        addRule(new MapRequired());
        return this;
    }
    public MapSchema sizeof(int size) {
        addRule(new MapSizeOf(size));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addRule(new MapShape(schemas));
        return this;
    }
}
