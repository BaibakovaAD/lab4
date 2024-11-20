// Определение интерфейса Сравнимое
public interface Comparable<T> {
    // Метод "сравнить", принимающий объект типа T и возвращающий целое число
    int compare(T object);
}