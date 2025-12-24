package list;

import java.util.*;

public class ListProcessor {

    public static <T> List<T> compress(List<T> input) {
        List<T> result = new ArrayList<>();
        if (input.isEmpty()) return result;

        T prev = input.get(0);
        result.add(prev);

        for (int i = 1; i < input.size(); i++) {
            T current = input.get(i);
            if (!current.equals(prev)) {
                result.add(current);
            }
            prev = current;
        }
        return result;
    }
}
