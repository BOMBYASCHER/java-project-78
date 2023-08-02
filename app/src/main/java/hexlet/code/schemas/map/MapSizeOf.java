package hexlet.code.schemas.map;

import hexlet.code.schemas.Check;

import java.util.Map;

public final class MapSizeOf implements Check {
    private final int mapSize;
    public MapSizeOf(int size) {
        this.mapSize = size;
    }
    @Override
    public boolean check(Object value) {
        if (value == null) {
            return false;
        }
        return ((Map<?, ?>) value).size() == mapSize;
    }
}
