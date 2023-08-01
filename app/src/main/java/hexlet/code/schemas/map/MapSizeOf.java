package hexlet.code.schemas.map;

import hexlet.code.schemas.Check;

import java.util.Map;

public class MapSizeOf implements Check {
    private final int size;
    public MapSizeOf(int size) {
        this.size = size;
    }
    @Override
    public boolean check(Object value) {
        if (value == null) {
            return false;
        }
        return ((Map<?, ?>) value).size() == size;
    }
}
