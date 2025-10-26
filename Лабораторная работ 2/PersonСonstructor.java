class PersonConstructor {
    private NameEx4 name;
    private int height;
    private PersonConstructor father;

    public NameEx4 getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public PersonConstructor getFather() {
        return father;
    }
    // Конструктор с именем в виде строки и ростом
    public PersonConstructor(String firstName, int height) {
        this.name = new NameEx4(firstName);
        this.height = height;
    }

    // Конструктор с именем в виде строки, ростом и отцом
    public PersonConstructor(String firstName, int height, PersonConstructor father) {
        this(firstName, height);
        this.father = father;
        updateNameFromFather();
    }

    // Конструктор с именем в виде объекта NameEx4 и ростом
    public PersonConstructor(NameEx4 name, int height) {
        this.name = name;
        this.height = height;
    }

    // 4) Конструктор с именем в виде объекта NameEx4, ростом и отцом
    public PersonConstructor(NameEx4 name, int height, PersonConstructor father) {
        this.name = name;
        this.height = height;
        this.father = father;
        updateNameFromFather();
    }

    private PersonConstructor(NameEx4 name, int height, PersonConstructor father, boolean dummy) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    /**
     * Обновляет фамилию и отчество на основе данных отца.
     * Если фамилия не задана, наследует фамилию отца.
     * Если отчество не задано, формирует его из имени отца.
     */
    private void updateNameFromFather() {
        if (father != null && father.name != null) {
            String currentFirstName = name.getFirstName();
            String currentLastName = name.getLastName();
            String currentMiddleName = name.getMiddleName();

            // Если фамилия не задана, берем у отца
            if ((currentLastName == null || currentLastName.isEmpty()) &&
                    father.name.getLastName() != null && !father.name.getLastName().isEmpty()) {
                currentLastName = father.name.getLastName();
            }

            // Если отчество не задано, а у отца есть имя
            if ((currentMiddleName == null || currentMiddleName.isEmpty()) &&
                    father.name.getFirstName() != null && !father.name.getFirstName().isEmpty()) {
                currentMiddleName = father.name.getFirstName() + "ович";
            }

            // Создаем новое имя с обновленными данными
            this.name = new NameEx4(currentFirstName, currentLastName, currentMiddleName);
        }
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}