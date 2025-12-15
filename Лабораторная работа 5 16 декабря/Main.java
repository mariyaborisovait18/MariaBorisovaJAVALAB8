import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добрый день! Какое задание Вы бы хотели рассмотреть?\n");
        int choice = -1;

        while(choice != 0) {
            if (choice == -1) {
                System.out.println("МЕНЮ");
                System.out.println("№ Задания");
                System.out.println("1 - Реализация и демонстрация класса дробь");
                System.out.println("2 - Паттерн Decorator на примере класса дробь");
                System.out.println("3 - Структурный паттерн - Decorator на примере класса Cat.");
                System.out.println("4 - Удаление подряд идущих одинаковых элементов");
                System.out.println("5 - Анализ цен на сметану");
                System.out.println("6 - Поиск цифр в тексте");
                System.out.println("7 - Очередь (проверка одинаковых соседей по кругу");
                System.out.println("8 - РStream (Polyline из точек)");
                System.out.println("9 - Stream (группировка имён по номерам)");
                System.out.println("0 - ВЫХОД");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("1 - Реализация и демонстрация класса дробь");
                    // Создание дробей
                    Fraction fraction1 = new Fraction(1, 2);
                    Fraction fraction2 = new Fraction(2, 4);
                    Fraction fraction3 = new Fraction(-1, 3);
                    Fraction fraction4 = new Fraction(1, -4); // Автоматически нормализуется к -1/4

                    // Вывод строкового представления
                    System.out.println("Дробь 1: " + fraction1); // 1/2
                    System.out.println("Дробь 2: " + fraction2); // 2/4
                    System.out.println("Дробь 3: " + fraction3); // -1/3
                    System.out.println("Дробь 4: " + fraction4); // -1/4

                    // Сравнение дробей
                    System.out.println("Дробь 1 равна Дроби 2: " + fraction1.equals(fraction2)); // false
                    System.out.println("Дробь 3 равна Дроби 4: " + fraction3.equals(fraction4)); // false

                    // Создание одинаковых дробей
                    Fraction fraction5 = new Fraction(3, 5);
                    System.out.println("Дробь 5: " + fraction5); // 3/5
                    Fraction fraction6 = new Fraction(3, 5);
                    System.out.println("Дробь 6: " + fraction6); // 3/5
                    System.out.println("Дробь 5 равна Дроби 6: " + fraction5.equals(fraction6)); // true
                    choice = meni(1);
                    break;

                case 2:
                    System.out.println("2 - Паттерн Decorator на примере класса дробь");

                    Scanner scanner2 = new Scanner(System.in);

                    // Ввод данных от пользователя
                    System.out.println("Создаем дробь с кэшированием:");
                    System.out.print("Введите числитель: ");
                    int numerator = scanner2.nextInt();
                    System.out.print("Введите знаменатель: ");
                    int denominator = scanner2.nextInt();

                    // Создание обычной дроби и оборачивание в декоратор
                    Fraction simpleFraction = new Fraction(numerator, denominator);
                    CachedFraction fraction = new CachedFraction(simpleFraction);

                    System.out.println("Дробь: " + fraction);
                    System.out.println("Значение: " + fraction.getDecimalValue()); // Первый вызов - вычисление
                    System.out.println("Значение: " + fraction.getDecimalValue()); // Второй вызов - из кэша

                    // Чтобы получить числитель/знаменатель, нужно обратиться к оригинальной дроби
                    System.out.println("Числитель: " + simpleFraction.getNumerator());
                    System.out.println("Знаменатель: " + simpleFraction.getDenominator());

                    System.out.println("Демонстрация работы кэша:");
                    System.out.println("Третий вызов getDecimalValue(): " + fraction.getDecimalValue()); // Из кэша

                    // Очистка кэша
                    fraction.clearCache();
                    System.out.println("Вызов getDecimalValue() после очистки кэша: " + fraction.getDecimalValue()); // Снова вычисление
                    choice = meni(2);
                    break;

                case 3:
                    System.out.println("3 - Структурный паттерн - Decorator на примере класса Cat.");

                    Cat cat = new Cat("Барсик");
                    CountingCat countingCat = new CountingCat(cat);
                    System.out.println("Создан кот: " + cat);
                    System.out.print("Сколько раз должен мяукнуть кот? ");
                    int meowCount = scanner.nextInt();
                    countingCat.meow(meowCount);
                    System.out.println("Кот мяукал " + countingCat.getMeowCount() + " раз(а)");

                    choice = meni(3);
                    break;

                case 4:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Задание 4: списки (сжатие подряд идущих одинаковых элементов)");
                    System.out.println("Введите элементы списка через пробел:");
                    String line4 = scanner4.nextLine();
                    List<String> input = Arrays.asList(line4.split(" "));
                    List<String> compressed = ListProcessor.compress(input);
                    System.out.println("Результат: " + compressed);
                    choice = meni(4);
                    break;

                case 5:
                    System.out.println("Задание 5: Map (мониторинг цен на сметану)");

                    System.out.println("Введите количество магазинов:");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    List<String> data = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Введите данные о магазине (Фирма Улица Жирность Цена):");
                        String line5 = scanner.nextLine();
                        data.add(line5);
                    }

                    int[] result = SmetanaMonitor.analyze(data);
                    System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    choice = meni(5);
                    break;

                case 6:
                    Set<Character> digits = DigitFinder.findDigits();
                    System.out.println("Цифры, которые встретились в тексте: " + digits);
                    choice = meni(6);
                    break;

                case 7:
                    System.out.println("Задание 7: Очередь (проверка одинаковых соседей по кругу)");
                    Scanner scanner7 = new Scanner(System.in);
                    System.out.println("Введите элементы очереди через пробел:");
                    String line7 = scanner7.nextLine();
                    String[] parts = line7.split(" ");

                    Queue<String> queue = new LinkedList<>();
                    for (String p : parts) {
                        queue.add(p);
                    }

                    boolean result7 = QueueChecker.hasEqualNext(queue);
                    if (result7) {
                        System.out.println("В очереди есть элементы, равные следующему по кругу.");
                    } else {
                        System.out.println("Таких элементов нет.");
                    }
                    choice = meni(7);
                    break;

                case 8:
                    System.out.println("Задание 8: Stream (Polyline из точек)");

                    System.out.println("Введите количество точек:");
                    int n8 = scanner.nextInt();
                    scanner.nextLine();

                    List<Point> points = new ArrayList<>();
                    for (int i = 0; i < n8; i++) {
                        System.out.println("Введите координаты точки X Y:");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        scanner.nextLine();
                        points.add(new Point(x, y));
                    }

                    Polyline polyline = StreamExample.buildPolyline(points);
                    System.out.println("Результат: " + polyline);
                    choice = meni(8);
                    break;

                case 9:
                    System.out.println("Задание 9 : Stream (группировка имён по номерам)");
                    Map<Integer, List<String>> result9 = PeopleStream.process();
                    System.out.println(result9);
                    choice = meni(9);
                    break;
                case 0:
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    choice = -1;
                    break;
            }
        }
    }

    /**
     * Метод упрощённого выбора действий
     *
     * @param number выбор пользователя
     * @return возвращается число, определяющее дальнейшие действия программы, -1 - главное меню, 2 - повтор задания, 0 -выход
     * */
    private static int meni(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие");
        System.out.println("1 - Меню");
        System.out.println("2 - повторить задание");
        System.out.println("0 - Выход");

        int choiceTwo = scanner.nextInt();

        switch (choiceTwo) {
            case 1:
                return -1;
            case 2:
                return number;
            case 0:
                System.out.println("Выход");
                return 0;
            default:
                System.out.println("Некорректный выбор. Возврат в меню.");
                return -1;
        }
    }
}