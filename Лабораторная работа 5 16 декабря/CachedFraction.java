
/**
 * Декоратор для кэширования - паттерн Decorator
 */
public class CachedFraction implements FractionOperations {
    private final FractionOperations decoratedFraction;
    private Double cachedValue;

    /**
     * Создает декоратор для кэширования дробей
     * @param fraction дробь для декорирования
     */
    public CachedFraction(FractionOperations fraction) {
        this.decoratedFraction = fraction; // Сохраняем исходный объект
        this.cachedValue = null; // Инициализируем пустой кэш
    }

    @Override
    public double getDecimalValue() {
        if (cachedValue == null) {
            System.out.println("Вычисляю значение: ");
            cachedValue = decoratedFraction.getDecimalValue();
        } else {
            System.out.println("Значение из кэша.");
        }
        return cachedValue;
    }

    /**
     * Очищает кэш вычисленного значения.
     */
    public void clearCache() {
        cachedValue = null;
        System.out.println("Кэш очищен.");
    }

    @Override
    public String toString() {
        return decoratedFraction.toString();
    }
}