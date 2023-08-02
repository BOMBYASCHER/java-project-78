package hexlet.code.schemas.number;

import hexlet.code.schemas.Check;

public final class NumberRange implements Check {
    private final int start;
    private final int end;

    public NumberRange(int from, int to) {
        this.start = from;
        this.end = to;
    }
    @Override
    public boolean check(Object value) {
        int number = ((Integer) value);
        return start <= number && number <= end;
    }
}
