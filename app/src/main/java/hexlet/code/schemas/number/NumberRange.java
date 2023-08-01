package hexlet.code.schemas.number;

import hexlet.code.schemas.Check;

public class NumberRange implements Check {
    private final int from;
    private final int to;

    public NumberRange(int from, int to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public boolean check(Object value) {
        int number = ((Integer) value);
        return from <= number && number <= to;
    }
}
