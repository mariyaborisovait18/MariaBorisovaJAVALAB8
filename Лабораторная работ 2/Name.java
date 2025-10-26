class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    // Геттеры для полей
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    // Конструктор для всех трех параметров
    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Конструктор только для фамилии и имени
    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    // Конструктор только для имени (личного имени)
    public Name(String firstName) {
        this(null, firstName, null);
    }

    // Метод для проверки, задан ли параметр
    private boolean isSet(String name) {
        return name != null && !name.trim().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isSet(lastName)) {
            result.append(lastName);
        }

        if (isSet(firstName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName);
        }

        if (isSet(middleName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(middleName);
        }

        return result.toString();
    }
}