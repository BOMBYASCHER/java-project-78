package hexlet.code.schemas.map;

import hexlet.code.schemas.Check;

import java.util.Map;

public final class MapRequired implements Check {
    @Override
    public boolean check(Object value) {
        return value instanceof Map;
    }
}
