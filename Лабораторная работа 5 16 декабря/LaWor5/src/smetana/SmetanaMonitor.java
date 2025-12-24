package smetana;

import java.util.*;

public class SmetanaMonitor {

    public static int[] analyze(List<String> input) {
        Map<Integer, Integer> minPrice = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (String line : input) {
            String[] parts = line.split(" ");
            int fat = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            if (!minPrice.containsKey(fat)) {
                minPrice.put(fat, price);
                count.put(fat, 1);
            } else {
                int currentMin = minPrice.get(fat);
                if (price < currentMin) {
                    minPrice.put(fat, price);
                    count.put(fat, 1);
                } else if (price == currentMin) {
                    count.put(fat, count.get(fat) + 1);
                }
            }
        }

        // результат: [для 15%, для 20%, для 25%]
        int[] result = new int[3];
        result[0] = count.getOrDefault(15, 0);
        result[1] = count.getOrDefault(20, 0);
        result[2] = count.getOrDefault(25, 0);

        return result;
    }
}
