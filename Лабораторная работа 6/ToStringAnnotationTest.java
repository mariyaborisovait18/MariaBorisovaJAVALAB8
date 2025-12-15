import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс ToStringAnnotationTest содержит тесты для проверки работы аннотации @ToString
 * и класса ToStringHandler.
 */
public class ToStringAnnotationTest {

    /**
     * Проверяет наличие аннотации @ToString на классе TestThree.
     */
    @Test
    void testClassAnnotation() {
        ToString annotation = TestThree.class.getAnnotation(ToString.class);
        assertNotNull(annotation, "Аннотация @ToString должна быть на классе TestThree");
        assertEquals(Mode.YES, annotation.value(), "По умолчанию значение должно быть YES");
    }

    /**
     * Проверяет значения аннотаций @ToString на полях класса TestThree.
     */
    @Test
    void testFieldAnnotations() throws Exception {
        Field nameField = TestThree.class.getDeclaredField("name");
        assertEquals(Mode.YES, nameField.getAnnotation(ToString.class).value());

        Field ageField = TestThree.class.getDeclaredField("age");
        assertEquals(Mode.NO, ageField.getAnnotation(ToString.class).value());

        Field passwordField = TestThree.class.getDeclaredField("password");
        assertEquals(Mode.YES, passwordField.getAnnotation(ToString.class).value());

        Field saleField = TestThree.class.getDeclaredField("sale");
        assertEquals(Mode.NO, saleField.getAnnotation(ToString.class).value());
    }

    /**
     * Проверяет работу метода generateToString у ToStringHandler.
     */
    @Test
    void testGenerateToString() throws Exception {
        TestThree obj = new TestThree();
        ToStringHandler handler = new ToStringHandler();
        String result = handler.generateToString(obj);

        assertTrue(result.contains("name=Maria"), "Поле name должно быть включено");
        assertTrue(result.contains("password=321969"), "Поле password должно быть включено");
        assertFalse(result.contains("age=21"), "Поле age НЕ должно быть включено");
        assertFalse(result.contains("sale=12345.6"), "Поле sale НЕ должно быть включено");
    }

    /**
     * Параметризованный тест для проверки строкового представления разных объектов.
     */
    @ParameterizedTest
    @MethodSource("provideObjects")
    void testParameterizedToString(Object obj, String expectedSubstring) throws Exception {
        ToStringHandler handler = new ToStringHandler();
        String result = handler.generateToString(obj);
        assertTrue(result.contains(expectedSubstring),
                "Строковое представление должно содержать: " + expectedSubstring);
    }

    /**
     * Источник данных для параметризованных тестов.
     */
    private static Stream<org.junit.jupiter.params.provider.Arguments> provideObjects() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new TestThree(), "name=Maria")
        );
    }
}
