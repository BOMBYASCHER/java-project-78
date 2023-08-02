package hexlet.code.schemas;

import hexlet.code.schemas.string.StringContains;
import hexlet.code.schemas.string.StringMinLength;
import hexlet.code.schemas.string.StringRequired;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addRule(new StringRequired());
        return this;
    }
    public StringSchema minLength(int length) {
        addRule(new StringMinLength(length));
        return this;
    }
    public StringSchema contains(String substring) {
        addRule(new StringContains(substring));
        return this;
    }
}
