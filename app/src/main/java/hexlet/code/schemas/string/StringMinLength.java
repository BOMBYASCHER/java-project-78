package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public class StringMinLength implements Check {
    private final int length;
    public StringMinLength(int length) {
        this.length = length;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).length() >= length;
    }
}
