package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public class StringSchemaContains implements Check {
    private final String substring;
    public StringSchemaContains(String substring) {
        this.substring = substring;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).contains(substring);
    }
}
