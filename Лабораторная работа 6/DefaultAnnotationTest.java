import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс DefaultAnnotationTest содержит тесты для проверки работы аннотации @Default
 * на классе TestTwo и его полях.
 */
public class DefaultAnnotationTest {

    /**
     * Проверяет наличие аннотации @Default на классе TestTwo
     * и корректность её значения.
     */
    @Test
    void testClassAnnotation() {
        Default annotation = TestTwo.class.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна быть на классе TestTwo");
        assertEquals(String.class, annotation.value(), "Значение value должно быть String.class");
    }

    /**
     * Проверяет наличие и значения аннотации @Default на полях класса TestTwo.
     */
    @Test
    void testFieldAnnotations() throws NoSuchFieldException {
        Field nameField = TestTwo.class.getDeclaredField("name");
        Default nameAnnotation = nameField.getAnnotation(Default.class);
        assertNotNull(nameAnnotation, "Аннотация @Default должна быть на поле name");
        assertEquals(Integer.class, nameAnnotation.value(), "Поле name должно иметь тип по умолчанию Integer.class");

        Field computerField = TestTwo.class.getDeclaredField("computer");
        Default computerAnnotation = computerField.getAnnotation(Default.class);
        assertNotNull(computerAnnotation, "Аннотация @Default должна быть на поле computer");
        assertEquals(Boolean.class, computerAnnotation.value(), "Поле computer должно иметь тип по умолчанию Boolean.class");

        Field passwordField = TestTwo.class.getDeclaredField("password");
        Default passwordAnnotation = passwordField.getAnnotation(Default.class);
        assertNotNull(passwordAnnotation, "Аннотация @Default должна быть на поле password");
        assertEquals(Double.class, passwordAnnotation.value(), "Поле password должно иметь тип по умолчанию Double.class");
    }

    /**
     * Параметризованный тест для проверки значения аннотации @Default
     * у разных классов.
     */
    @ParameterizedTest
    @MethodSource("provideClassesWithDefaults")
    void testParameterizedClassDefaults(Class<?> clazz, Class<?> expectedDefault) {
        Default annotation = clazz.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна быть на классе " + clazz.getSimpleName());
        assertEquals(expectedDefault, annotation.value(), "Неверное значение value для " + clazz.getSimpleName());
    }

    /**
     * Источник данных для параметризованного теста.
     */
    private static Stream<org.junit.jupiter.params.provider.Arguments> provideClassesWithDefaults() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(TestTwo.class, String.class)
                // сюда можно добавить другие классы с @Default
        );
    }
}
