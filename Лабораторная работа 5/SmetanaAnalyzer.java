import java.util.*;

public class SmetanaAnalyzer {
    private static final int[] defaultFatPercents = {15, 20, 25};
    private static final int initialMinPrice = 5000;

    public Map<Integer, Integer> minPrice;
    public Map<Integer, Integer> count;

    /**
     * Создает анализатор с настройками по умолчанию
     */
    public SmetanaAnalyzer() {
        this(defaultFatPercents, initialMinPrice);
    }

    /**
     * Создает анализатор с указанными параметрами
     * @param fatPercents массив жирностей для анализа
     * @param initialPrice начальная минимальная цена
     */
    public SmetanaAnalyzer(int[] fatPercents, int initialPrice) {
        this.minPrice = new HashMap<>();
        this.count = new HashMap<>();
        initializeMaps(fatPercents, initialPrice);
    }

    /**
     * Инициализирует карты начальными значениями
     */
    private void initializeMaps(int[] fatPercents, int initialPrice) {
        for (int fat : fatPercents) {
            minPrice.put(fat, initialPrice);
            count.put(fat, 0);
        }
    }

    /**
     * Обрабатывает данные магазина и обновляет статистику по сметане
     */
    public void addStore(String data) {
        String[] parts = data.split(" ");
        int fat = Integer.parseInt(parts[2]);
        int price = Integer.parseInt(parts[3]);

        if (price < minPrice.get(fat)) {
            minPrice.put(fat, price);
            count.put(fat, 1);
        } else if (price == minPrice.get(fat)) {
            count.put(fat, count.get(fat) + 1);
        }
    }

    /**
     * @return строку с количеством магазинов для каждой жирности
     */
    public String toString() {
        return count.get(15) + " " + count.get(20) + " " + count.get(25);
    }
}