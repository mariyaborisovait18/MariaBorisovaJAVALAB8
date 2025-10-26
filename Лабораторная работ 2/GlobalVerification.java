import java.util.Scanner;

public class GlobalVerification {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * Считывает строку из консоли, проверяя что она содержит только буквы и пробелы.
     * Цикл продолжается до получения корректного ввода.
     *
     * @return строка без цифр и специальных символов, обрезанная от пробелов
     */
    public static String stringWithoutNum() {
        while(true) {
            String input = scanner.nextLine();

            // Проверка на пустую строку или строку только из пробелов
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Поле не может быть пустым! Пожалуйста, введите данные: ");
                continue;
            }

            // Проверяем, что строка содержит только буквы (русские и английские) и пробелы
            if (input.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$")) {
                return input.trim();
            }
            System.out.println("Некорректный ввод! ФИО должно содержать только буквы. Введите заново: ");
        }
    }

    /**
     * Считывает число из консоли, проверяя что оно находится в допустимом диапазоне.
     * Цикл продолжается до получения корректного ввода.
     *
     * @return число в диапазоне от 135 до 240
     */
    public static int numberNum() {
        while(true) {
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 135 && number <= 240) {
                return number;
            }
            System.out.println("Введите положительное число от 135: ");
        }
    }

    /**
     * Считывает положительное число из консоли.
     * Цикл продолжается до получения корректного ввода.
     *
     * @return положительное число (>= 1)
     */
    public static int numberNumMiu() {
        while(true) {
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 1) {
                return number;
            }
            System.out.println("Введите положительное число от 1: ");
        }
    }
}