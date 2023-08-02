package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.Check;

import java.util.Map;

public class MapShape implements Check {
    private final Map<String, BaseSchema> schemas;

    public MapShape(Map<String, BaseSchema> schemas) {
        this.schemas = schemas;
    }

    @Override
    public boolean check(Object value) {
        var map = (Map<?, ?>) value;
        var keys = schemas.keySet();
        return keys.stream()
                .allMatch(key -> schemas.get(key).isValid(map.get(key)));
    }
}
