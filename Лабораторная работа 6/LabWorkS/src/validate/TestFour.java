package validate;

/**
 * Класс validate.TestFour демонстрирует использование аннотации @validate.Validate
 * для указания типов, которые должны проверяться.
 */
@Validate({String.class, Integer.class, Double.class})
public class TestFour {
}
