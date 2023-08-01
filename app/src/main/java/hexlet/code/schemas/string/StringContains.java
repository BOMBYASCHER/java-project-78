package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public class StringContains implements Check {
    private final String substring;
    public StringContains(String substring) {
        this.substring = substring;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).contains(substring);
    }
}
