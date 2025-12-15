/**
 * Класс TestTwo демонстрирует использование аннотации @Default
 * для задания типов по умолчанию у класса и его полей.
 */
@Default(String.class) // тип String по умолчанию
public class TestTwo {

    /**
     * Поле name имеет тип по умолчанию Integer.
     */
    @Default(Integer.class)
    private String name;

    /**
     * Поле computer имеет тип по умолчанию Boolean.
     */
    @Default(Boolean.class)
    private int computer;

    /**
     * Поле password имеет тип по умолчанию Double.
     */
    @Default(Double.class)
    public String password;
}
