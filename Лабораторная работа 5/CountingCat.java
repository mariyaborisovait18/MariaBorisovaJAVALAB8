/**
 * Декоратор для подсчета мяуканий кота
 * Структурный паттерн - Decorator
 */
package animals;

public class CountingCat implements Meowable {
    private Cat decoratedCat;
    private int meowCount;

    public CountingCat(Cat cat) {
        this.decoratedCat = cat;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        decoratedCat.meow();
        meowCount++;
    }

    @Override
    public void meow(int n) {
        decoratedCat.meow(n);
        if (n > 0) {
            meowCount += n;
        }
    }

    /**
     * @return общее количество мяуканий
     */
    public int getMeowCount() {
        return meowCount;
    }

    /**
     * Сбрасывает счетчик мяуканий
     */
    public void resetMeowCount() {
        this.meowCount = 0;
    }

    /**
     * @return оригинального кота
     */
    public Cat getCat() {
        return decoratedCat;
    }

    /**
     * @return строковое представление оригинального кота
     */
    @Override
    public String toString() {
        return decoratedCat.toString();
    }
}