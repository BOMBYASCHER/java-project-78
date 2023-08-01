package hexlet.code.schemas;

public class StringSchemaMinLength implements StringCheck {
    private final int length;
    StringSchemaMinLength(int length) {
        this.length = length;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).length() >= length;
    }
}
