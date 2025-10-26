class PersonWithParent {
    private Name name;
    private int height;
    private PersonWithParent father;

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public PersonWithParent getFather() {
        return father;
    }

    public PersonWithParent(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public PersonWithParent(Name name, int height, PersonWithParent father) {
        this.name = name;
        this.height = height;
        this.father = father;
        updateNameFromFather(); // Обновляем имя на основе данных отца
    }

    /** Устанавливает связь с отцом для текущего человека.
    * После установки отца автоматически обновляет имя, фамилию и отчество
    * в соответствии с данными отца (например, наследуется фамилия отца).
    *
    * @param father объект PersonWithParent, представляющий отца.
    * Если передается {@code null}, связь с отцом удаляется
    * и связанные с отцом данные сбрасываются.
    */
    public void setFather(PersonWithParent father) {
        this.father = father;
        updateNameFromFather(); // Обновляем имя на основе данных отца
    }

    /**
     * Обновляет фамилию и отчество на основе данных отца.
     * Если фамилия или отчество не заданы, наследует их от отца.
     */
    private void updateNameFromFather() {
        if (father != null && father.name != null) {
            // Если у текущего человека нет фамилии, а у отца есть
            if ((name.getLastName() == null || name.getLastName().isEmpty()) &&
                    father.name.getLastName() != null && !father.name.getLastName().isEmpty()) {
                name = new Name(father.name.getLastName(), name.getFirstName(), name.getMiddleName());
            }

            // Если у текущего человека нет отчества, а у отца есть имя
            if ((name.getMiddleName() == null || name.getMiddleName().isEmpty()) &&
                    father.name.getFirstName() != null && !father.name.getFirstName().isEmpty()) {
                name = new Name(name.getLastName(), name.getFirstName(), father.name.getFirstName() + "ович");
            }
        }
    }

    @Override
    public String toString() {
        return name + ", рост: " + height + (father != null ? " (сын " + father.name.getFirstName() + "а)" : "");
    }
}