import java.lang.reflect.Field;

/**
 * Класс для обработки аннотации @Default на классе и его полях.
 */
public class DefaultHandler {

    /**
     * Проверяет наличие аннотации @Default у класса и его полей
     * и выводит информацию в консоль.
     *
     * @param clazz класс, который нужно обработать
     */
    public void processClass(Class<?> clazz) {
        System.out.println("Обрабатываем класс: " + clazz.getSimpleName());
        // Проверяем аннотацию на классе (ТИП)
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("Класс имеет тип по умолчанию: " + annotation.value().getSimpleName());
        }

        // Проверяем аннотации на полях (ПОЛЕ)
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("Поле '" + field.getName() + "' имеет тип по умолчанию: " +
                        annotation.value().getSimpleName());
            }
        }
    }
}
