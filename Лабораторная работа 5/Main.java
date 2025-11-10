import java.util.Scanner;
import animals.Cat;
import list.ListProcessor;
import animals.CountingCat;
import fraction.CachedFraction;
import fraction.Fraction;
import point.Point;

import java.util.ArrayList;
import java.util.List;

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
                System.out.println("2 - Паттерн Immutable Object на примере класса дробь");
                System.out.println("3 - Структурный паттерн - Decorator на примере класса Cat.");
                System.out.println("4 - Удаление подряд идущих одинаковых элементов");
                System.out.println("5 - Анализ цен на сметану");
                System.out.println("6 - Поиск цифр в тексте");
                System.out.println("7 - Проверка одинаковых соседей в очереди");
                System.out.println("8 - Реализация и демонстрация класса точка");
                System.out.println("9 - Реализация и демонстрация класса линия");
                System.out.println("10 - Реализация и демонстрация класса ломанная");
                System.out.println("11 - Реализация stream по классу ломанная");
                System.out.println("12 - Реализация stream по классу файла");
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
                    System.out.println("2 - Паттерн Immutable Object на примере класса дробь");

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
                    System.out.println("4 - Удаление подряд идущих одинаковых элементов");

                    // Показываем пример работы
                    System.out.println("Пример работы программы:");
                    List<Integer> example = new ArrayList<>();
                    example.add(1);
                    example.add(1);
                    example.add(2);
                    example.add(2);
                    example.add(2);
                    example.add(3);
                    example.add(4);
                    example.add(4);
                    example.add(5);

                    // Создаем объект и обрабатываем
                    ListProcessor exampleProcessor = new ListProcessor(example);
                    exampleProcessor.process();

                    System.out.println(exampleProcessor.toString());

                    // Спрашиваем пользователя
                    System.out.println("Хотите ввести свой список? (да/нет)");
                    String answer = scanner4.next();

                    if (answer.equalsIgnoreCase("да")) {
                        // Создаем новый список для пользователя
                        List<Integer> userList = new ArrayList<>();

                        System.out.println("Сколько чисел будет в списке?");
                        int count = GlobalVerification.numberNumPlus();

                        System.out.println("Введите " + count + " чисел от 1 до 9:");
                        for (int i = 0; i < count; i++) {
                            System.out.print("Число " + (i + 1) + ": ");
                            int number = GlobalVerification.numberNumNum();
                            userList.add(number);
                        }
                        // Создаем новый объект для пользовательского списка
                        ListProcessor userProcessor = new ListProcessor(userList);
                        userProcessor.process();

                        System.out.println("Результат обработки вашего списка:");
                        System.out.println(userProcessor.toString());
                    }

                    choice = meni(4);
                    break;

                case 5:
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("5 - Анализ цен на сметану");

                    // Ввод количества магазинов
                    System.out.println("Сколько магазинов?");
                    int n = GlobalVerification.numberNumPlus();
                    scanner.nextLine();

                    // Создаем объект
                    SmetanaAnalyzer analyzer = new SmetanaAnalyzer();

                    System.out.println("Введите данные магазинов. Пример: Перекресток(фирма) Короленко(улица) 25(жирность) 120(цена) ");

                    for (int i = 0; i < n; i++) {
                        System.out.print("Магазин " + (i + 1) + ": ");
                        String data = scanner.nextLine();
                        analyzer.addStore(data);
                    }

                    // Выводим результат
                    System.out.println("Результат:");
                    System.out.println(analyzer.toString());

                    choice = meni(5);
                    break;

                case 6:
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("6 - Поиск цифр в тексте");

                    FileDigitFinder finder = new FileDigitFinder();

                    System.out.println("Введите текст на русском языке:");
                    scanner.nextLine(); // очистка буфера
                    String text = scanner6.nextLine();

                    finder.createFile(text);

                    // Ищем цифры в файле
                    finder.findDigits();

                    // Выводим результат
                    System.out.println(finder.toString());

                    // Показываем сколько каких цифр нашлось
                    if (!finder.digitsFound.isEmpty()) {
                        System.out.println("Всего найдено цифр: " + finder.digitsFound.size());

                        // Считаем каждую цифру
                        int[] count = new int[10];
                        for (char digit : finder.digitsFound) {
                            int num = digit - '0';
                            count[num]++;
                        }

                        System.out.println("Подробно:");
                        for (int i = 0; i < 10; i++) {
                            if (count[i] > 0) {
                                System.out.println("Цифра " + i + ": " + count[i] + " раз");
                            }
                        }
                    }

                    choice = meni(6);
                    break;

                case 7:
                    Scanner scanner7 = new Scanner(System.in);
                    System.out.println("7 - Проверка одинаковых соседей в очереди");

                    QueueChecker q = new QueueChecker();

                    System.out.println("Сколько чисел добавить в очередь?");
                    int number = GlobalVerification.numberNumPlus();

                    System.out.println("Введите " + number + " чисел: от 1 до 9");
                    for (int i = 0; i < number; i++) {
                        System.out.print("Число " + (i + 1) + ": ");
                        int num = GlobalVerification.numberNumNum();
                        q.addNumber(num);
                    }

                    q.check();

                    // Выводим результаты
                    System.out.println("Результаты:");
                    System.out.println("Очередь: " + q.numbers);
                    System.out.println("Размер: " + q.count + " элементов");
                    System.out.println("Есть одинаковые соседи: " + q.result);

                    if (q.result) {
                        System.out.println(" Есть одинаковые числа рядом!");
                    } else {
                        System.out.println(" Нет одинаковых чисел рядом");
                    }

                    choice = meni(7);
                    break;

                case 8:
                    // Работа с точками
                    Scanner scanner8 = new Scanner(System.in);
                    System.out.println("8 - Реализация и демонстрация класса точка");

                    System.out.println("Создаем первую точку:");
                    System.out.print("Введите координату X: ");
                    double x1 = scanner8.nextDouble();
                    System.out.print("Введите координату Y: ");
                    double y1 = scanner8.nextDouble();
                    Point point1 = new Point(x1, y1);

                    // Создаем вторую точку
                    System.out.println("Создаем вторую точку:");
                    System.out.print("Введите координату X: ");
                    double x2 = scanner8.nextDouble();
                    System.out.print("Введите координату Y: ");
                    double y2 = scanner8.nextDouble();
                    Point point2 = new Point(x2, y2);

                    Point point3 = new Point();

                    // Показываем точки через toString
                    System.out.println("Наши точки:");
                    System.out.println("Точка 1: " + point1.toString());
                    System.out.println("Точка 2: " + point2.toString());
                    System.out.println("Точка 3 (по умолчанию): " + point3.toString());

                    // Показываем свойства через геттеры
                    System.out.println("Свойства точек:");
                    System.out.println("Точка 1 - X: " + point1.getX() + ", Y: " + point1.getY());
                    System.out.println("Точка 2 - X: " + point2.getX() + ", Y: " + point2.getY());
                    System.out.println("Точка 3 - X: " + point3.getX() + ", Y: " + point3.getY());

                    // Меняем координаты через сеттеры
                    System.out.println("Меняем координаты точки 3:");
                    point3.setX(10.5);
                    point3.setY(20.7);
                    System.out.println("Точка 3 после изменений: " + point3.toString());

                    choice = meni(8);
                    break;

                case 9:
                    // Работа с линиями
                    Scanner scanner9 = new Scanner(System.in);
                    System.out.println("9 - Реализация и демонстрация класса линия");

                    System.out.println("Создаем первую линию:");
                    System.out.println("Начальная точка:");
                    System.out.print("Введите X начала: ");
                    double startX1 = scanner9.nextDouble();
                    System.out.print("Введите Y начала: ");
                    double startY1 = scanner9.nextDouble();
                    System.out.println("Конечная точка:");
                    System.out.print("Введите X конца: ");
                    double endX1 = scanner9.nextDouble();
                    System.out.print("Введите Y конца: ");
                    double endY1 = scanner9.nextDouble();

                    Point start1 = new Point(startX1, startY1);
                    Point end1 = new Point(endX1, endY1);
                    Line line1 = new Line(start1, end1);

                    // Создаем вторую линию через координаты
                    System.out.println("Создаем вторую линию:");
                    System.out.print("Введите X начала: ");
                    double startX2 = scanner9.nextDouble();
                    System.out.print("Введите Y начала: ");
                    double startY2 = scanner9.nextDouble();
                    System.out.print("Введите X конца: ");
                    double endX2 = scanner9.nextDouble();
                    System.out.print("Введите Y конца: ");
                    double endY2 = scanner9.nextDouble();

                    Line line2 = new Line(startX2, startY2, endX2, endY2);
                    Line line3 = new Line();

                    System.out.println("Наши линии:");
                    System.out.println("Линия 1: " + line1.toString());
                    System.out.println("Линия 2: " + line2.toString());
                    System.out.println("Линия 3 (по умолчанию): " + line3.toString());

                    System.out.println("Свойства линий:");
                    System.out.println("Линия 1 - начало: " + line1.getStart().toString() + ", конец: " + line1.getEnd().toString());
                    System.out.println("Линия 2 - начало: " + line2.getStart().toString() + ", конец: " + line2.getEnd().toString());

                    // Меняем координаты через сеттеры
                    System.out.println("Меняем координаты линии 3:");
                    Point newStart = new Point(5, 10);
                    Point newEnd = new Point(15, 20);
                    line3.setStart(newStart);
                    line3.setEnd(newEnd);
                    System.out.println("Линия 3 после изменений: " + line3.toString());

                    choice = meni(9);
                    break;

                case 10:
                    Scanner scanner10 = new Scanner(System.in);
                    System.out.println("10 - Реализация и демонстрация класса ломанная");

                    Polyline polyline1 = new Polyline();

                    System.out.println("Создаем первую ломаную линию:");
                    System.out.print("Сколько точек будет в ломаной? ");
                    int pointCount1 = GlobalVerification.numberNumPlus();

                    for (int i = 0; i < pointCount1; i++) {
                        System.out.println("Точка " + (i + 1) + ":");
                        System.out.print("Введите X: ");
                        double x = scanner10.nextDouble();
                        System.out.print("Введите Y: ");
                        double y = scanner10.nextDouble();
                        polyline1.addPoint(x, y);
                    }

                    System.out.println("Создаем вторую ломаную линию:");
                    List<Point> pointsList = new ArrayList<>();

                    System.out.print("Сколько точек будет в ломаной? ");
                    int pointCount2 = GlobalVerification.numberNumPlus();

                    for (int i = 0; i < pointCount2; i++) {
                        System.out.println("Точка " + (i + 1) + ":");
                        System.out.print("Введите X: ");
                        double x = scanner10.nextDouble();
                        System.out.print("Введите Y: ");
                        double y = scanner10.nextDouble();
                        pointsList.add(new Point(x, y));
                    }

                    Polyline polyline2 = new Polyline(pointsList);
                    Polyline polyline3 = new Polyline();

                    System.out.println("Наши ломаные линии:");
                    System.out.println("Ломаная 1: " + polyline1.toString());
                    System.out.println("Ломаная 2: " + polyline2.toString());
                    System.out.println("Ломаная 3 (по умолчанию): " + polyline3.toString());

                    System.out.println("Свойства:");
                    System.out.println("Ломаная 1 - точек: " + polyline1.getPoints().size());
                    System.out.println("Ломаная 2 - точек: " + polyline2.getPoints().size());

                    System.out.println("Добавляем точки в ломаную 3:");
                    polyline3.addPoint(1, 1);
                    polyline3.addPoint(3, 4);
                    polyline3.addPoint(5, 2);
                    System.out.println("Ломаная 3 после добавления точек: " + polyline3.toString());

                    choice = meni(10);
                    break;

                case 11:
                    Scanner scanner11 = new Scanner(System.in);
                    System.out.println("11 - Реализация stream по классу ломанная");
                    PointProcessor processor = new PointProcessor();

                    System.out.print("Сколько точек обработать? ");
                    int count = GlobalVerification.numberNumPlus();

                    for (int i = 0; i < count; i++) {
                        System.out.println("Точка " + (i + 1) + ":");
                        System.out.print("Введите X: ");
                        double x = scanner11.nextDouble();
                        System.out.print("Введите Y: ");
                        double y = scanner11.nextDouble();
                        processor.addPoint(x, y);
                    }

                    processor.processPoints();

                    System.out.println(" " + processor.toString());

                    System.out.println("Подробный отчет:");
                    System.out.println("Исходное количество точек: " + processor.getOriginalPoints().size());
                    System.out.println("Количество после обработки: " + processor.getProcessedPoints().size());
                    System.out.println("Ломаная содержит точек: " + processor.getResultPolyline().getPoints().size());

                    choice = meni(11);
                    break;
                case 12:

                    Scanner scanner12 = new Scanner(System.in);
                    System.out.println("12 - Реализация stream по классу файла");

                    PeopleProcessor processorOne = new PeopleProcessor("a.txt", "b.txt");
                    System.out.print("Сколько людей вы хотите ввести? ");
                    int peopleCount = GlobalVerification.numberNumPlus();
                    for (int i = 0; i < peopleCount; i++) {
                        System.out.println("Человек " + (i + 1) + ":");
                        System.out.print("Введите имя: ");
                        String name = scanner12.nextLine();

                        System.out.print("Введите число от 1 до 9 (или Enter если номера нет): ");
                        String numberInput = scanner12.nextLine();

                        Integer numberOne = null;
                        if (!numberInput.trim().isEmpty()) {
                            try {
                                numberOne = Integer.parseInt(numberInput.trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Неверный формат числа, будет сохранено без номера");
                            }
                        }
                        processorOne.addPerson(name, numberOne);
                    }

                    // Записываем данные в файл a.txt
                    processorOne.writeToInputFile();
                    System.out.println("Данные записаны в файл " + processorOne.getInputFileName());

                    processorOne.processPeople();

                    // Записываем результат в файл b.txt
                    processorOne.writeResultToFile();
                    System.out.println("Результат записан в файл " + processorOne.getOutputFileName());

                    // Выводим результаты
                    System.out.println(" " + processorOne.toString());
                    System.out.println("Результат группировки: " + processorOne.getResultString());

                    choice = meni(12);
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