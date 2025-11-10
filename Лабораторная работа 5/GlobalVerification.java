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
     * Считывает положительное число из консоли.
     * Цикл продолжается до получения корректного ввода.
     *
     * @return положительное число (>= 1)
     */
    public static int numberNumPlus() {
        while(true) {
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 2) {
                return number;
            }
            System.out.println("Введите положительное число от 2: ");
        }
    }
    /**
     * Считывает положительное число из консоли.
     * Цикл продолжается до получения корректного ввода.
     *
     * @return положительное число (>= 1 и <= 9)
     */
    public static int numberNumNum() {
        while(true) {
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 1 && number <=9) {
                return number;
            }
            System.out.println("Введите положительное число от 1: ");
        }
    }

}