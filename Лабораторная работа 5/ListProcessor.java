package list;
import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
    public List<Integer> originalList;
    public List<Integer> resultList;

    /**
     * Создает процессор для работы со списком целых чисел
     */
    public ListProcessor(List<Integer> list) {
        originalList = new ArrayList<>(list);
        resultList = new ArrayList<>();
    }

    /**
     * Обрабатывает список, удаляя последовательные дубликаты
     */
    public void process() {
        resultList.clear();

        if (originalList.isEmpty()) {
            return;
        }

        // Добавляем первый элемент
        resultList.add(originalList.get(0));

        // Проходим по остальным элементам
        for (int i = 1; i < originalList.size(); i++) {
            int current = originalList.get(i);
            int previous = originalList.get(i - 1);

            // Если текущий элемент не равен предыдущему, добавляем его
            if (current != previous) {
                resultList.add(current);
            }
        }
    }

    /**
     * @return строковое представление исходного и обработанного списков
     */
    public String toString() {
        return "Исходный: " + originalList + "\nРезультат: " + resultList;
    }
}