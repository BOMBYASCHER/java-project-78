package hexlet.code.schemas;

import hexlet.code.schemas.number.NumberPositive;
import hexlet.code.schemas.number.NumberRange;
import hexlet.code.schemas.number.NumberRequired;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addRule(new NumberRequired());
        return this;
    }

    public NumberSchema positive() {
        addRule(new NumberPositive());
        return this;
    }

    public NumberSchema range(int from, int to) {
        addRule(new NumberRange(from, to));
        return this;
    }
}
