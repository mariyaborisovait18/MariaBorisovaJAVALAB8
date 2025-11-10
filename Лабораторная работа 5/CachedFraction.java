/**
 * Декоратор для кэширования - паттерн Decorator
 */
package fraction;
public class CachedFraction implements FractionOperations {
    private final FractionOperations decoratedFraction;
    private Double cachedValue;

    /**
     * Создает декоратор для кэширования дробей
     * @param fraction дробь для декорирования
     */
    public CachedFraction(FractionOperations fraction) {
        this.decoratedFraction = fraction;
        this.cachedValue = null;
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