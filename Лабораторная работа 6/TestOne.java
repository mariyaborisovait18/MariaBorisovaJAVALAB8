/**
 * Класс TestOne содержит методы, некоторые из которых помечены аннотацией @Invoke.
 */
public class TestOne {

    /**
     * Метод с аннотацией @Invoke.
     * Выводит сообщение о наличии аннотации.
     */
    @Invoke
    public void method1() {
        System.out.println("Присутствует Invoke");
    }

    /**
     * Метод без аннотации @Invoke.
     * Выводит сообщение об отсутствии аннотации.
     */
    public void method2() {
        System.out.println("НЕ присутствует Invoke");
    }

    /**
     * Ещё один метод с аннотацией @Invoke.
     * Выводит сообщение о наличии аннотации.
     */
    @Invoke
    public void method3() {
        System.out.println("Присутствует Invoke");
    }
}
