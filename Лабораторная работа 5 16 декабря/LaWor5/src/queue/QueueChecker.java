package queue;

import java.util.*;
public class QueueChecker {

    public static <T> boolean hasEqualNext(Queue<T> queue) {
        if (queue.isEmpty()) return false;

        List<T> list = new ArrayList<>(queue);
        int n = list.size();

        for (int i = 0; i < n; i++) {
            T current = list.get(i);
            T next = list.get((i + 1) % n);
            if (current.equals(next)) {
                return true;
            }
        }
        return false;
    }
}
