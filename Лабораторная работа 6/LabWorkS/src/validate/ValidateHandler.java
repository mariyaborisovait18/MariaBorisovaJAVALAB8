package validate;

/**
 * Класс validate.ValidateHandler проверяет наличие аннотации @validate.Validate
 * у переданного класса и выводит список указанных типов.
 */
public class ValidateHandler {

    /**
     * Показывает классы, указанные в аннотации @validate.Validate у переданного класса.
     *
     * @param clazz класс, который нужно проверить
     */
    public void showClasses(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            Class<?>[] classes = annotation.value();
            System.out.println("Классы для проверки в " + clazz.getSimpleName() + ":");
            for (Class<?> c : classes) {
                System.out.println("- " + c.getSimpleName());
            }
        } else {
            System.out.println("Аннотация @validate.Validate не найдена");
        }
    }
}
