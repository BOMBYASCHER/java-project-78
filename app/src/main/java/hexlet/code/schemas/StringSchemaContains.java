package hexlet.code.schemas;

public class StringSchemaContains implements StringCheck {
    private final String substring;
    StringSchemaContains(String substring) {
        this.substring = substring;
    }
    @Override
    public boolean check(Object value) {
        return ((String) value).contains(substring);
    }
}
