class Count implements Comparable<Count> {
    private int value;

    // Конструктор
    public Count(int value) {
        this.value = value;
    }

    // Реализация метода "сравнить"
    public int compare(Count anotherObject) {
        return Integer.compare(this.value, anotherObject.value);
    }

    // Геттер для значения (необязательно, для удобства)
    public int getValue() {
        return value;
    }
}