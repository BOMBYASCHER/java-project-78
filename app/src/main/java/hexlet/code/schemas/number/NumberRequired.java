package hexlet.code.schemas.number;

import hexlet.code.schemas.Check;

public class NumberRequired implements Check {
    @Override
    public boolean check(Object value) {
        return value != null;
    }
}
