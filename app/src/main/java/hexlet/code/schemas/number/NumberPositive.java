package hexlet.code.schemas.number;

import hexlet.code.schemas.Check;

public final class NumberPositive implements Check {
    @Override
    public boolean check(Object value) {
        if (value == null) {
            return true;
        } else if (!(value instanceof Number)) {
            return false;
        }
        return ((Integer) value) > 0;
    }
}
