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
        return ((Map<?, ?>) value).size() == size;
    }
}
