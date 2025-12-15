import java.lang.reflect.Field;

/**
 * Класс ToStringHandler формирует строковое представление объекта
 * на основе аннотации @ToString.
 */
public class ToStringHandler {

    /**
     * Генерирует строку вида ClassName{field=value,...} для объекта,
     * включая только поля, помеченные аннотацией @ToString со значением Mode.YES.
     *
     * @param obj объект, для которого создаётся строковое представление
     * @return строка с выбранными полями объекта
     * @throws Exception если при доступе к полям возникла ошибка
     */
    public String generateToString(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        StringBuilder result = new StringBuilder();
        result.append(clazz.getSimpleName()).append("{");
        Field[] fields = clazz.getDeclaredFields();
        boolean firstField = true;  // Флаг для определения первого поля

        for (Field field : fields) {
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);

                if (annotation.value() == Mode.YES) {
                    field.setAccessible(true);
                    Object value = field.get(obj);

                    if (!firstField) {
                        result.append(", ");
                    }
                    result.append(field.getName()).append("=").append(value);
                    firstField = false;
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
