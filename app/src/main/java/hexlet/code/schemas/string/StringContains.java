package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public final class StringContains implements Check {
    private final String string;
    public StringContains(String substring) {
        this.string = substring;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).contains(string);
    }
}
