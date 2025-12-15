
import java.lang.annotation.*;

@Target(ElementType.METHOD)          // Аннотацию можно ставить только над методами
@Retention(RetentionPolicy.RUNTIME)  // Аннотация доступна во время выполнения программы
public @interface Invoke {
    // не имеет свойств
}