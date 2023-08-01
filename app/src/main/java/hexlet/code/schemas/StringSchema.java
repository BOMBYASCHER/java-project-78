package hexlet.code.schemas;

import hexlet.code.schemas.string.StringSchemaContains;
import hexlet.code.schemas.string.StringSchemaMinLength;
import hexlet.code.schemas.string.StringSchemaRequired;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addRule(new StringSchemaRequired());
        return this;
    }
    public StringSchema minLength(int length) {
        addRule(new StringSchemaMinLength(length));
        return this;
    }
    public StringSchema contains(String substring) {
        addRule(new StringSchemaContains(substring));
        return this;
    }
}
