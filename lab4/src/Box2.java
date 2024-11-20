import java.util.Collection;

public class Box2<T> {
    private T content;

    // Метод для помещения объекта в коробку
    public void put(T item) {
        if (content != null) {
            throw new IllegalStateException("The box already contains an item. Cannot place another.");
        }
        content = item;
    }

    // Метод для извлечения объекта из коробки
    public T get() {
        if (content == null) {
            return null;
        }
        T item = content;
        content = null;
        return item;
    }

    // Метод для проверки, заполнена ли коробка
    public boolean isFilled() {
        return content != null;
    }

    // Статический метод для нахождения максимального значения
    public static double findMaxValue(Collection<Box2<? extends Number>> boxes) {
        return boxes.stream()
                .map(Box2::get) // Извлекаем содержимое каждой коробки
                .filter(java.util.Objects::nonNull) // Исключаем null-значения
                .mapToDouble(Number::doubleValue) // Преобразуем в double
                .max() // Находим максимальное значение
                .orElseThrow(() -> new IllegalArgumentException("No numbers present in the boxes"));
    }
}
