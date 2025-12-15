
import java.io.*;
import java.util.*;

public class DigitFinder {

    // приватный метод для создания файла "a" с текстом
    private static void createFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("a.txt"))) {
            writer.println("В магазине 3 яблока, 2 груши и 15 апельсинов.");
            writer.println("Цена 1 яблока = 25 рублей.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    // публичный метод: создаёт файл и возвращает множество цифр, которые встретились в тексте
    public static Set<Character> findDigits() {
        createFile(); // создаём файл с текстом

        Set<Character> digits = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("a.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        digits.add(c);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return digits;
    }
}