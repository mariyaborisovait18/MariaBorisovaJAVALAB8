
import java.util.*;
public class QueueChecker {

    // Метод проверяет, есть ли в очереди элемент, равный следующему за ним (по кругу)
    public static <T> boolean hasEqualNext(Queue<T> queue) {
        if (queue.isEmpty()) return false;

        List<T> list = new ArrayList<>(queue); // преобразуем очередь в список для удобства
        int n = list.size();

        for (int i = 0; i < n; i++) {
            T current = list.get(i);
            T next = list.get((i + 1) % n); // следующий по кругу
            if (current.equals(next)) {
                return true;
            }
        }
        return false;
    }
}
