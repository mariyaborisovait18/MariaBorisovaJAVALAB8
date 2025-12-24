package cache;

/**
 * Класс cache.CacheHandler проверяет наличие аннотации @cache.Cache
 * у переданного класса и выводит список областей.
 */
public class CacheHandler {

    /**
     * Обрабатывает класс: если найдена аннотация @cache.Cache,
     * выводит кешируемые области и их количество.
     *
     * @param clazz класс, который нужно проверить
     */
    public void processClass(Class<?> clazz) {
        System.out.println("Обрабатываем класс: " + clazz.getSimpleName());
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            String[] cacheAreas = annotation.value();
            if (cacheAreas.length == 0) {
                System.out.println("Список кешируемых областей пуст");
            } else {
                System.out.println("Кешируемые области:");
                for (String area : cacheAreas) {
                    System.out.println("- " + area);
                }
                System.out.println("Всего областей: " + cacheAreas.length);
            }
        } else {
            System.out.println("Аннотация @cache.Cache не найдена");
        }
        System.out.println();
    }
}
