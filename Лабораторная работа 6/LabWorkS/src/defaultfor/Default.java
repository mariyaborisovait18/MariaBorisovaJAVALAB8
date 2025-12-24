package defaultfor;

import java.lang.annotation.*;

/**
 * Аннотация для указания класса по умолчанию.
 * Может применяться к типам и полям, позволяя задавать значение,
 * которое должно использоваться как стандартное при обработке.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {

    /**
     * Класс, который должен использоваться по умолчанию.
     *
     * @return тип, применяемый как значение по умолчанию
     */
    Class<?> value();
}
