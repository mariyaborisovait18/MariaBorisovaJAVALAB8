
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleStream {

    // приватный метод: создаём файл "name.txt" с примером
    private static void createFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("name.txt"))) {
            writer.println("Вася:5");
            writer.println("Петя:3");
            writer.println("Аня:5");
            writer.println("Иван"); // пример без номера
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    // публичный метод: читаем файл и обрабатываем через стрим
    public static Map<Integer, List<String>> process() {
        createFile(); // создаём файл с примером

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("name.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // стрим: фильтрация, нормализация имён, группировка по номеру
        return lines.stream()
                .filter(s -> s.contains(":")) // убираем людей без номера
                .map(s -> {
                    String[] parts = s.split(":");
                    String name = parts[0].toLowerCase();
                    // первая буква заглавная
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    int number = Integer.parseInt(parts[1]);
                    return new AbstractMap.SimpleEntry<>(number, name);
                })
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
