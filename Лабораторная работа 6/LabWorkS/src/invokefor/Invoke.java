package invokefor;

import java.lang.annotation.*;

/**
 * Аннотация, помечающая методы, которые должны быть вызваны
 * специальной логикой или обработчиком во время выполнения.
 * Используется для маркировки методов, подлежащих автоматическому вызову.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}
