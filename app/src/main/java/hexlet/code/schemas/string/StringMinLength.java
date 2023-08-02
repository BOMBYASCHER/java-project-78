package hexlet.code.schemas.string;

import hexlet.code.schemas.Check;

public final class StringMinLength implements Check {
    private final int minLength;
    public StringMinLength(int length) {
        this.minLength = length;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).length() >= minLength;
    }
}
