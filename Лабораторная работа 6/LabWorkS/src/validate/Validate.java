package validate;

import java.lang.annotation.*;

/**
 * Аннотация для указания валидаторов, которые должны быть применены
 * к типу или другой аннотации. Позволяет задавать набор классов,
 * выполняющих проверку корректности данных во время выполнения.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    /**
     * Массив классов‑валидаторов, которые должны быть применены.
     *
     * @return список типов, выполняющих валидацию
     */
    Class<?>[] value();
}
