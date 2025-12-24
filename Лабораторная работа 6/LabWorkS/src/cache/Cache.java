package cache;

import java.lang.annotation.*;

/**
 * Аннотация для указания ключей кэширования, связанных с типом.
 * Может применяться к классам и позволяет задавать набор строковых
 * значений, используемых при работе механизмов кэширования.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {

    /**
     * Набор ключей, связанных с кэшируемым типом.
     *
     * @return массив строковых значений для кэширования
     */
    String[] value() default {};
}
