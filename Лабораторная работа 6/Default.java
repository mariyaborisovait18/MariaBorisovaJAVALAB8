import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})  // Цель: ТИП или ПОЛЕ
@Retention(RetentionPolicy.RUNTIME)  // Доступна во время исполнения
public @interface Default {
    Class<?> value();  // Обязательное свойство value типа Class
}