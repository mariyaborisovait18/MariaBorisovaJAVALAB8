/**
 * Класс TestThree демонстрирует использование аннотации @ToString
 * для выбора, какие поля включаются в строковое представление.
 */
@ToString  // Аннотация на классе - используется значение по умолчанию YES для всех полей
public class TestThree {

    /**
     * Поле name включается в строку (Mode.YES).
     */
    @ToString(Mode.YES)
    private String name = "Maria";

    /**
     * Поле age не включается в строку (Mode.NO).
     */
    @ToString(Mode.NO)
    private int age = 21;

    /**
     * Поле password включается в строку (по умолчанию YES).
     */
    @ToString
    private String password = "321969";

    /**
     * Поле sale не включается в строку (Mode.NO).
     */
    @ToString(Mode.NO)
    private double sale = 12345.6;

    /**
     * Возвращает имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст.
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает пароль (password).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Возвращает число (sale).
     */
    public double getSalary() {
        return sale;
    }
}
