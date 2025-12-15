import java.lang.reflect.Method;

import java.lang.reflect.Method;

/**
 * Класс для вызова методов с аннотацией @Invoke.
 */
public class InvokeHandler {

    /**
     * Вызывает все методы объекта, которые помечены аннотацией @Invoke.
     *
     * @param obj объект, у которого ищем методы
     * @throws Exception если при вызове метода возникла ошибка
     */
    public void autInvoke(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.invoke(obj);
            }
        }
    }
}
