package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @Test
    public void testValidator() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();
    }

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("hex")).isFalse();
    }

    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.positive().isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();

        schema.range(5, 10);

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        Validator v2 = new Validator();
        NumberSchema schema2 = v2.number().required().positive().range(1, 1000);

        assertThat(schema2.isValid(500)).isTrue();
        assertThat(schema2.isValid(0)).isFalse();
    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();

        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();

        Validator v2 = new Validator();
        MapSchema schema2 = v2.map().required().sizeof(0);

        assertThat(schema2.isValid(new HashMap<>())).isTrue();
        assertThat(schema2.isValid(null)).isFalse();
    }
}
