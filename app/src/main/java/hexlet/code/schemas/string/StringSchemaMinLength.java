package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public class StringSchemaMinLength implements Check {
    private final int length;
    public StringSchemaMinLength(int length) {
        this.length = length;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).length() >= length;
    }
}
