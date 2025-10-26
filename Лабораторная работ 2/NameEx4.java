class NameEx4 {
    private String firstName;    // Личное имя
    private String lastName;     // Фамилия
    private String middleName;   // Отчество

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    // Конструктор только для личного имени
    public NameEx4(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.middleName = null;
    }

    // Конструктор для личного имени и фамилии
    public NameEx4(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
    }

    // Конструктор для всех трех параметров
    public NameEx4(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    /**
     * Проверяет, что строка не null и не пустая.
     *
     * @param name проверяемая строка
     * @return true если строка не null и не пустая, иначе false
     */
    private boolean isSet(String name) {
        return name != null && !name.trim().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isSet(firstName)) {
            result.append(firstName);
        }
        if (isSet(lastName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(lastName);
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