import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // ЗАДАЧА 1-1

        // Создаем коробку, которая может хранить только целые числа
        Box<Integer> intBox = new Box<>();

        // Размещаем в коробке число 3
        intBox.put(3);

        // Проверяем заполненность коробки и извлекаем содержимое
        if (intBox.isFilled()) {
            Integer value = intBox.get();
            System.out.println("Значение из коробки: " + value);
        }

        // Передача коробки в метод и вывод результата
        processBox(intBox);

        //ЗАДАЧА 1-3

        Count count1 = new Count(5);
        Count count2 = new Count(10);

        // Вызов метода "сравнить" и вывод результата
        System.out.println("Результат сравнения: " + count1.compare(count2));
        // Ожидаемый вывод: "Результат сравнения: -1", так как 5 < 10

        //ЗАДАЧА 2-2

        Box2<Integer> box1 = new Box2<>();
        Box2<Double> box2 = new Box2<>();
        Box2<Float> box3 = new Box2<>();

        box1.put(42);
        box2.put(3.14);
        box3.put(7.5f);

        List<Box2<? extends Number>> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);

        double maxValue = Box2.findMaxValue(boxes);
        System.out.println("Maximum value: " + maxValue); // Output: Maximum value: 42.0


        //ЗАДАЧА 3-2

        FilterUtils filter = new FilterUtils();
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = filter.filter(strings, s -> s.length() >= 3);
        System.out.println("Filtered strings: " + filteredStrings);

        // 2. Фильтрация положительных чисел
        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> filteredNumbers = filter.filter(numbers, n -> n <= 0);
        System.out.println("Filtered numbers: " + filteredNumbers);

        // 3. Фильтрация массивов целых чисел, где нет положительных элементов
        List<int[]> arrays = List.of(
                new int[]{1, -2, 3},
                new int[]{-4, -5, -6},
                new int[]{0, -1, -3}
        );
        List<int[]> filteredArrays = filter.filter(arrays, array -> {
            for (int num : array) {
                if (num > 0) {
                    return false;
                }
            }
            return true;
        });
        // Вывод отфильтрованных массивов
        System.out.println("Filtered arrays:");
        for (int[] array : filteredArrays) {
            System.out.print("[");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

    // Метод, который принимает коробку и извлекает её содержимое
    public static void processBox(Box<Integer> box) {
        if (box.isFilled()) {
            Integer value = box.get();
            System.out.println("Результат метода: " + value);
        } else {
            System.out.println("Коробка пуста");
        }
    }
}
