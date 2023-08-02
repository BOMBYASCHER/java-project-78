package hexlet.code;

import hexlet.code.schemas.BaseSchema;
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
        assertThat(schema2.isValid(new HashMap<>().put("key", "value"))).isFalse();
    }

    @Test
    public void testNestedMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();

        Validator v2 = new Validator();
        Map<String, BaseSchema> schemas2 = new HashMap<>();
        schemas2.put("string", v2.string().required().minLength(5).contains("hex"));
        schemas2.put("number", v2.number().required().positive().range(1, 1000));
        schemas2.put("map", v2.map().required().sizeof(0));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("string", "hexlet");
        map1.put("number", 500);
        map1.put("map", new HashMap<>());

        MapSchema schema2 = v2.map().shape(schemas2).sizeof(3).required();
        assertThat(schema2.isValid(map1)).isTrue();

        Map<String, Object> map2 = new HashMap<>();
        map2.put("string", "hex");
        map2.put("number", 5000);
        map2.put("map", new HashMap<>().put("key", "value"));

        assertThat(schema2.isValid(map2)).isFalse();

        Map<String, Object> map3 = new HashMap<>();
        map3.put("string", "hexlet");
        map3.put("number", 500);

        assertThat(schema2.isValid(map3)).isFalse();
    }
}
