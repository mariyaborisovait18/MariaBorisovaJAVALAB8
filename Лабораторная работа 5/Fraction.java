/**
 * Неизменяемая дробь - паттерн Immutable Object
 */
package fraction;

public class Fraction implements FractionOperations {
    protected final int numerator;
    protected final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getDecimalValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}