import java.io.*;
import java.util.*;

public class FileDigitFinder {
    public String fileName;
    public List<Character> digitsFound;

    /**
     * Создает поисковик цифр с файлом по умолчанию "text.txt"
     */
    public FileDigitFinder() {
        fileName = "text.txt";
        digitsFound = new ArrayList<>();
    }

    /**
     * Создает поисковик цифр с указанным именем файла
     * @param name имя файла для поиска цифр
     */
    public FileDigitFinder(String name) {
        fileName = name;
        digitsFound = new ArrayList<>();
    }

    /**
     * Создает файл и записывает в него текст
     * @param text текст для записи в файл
     */
    public void createFile(String text) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
            System.out.println("Файл " + fileName + " создан!");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
        }
    }

    /**
     * Ищет все цифры в файле и сохраняет их в список
     */
    public void findDigits() {
        digitsFound.clear();

        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Ищем цифры в строке
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c)) {
                        digitsFound.add(c);
                    }
                }
            }

            scanner.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }

    /**
     * @return строку с найденными цифрами или сообщение об их отсутствии
     */
    public String toString() {
        if (digitsFound.isEmpty()) {
            return "В тексте нет цифр";
        } else {
            return "Найденные цифры: " + digitsFound;
        }
    }
}