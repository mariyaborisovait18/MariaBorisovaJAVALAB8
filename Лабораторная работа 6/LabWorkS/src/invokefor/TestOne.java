package invokefor;

/**
 * Класс invokefor.TestOne содержит методы, некоторые из которых помечены аннотацией @invokefor.Invoke.
 */
public class TestOne {

    /**
     * Метод с аннотацией @invokefor.Invoke.
     * Выводит сообщение о наличии аннотации.
     */
    @Invoke
    public void method1() {
        System.out.println("Присутствует invokefor.Invoke");
    }

    /**
     * Метод без аннотации @invokefor.Invoke.
     * Выводит сообщение об отсутствии аннотации.
     */
    public void method2() {
        System.out.println("НЕ присутствует invokefor.Invoke");
    }

    /**
     * Ещё один метод с аннотацией @invokefor.Invoke.
     * Выводит сообщение о наличии аннотации.
     */
    @Invoke
    public void method3() {
        System.out.println("Присутствует invokefor.Invoke");
    }
}
