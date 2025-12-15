import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения программы
@Target(ElementType.TYPE) // Можно ставить только на классы (типы)
public @interface Cache {
    String[] value() default {};  // по умолчанию пустой массив
}
