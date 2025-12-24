package cat;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    @Override
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

    @Override
    public String toString() {
        return "кот: " + name;
    }
}