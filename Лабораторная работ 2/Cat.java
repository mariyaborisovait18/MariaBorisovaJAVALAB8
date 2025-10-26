class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    /**
     * Выводит мяуканье кота в консоль.
     * Формат вывода: "имя_кота: мяу!"
     */
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    /**
     * Выводит многократное мяуканье кота в консоль.
     * Кот мяукает указанное количество раз через дефис.
     *
     * @param n количество мяуканий. Если n <= 0, выводится многоточие
     */
    public void meow(int n) {
        if (n <= 0) {
            System.out.println(name + ": ...");
            return;
        }

        StringBuilder meowString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                meowString.append("-");
            }
            meowString.append("мяу");
        }
        meowString.append("!");
        System.out.println(name + ": " + meowString.toString());
    }
}