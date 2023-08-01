package hexlet.code.schemas;

public class StringSchemaRequired implements StringCheck {

    @Override
    public boolean check(Object value) {
        if (value instanceof String) {
            return !((String) value).isEmpty();
        } else {
            return false;
        }
    }
}
