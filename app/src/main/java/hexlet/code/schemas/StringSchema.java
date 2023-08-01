package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;

public class StringSchema {
    private final Set<StringCheck> rules;

    public StringSchema() {
        rules = new HashSet<>();
    }

    public StringSchema required() {
        rules.add(new StringSchemaRequired());
        return this;
    }
    public StringSchema minLength(int length) {
        rules.add(new StringSchemaMinLength(length));
        return this;
    }
    public StringSchema contains(String substring) {
        rules.add(new StringSchemaContains(substring));
        return this;
    }
    public boolean isValid(Object value) {
        return rules.stream()
                .allMatch(predicate -> predicate.check(value));
    }
}
