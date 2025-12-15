import java.lang.annotation.*;

@Target(ElementType.TYPE) // Можно ставить только на классы (типы)
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения программы
public @interface Two {
    String one();
    int two();
}