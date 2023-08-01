package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public class StringRequired implements Check {

    @Override
    public boolean check(Object value) {
        if (value instanceof String) {
            return !((String) value).isEmpty();
        } else {
            return false;
        }
    }
}
