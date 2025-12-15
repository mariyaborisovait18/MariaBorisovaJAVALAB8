import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // Аннотация доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD})  // Можно ставить на классы и поля
public @interface ToString {
    Mode value() default Mode.YES;  // по умолчанию YES
}