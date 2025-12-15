/**
 * Класс TwoHandler проверяет наличие аннотации @Two
 * у переданного класса и выводит её значения.
 */
public class TwoHandler {

    /**
     * Обрабатывает класс: если найдена аннотация @Two,
     * выводит значения one() и two().
     *
     * @param clazz класс, который нужно проверить
     */
    public void processClass(Class<?> clazz) {

        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            String firstValue = annotation.one();
            int secondValue = annotation.two();
            System.out.println("Аннотация @Two найдена в классе: " + clazz.getSimpleName());
            System.out.println("first: '" + firstValue + "'");
            System.out.println("second: " + secondValue);
        } else {
            System.out.println("Аннотация @Two не найдена");
        }
    }
}
