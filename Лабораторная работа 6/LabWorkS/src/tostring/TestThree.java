package tostring;

/**
 * Класс tostring.TestThree демонстрирует использование аннотации @tostring.ToString
 * для выбора, какие поля включаются в строковое представление.
 */
@ToString
public class TestThree {

    /**
     * Поле name включается в строку (tostring.Mode.YES).
     */
    @ToString(Mode.YES)
    private String name = "Maria";

    /**
     * Поле age не включается в строку (tostring.Mode.NO).
     */
    @ToString(Mode.NO)
    private int age = 21;

    /**
     * Поле password включается в строку (по умолчанию YES).
     */
    @ToString
    private String password = "321969";

    /**
     * Поле sale не включается в строку (tostring.Mode.NO).
     */
    @ToString(Mode.NO)
    private double sale = 12345.6;

    /**
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * @return возраст.
     */
    public int getAge() {
        return age;
    }

    /**
     * @return пароль (password).
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return число (sale).
     */
    public double getSalary() {
        return sale;
    }
}
