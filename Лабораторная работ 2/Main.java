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
                System.out.println("1 - Создание личностей ФИО");
                System.out.println("2 - Создание личностей ФИО с ростом");
                System.out.println("3 - Создание человека с родителем.");
                System.out.println("4 - Создание системы городов и маршрутов");
                System.out.println("5 - Создание имен с разными конструкторами");
                System.out.println("6 - Создание человека разными способами");
                System.out.println("7 - Создание Кота Барсика");
                System.out.println("0 - ВЫХОД");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("1 - Создание личностей через ФИО");

                    Scanner scannerCase1 = new Scanner(System.in);

                    System.out.println("Имена задания №1");
                    Name name1 = new Name("Клеопатра");
                    Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name name3 = new Name("Маяковский", "Владимир");

                    System.out.println("1. " + name1.toString());
                    System.out.println("2. " + name2.toString());
                    System.out.println("3. " + name3.toString());

                    System.out.println("Личный ввод пользователя");
                    System.out.println("Хотите ввести свои данные? (да/нет)");
                    String answer = scannerCase1.nextLine();

                    //проверка равности строк без регистра
                    if (answer.equalsIgnoreCase("да")) {
                        Name userName = inputUserName(scannerCase1);
                        if (userName != null) {
                            System.out.println("Результат: " + userName.toString());
                        }
                    } else {
                        System.out.println("Возврат в меню");
                    }

                    choice = meni(1);
                    break;

                case 2:
                    System.out.println("2 - Создание личностей через ФИО с ростом");

                    Scanner scannerCase2 = new Scanner(System.in);

                    System.out.println("Имена задания №2");

                    Name nameOneEx2 = new Name("Клеопатра");
                    Name nameTwoEx2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name nameThreeEx2 = new Name("Маяковский", "Владимир");

                    Person person1 = new Person(nameOneEx2, 152);
                    Person person2 = new Person(nameTwoEx2, 167);
                    Person person3 = new Person(nameThreeEx2, 189);

                    System.out.println("1. " + person1.toString());
                    System.out.println("2. " + person2.toString());
                    System.out.println("3. " + person3.toString());

                    System.out.println("Личный ввод пользователя");
                    System.out.println("Хотите ввести свои данные? (да/нет)");
                    String answerEx2 = scannerCase2.nextLine();

                    if (answerEx2.equalsIgnoreCase("да")) {
                        Name userName = inputUserName(scannerCase2);  // Используем метод из case 1
                        if (userName != null) {
                            System.out.print("Введите рост (положительное число): ");
                            int userHeight = GlobalVerification.numberNum();

                            Person userPerson = new Person(userName, userHeight);
                            System.out.println("Результат: " + userPerson.toString());
                        }
                    } else {
                        System.out.println("Возврат в меню");
                    }

                    choice = meni(2);
                    break;

                case 3:
                    System.out.println("3 - Создание человека с родителем");

                    System.out.println("Имена задания №3 и установка родственных связей");

                    PersonWithParent ivan = new PersonWithParent(new Name("Чудов", "Иван"), 175);
                    PersonWithParent petr = new PersonWithParent(new Name("Чудов", "Петр"), 180);
                    PersonWithParent boris = new PersonWithParent(new Name("Борис"), 185);

                    System.out.println("Созданы люди:");
                    System.out.println("1. " + ivan.toString());
                    System.out.println("2. " + petr.toString());
                    System.out.println("3. " + boris.toString());

                    System.out.println("Установление родственных связей");
                    petr.setFather(ivan);
                    boris.setFather(petr);

                    System.out.println("После установки родственных связей:");
                    System.out.println("1. " + ivan.toString());
                    System.out.println("2. " + petr.toString());
                    System.out.println("3. " + boris.toString());

                    choice = meni(3);
                    break;

                case 4:
                    System.out.println("4 - Система городов и маршрутов");
                    Scanner scannerCase4 = new Scanner(System.in);
                    City cityA = new City("A");
                    City cityB = new City("B");
                    City cityC = new City("C");
                    City cityD = new City("D");
                    City cityE = new City("E");
                    City cityF = new City("F");
                    System.out.println("Создано 6 городов: A, B, C, D, E, F");
                    cityA.addRoute(cityF, 1);
                    cityA.addRoute(cityD, 6);
                    cityA.addRoute(cityB, 5);
                    cityB.addRoute(cityA, 5);
                    cityB.addRoute(cityC, 3);
                    cityC.addRoute(cityB, 3);
                    cityC.addRoute(cityD, 4);
                    cityD.addRoute(cityC, 4);
                    cityD.addRoute(cityE, 2);
                    cityD.addRoute(cityA, 6);
                    cityE.addRoute(cityF, 2);
                    cityF.addRoute(cityE, 2);
                    cityF.addRoute(cityB, 1);
                    System.out.println(cityA.toString());
                    System.out.println(cityB.toString());
                    System.out.println(cityC.toString());
                    System.out.println(cityD.toString());
                    System.out.println(cityE.toString());
                    System.out.println(cityF.toString());
                    System.out.println("Маршрут из конкретного города");
                    System.out.print("Введите название города (A-F) для поиска маршрутов: ");
                    String searchCity = scannerCase4.nextLine();
                    City selectedCity = null;
                    switch (searchCity) {
                        case "A" -> selectedCity = cityA;
                        case "B" -> selectedCity = cityB;
                        case "C" -> selectedCity = cityC;
                        case "D" -> selectedCity = cityD;
                        case "E" -> selectedCity = cityE;
                        case "F" -> selectedCity = cityF;
                        default -> System.out.println("Город не найден");
                    }

                    if (selectedCity != null) {
                        System.out.println(" Маршруты из города " + selectedCity.getName() + ":");
                        int routeCount = selectedCity.getRouteCount();
                        if (routeCount == 0) {
                            System.out.println("Доступных маршрутов нет");
                        } else {
                            int totalCost = 0;
                            for(int i = 0; i < routeCount; ++i) {
                                City destination = selectedCity.getConnectedCity(i);
                                int cost = selectedCity.getCost(i);
                                System.out.println(" ->> " + destination.getName() + " (стоимость: " + cost + ")");
                                totalCost += cost;
                            }
                            System.out.println("  Общая стоимость всех маршрутов: " + totalCost);
                        }
                    }

                    choice = meni(4);
                    break;

                case 5:
                    System.out.println("5 - Создание имен с разными конструкторами");

                    System.out.println("Личности из задания №5");

                    // Клеопатра - только личное имя
                    NameEx4 nameOneEx4 = new NameEx4("Клеопатра");

                    // Александр Сергеевич Пушкин - все три параметра
                    NameEx4 nameTwoEx4 = new NameEx4("Александр", "Пушкин", "Сергеевич");

                    // Владимир Маяковский - личное имя и фамилия
                    NameEx4 nameThreeEx4 = new NameEx4("Владимир", "Маяковский");

                    // Христофор Бонифатьевич - личное имя и фамилия
                    NameEx4 nameFourEx4 = new NameEx4("Христофор", "Бонифатьевич");

                    System.out.println("1. " + nameOneEx4.toString());
                    System.out.println("2. " + nameTwoEx4.toString());
                    System.out.println("3. " + nameThreeEx4.toString());
                    System.out.println("4. " + nameFourEx4.toString());

                    choice = meni(5);
                    break;

                case 6:
                    System.out.println("6 - Создание человека разными способами");
                    System.out.println("Создание людей разными способами");

                    // Человек с именем Лев (в виде строки) и ростом 170
                    System.out.println("1. Создание человека с именем в виде строки:");
                    PersonConstructor lev = new PersonConstructor("Лев", 170);
                    System.out.println("Результат: " + lev.toString());

                    // Человек с именем Пушкин Сергей (как Имя), ростом 168 и отцом Львом
                    System.out.println("\n2. Создание человека с именем как объект NameEx4 и отцом:");
                    NameEx4 sergeyName = new NameEx4("Сергей", "Пушкин");
                    PersonConstructor sergey = new PersonConstructor(sergeyName, 168, lev);
                    System.out.println("Результат: " + sergey.toString());

                    // Человек с именем Александр (в виде строки), ростом 167 и отцом Сергеем
                    System.out.println("\n3. Создание человека с именем в виде строки и отцом:");
                    PersonConstructor alexander = new PersonConstructor("Александр", 167, sergey);
                    System.out.println("Результат: " + alexander.toString());

                    choice = meni(6);
                    break;

                case 7:
                    System.out.println("7 - Создание Кота Барсика");

                    Scanner scannerCase7 = new Scanner(System.in);

                    System.out.println("Кот из задания №5");
                    Cat barsik = new Cat("Барсик");
                    System.out.println("Создан: " + barsik.toString());

                    System.out.println("Мяуканье Барсика");
                    System.out.print("Один раз: ");
                    barsik.meow();
                    System.out.print("Три раза: ");
                    barsik.meow(3);

                    System.out.println("Создание личного кота");
                    System.out.println("Хотите создать своего кота? (да/нет)");
                    String answerEx5 = scannerCase7.nextLine();

                    if (answerEx5.equalsIgnoreCase("да")) {
                        System.out.print("Введите имя кота: ");
                        String catName = GlobalVerification.stringWithoutNum();

                        Cat userCat = new Cat(catName);
                        System.out.println("Создан: " + userCat.toString());

                        System.out.println("Хотите, чтобы кот мяукнул один раз? (да/нет): ");
                        String meowOnce = scannerCase7.nextLine();
                        if (meowOnce.equalsIgnoreCase("да")) {
                            userCat.meow();
                        } else {
                            System.out.println("Задание пропущено");
                        }

                        System.out.println("Хотите, чтобы кот мяукнул несколько раз? (да/нет): ");
                        String meowMultiple = scannerCase7.nextLine();
                        if (meowMultiple.equalsIgnoreCase("да")) {
                            System.out.println("Сколько раз должен мяукнуть кот? ");
                            int meowCount = GlobalVerification.numberNumMiu();
                            userCat.meow(meowCount);
                        } else {
                            System.out.println("Задание пропущено");
                        }
                    }

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
     * Ввод данных пользователя через консоль с выбором типа ввода.
     *
     * @param scanner сканер для чтения ввода
     * @return объект Name или null при некорректном выборе
     */
    private static Name inputUserName(Scanner scanner) {
        System.out.println("Выберите тип ввода:");
        System.out.println("1 - Только имя");
        System.out.println("2 - Фамилия и имя");
        System.out.println("3 - Полное ФИО");

        int inputType = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        switch (inputType) {
            case 1:
                System.out.print("Введите имя: ");
                String firstNameOnly = GlobalVerification.stringWithoutNum();
                return new Name(firstNameOnly);

            case 2:
                System.out.print("Введите фамилию: ");
                String lastName = GlobalVerification.stringWithoutNum();
                System.out.print("Введите имя: ");
                String firstName = GlobalVerification.stringWithoutNum();
                return new Name(lastName, firstName);

            case 3:
                System.out.print("Введите фамилию: ");
                String fullLastName = GlobalVerification.stringWithoutNum();
                System.out.print("Введите имя: ");
                String fullFirstName = GlobalVerification.stringWithoutNum();
                System.out.print("Введите отчество: ");
                String middleName = GlobalVerification.stringWithoutNum();
                return new Name(fullLastName, fullFirstName, middleName);

            default:
                System.out.println("Некорректный выбор");
                return null;
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
