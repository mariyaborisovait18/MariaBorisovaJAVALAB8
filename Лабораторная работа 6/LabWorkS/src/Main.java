import cache.CacheHandler;
import cache.CacheSixTwo;
import cache.TestSix;
import defaultfor.DefaultHandler;
import defaultfor.TestTwo;
import invokefor.InvokeHandler;
import invokefor.TestOne;
import tostring.TestThree;
import tostring.ToStringHandler;
import two.TestFive;
import two.TwoHandler;
import validate.TestFour;
import validate.ValidateHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добрый день! Какое задание Вы бы хотели рассмотреть?\n");
        int choice = -1;

        while(choice != 0) {
            if (choice == -1) {
                System.out.println("МЕНЮ");
                System.out.println("№ Задания");
                System.out.println("1 - Проверка аннотации invokefor.Invoke");
                System.out.println("2 - Проверка аннотации defaultfor.Default");
                System.out.println("3 - Проверка аннотации tostring.ToString");
                System.out.println("4 - Проверка аннотации validate.Validate");
                System.out.println("5 - Проверка аннотации two.Two");
                System.out.println("6 - Проверка аннотации cache.Cache");
                System.out.println("0 - ВЫХОД");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("Проверка @invokefor.Invoke");
                    try {
                        TestOne testObj = new TestOne();
                        InvokeHandler handler = new InvokeHandler();
                        System.out.println("Автоматический вызов методов с @invokefor.Invoke: ");
                        handler.autInvoke(testObj);
                        System.out.println("Ручной вызов всех методов для сравнения: ");
                        testObj.method1();
                        testObj.method2();
                        testObj.method3();
                    } catch (Exception error) {
                        error.printStackTrace(); // печатает трассировку стека
                    }

                    choice = meni(1);
                    break;

                case 2:
                    System.out.println("Проверка @defaultfor.Default");
                    DefaultHandler handler = new DefaultHandler();
                    handler.processClass(TestTwo.class);
                    choice = meni(2);
                    break;
                case 3:
                    System.out.println("Проверка @tostring.ToString");
                    try {
                        ToStringHandler handler3 = new ToStringHandler();
                        TestThree obj = new TestThree();
                        String result = handler3.generateToString(obj);
                        System.out.println("Все поля:");
                        System.out.println("name: " + obj.getName());
                        System.out.println("age: " + obj.getAge());
                        System.out.println("password: " + obj.getPassword());
                        System.out.println("sale: " + obj.getSalary());
                        System.out.println("Строковое представление: " + result);
                    } catch (Exception error) {
                        error.printStackTrace(); //печатает трассировку стека
                    }
                    choice = meni(3);
                    break;

                case 4:
                    System.out.println("Проверка @validate.Validate");
                    ValidateHandler handler4 = new ValidateHandler();
                    handler4.showClasses(TestFour.class);
                    choice = meni(4);
                    break;

                case 5:
                    System.out.println("Проверка @two.Two");
                    TwoHandler handler5 = new TwoHandler();
                    handler5.processClass(TestFive.class);
                    choice = meni(5);
                    break;
                case 6:
                    System.out.println("Проверка @cache.Cache");
                    CacheHandler handler6 = new CacheHandler();
                    handler6.processClass(TestSix.class);
                    handler6.processClass(CacheSixTwo.class);
                    choice = meni(6);
                    break;
                case 7:

                    choice = meni(7);
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