import java.util.*;

public class QueueChecker {
    // Свойства класса
    public Queue<Integer> numbers;
    public String name;
    public int count;
    public boolean result;

    /**
     * Создает проверятель очереди с настройками по умолчанию
     */
    public QueueChecker() {
        numbers = new LinkedList<>();
        name = "Моя очередь";
        count = 0;
        result = false;
    }

    /**
     * Создает проверятель очереди с указанным именем
     * @param n имя очереди
     */
    public QueueChecker(String n) {
        numbers = new LinkedList<>();
        name = n;
        count = 0;
        result = false;
    }

    /**
     * Добавляет число в очередь
     * @param num число для добавления
     */
    public void addNumber(int num) {
        numbers.add(num);
        count++;
    }

    /**
     * Проверяет есть ли в очереди одинаковые соседние элементы (включая первый и последний)
     */
    public void check() {
        if (numbers.isEmpty()) {
            result = false;
            return;
        }

        Queue<Integer> temp = new LinkedList<>(numbers);

        int first = temp.peek(); // Первый элемент
        int prev = temp.poll();  // Берем первый

        // Проверяем обычные соседи
        while (!temp.isEmpty()) {
            int curr = temp.poll();
            if (curr == prev) {
                result = true;
                return;
            }
            prev = curr;
        }

        // Проверяем по кругу (последний и первый)
        if (prev == first) {
            result = true;
        } else {
            result = false;
        }
    }

    /**
     * @return строковое представление очереди с именем
     */
    public String toString() {
        return name + " [" + numbers + "]";
    }
}