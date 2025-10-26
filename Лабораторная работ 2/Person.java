// Класс Человек
class Person {
    private Name name;
    private int height;

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}