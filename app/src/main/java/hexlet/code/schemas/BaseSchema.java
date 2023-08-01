package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;

public class BaseSchema {
    private final Set<Check> rules = new HashSet<>();
    public void addRule(Check rule) {
        rules.add(rule);
    }
    public boolean isValid(Object value) {
        return rules.stream()
                .allMatch(predicate -> predicate.check(value));
    }
}
