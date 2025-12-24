package tostring;

import java.lang.annotation.*;

/**
 * Аннотация для управления включением объекта в строковое представление.
 * Может применяться к классам и полям, позволяя указывать,
 * следует ли учитывать элемент при генерации строки.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {

    /**
     * Режим, определяющий, должен ли элемент участвовать
     * в формировании строкового представления.
     *
     * @return режим обработки элемента
     */
    Mode value() default Mode.YES;
}
