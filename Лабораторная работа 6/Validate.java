import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Можно ставить на классы и другие аннотации
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения программы
public @interface Validate {
    Class<?>[] value(); //  массив классов
}