import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleProcessor {

    private List<String> originalData;
    private Map<Integer, List<String>> groupedPeople;
    private String inputFileName;
    private String outputFileName;

    /**
     * Создает процессор людей с указанными файлами
     * @param inputFileName файл для чтения данных
     * @param outputFileName файл для записи результатов
     */
    public PeopleProcessor(String inputFileName, String outputFileName) {
        this.originalData = new ArrayList<>();
        this.groupedPeople = new HashMap<>();
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    /**
     * Создает процессор людей с файлами по умолчанию
     */
    public PeopleProcessor() {
        this("a.txt", "b.txt");
    }

    /**
     * @return исходные данные
     */
    public List<String> getOriginalData() {
        return originalData;
    }

    /**
     * @return сгруппированных людей по номерам
     */
    public Map<Integer, List<String>> getGroupedPeople() {
        return groupedPeople;
    }

    /**
     * @return имя файла ввода
     */
    public String getInputFileName() {
        return inputFileName;
    }

    /**
     * @return имя файла вывода
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Добавляет человека в исходные данные
     * @param name имя человека
     * @param number номер человека (может быть null)
     */
    public void addPerson(String name, Integer number) {
        if (number != null) {
            this.originalData.add(name + ":" + number);
        } else {
            this.originalData.add(name + ":");
        }
    }

    /**
     * Записывает исходные данные в файл ввода
     */
    public void writeToInputFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFileName))) {
            for (String line : originalData) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    /**
     * Обрабатывает людей: фильтрует, форматирует имена и группирует по номерам
     */
    public void processPeople() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {

            // Стрим обработка
            this.groupedPeople = reader.lines()  // ← НАЧАЛО СТРИМА
                    //Разбиваем строки на имя и номер
                    .map(line -> line.split(":"))
                    // Убираем людей без номеров
                    .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                    // Преобразуем имена и номера
                    .map(parts -> {
                        String name = parts[0].trim();
                        Integer number = Integer.parseInt(parts[1].trim());

                        // Приводим имя к нижнему регистру, но с первой буквой в верхнем
                        if (!name.isEmpty()) {
                            name = name.substring(0, 1).toUpperCase() +
                                    name.substring(1).toLowerCase();
                        }

                        return new Object[]{name, number};
                    })
                    // Группируем по номеру
                    .collect(Collectors.groupingBy(
                            arr -> (Integer) arr[1],
                            Collectors.mapping(
                                    arr -> (String) arr[0],
                                    Collectors.toList()
                            )
                    ));  // ← КОНЕЦ СТРИМА

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    /**
     * Записывает результат группировки в файл вывода
     */
    public void writeResultToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            writer.println(this.getResultString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи результата: " + e.getMessage());
        }
    }

    /**
     * @return строковое представление сгруппированных данных
     */
    public String getResultString() {
        return groupedPeople.toString();
    }

    /**
     * @return строковое представление процессора людей
     */
    public String toString() {
        return  "Исходные данные: " + originalData + "\n" +
                "Сгруппированные люди: " + groupedPeople + "\n" +
                "Файл ввода: " + inputFileName + "\n" +
                "Файл вывода: " + outputFileName;
    }
}