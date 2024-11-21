import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // ЗАДАЧА 1-1

        System.out.println("Задача 1.1 Обобщённая коробка \n ");
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

        System.out.println("\nЗадача 1.3 Сравнимое \n ");

        Count count1 = new Count(5);
        Count count2 = new Count(10);

        // Вызов метода "сравнить" и вывод результата
        System.out.println("Варианты результатов: ");
        System.out.println("-1, когда первое число больше второго ");
        System.out.println("1, когда второе число больше первого ");
        System.out.println("0, когда оба числа равны ");
        System.out.println("Результат сравнения: " + count1.compare(count2));
        // Ожидаемый вывод: "Результат сравнения: -1", так как 5 < 10

        //ЗАДАЧА 2-2

        System.out.println("\nЗадача 2.2 Поиск максимума \n ");

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
        System.out.println("Максимальное значение: " + maxValue); // Output: Maximum value: 42.0

        //ЗАДАЧА 3-1

        System.out.println("\nЗадача 3.1 Функция \n ");

        GenericTransformer transformer = new GenericTransformer();

        // Пример 1: Длина строки
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = transformer.transform(strings, String::length);
        System.out.println("Длины строк: " + lengths); // [6, 5, 2]

        // Пример 2: Абсолютное значение
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absolutes = transformer.transform(numbers, Math::abs);
        System.out.println("Абсолютные значения: " + absolutes); // [1, 3, 7]

        // Пример 3: Максимум в массиве
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{7, 0, -1},
                new int[]{5, 10, 15}
        );
        List<Integer> maxValues = transformer.transform(arrays, array -> Arrays.stream(array).max().orElseThrow());
        System.out.println("Максимальные значения: " + maxValues); // [3, 7, 15]

        //ЗАДАЧА 3-2

        System.out.println("\nЗадача 3.2 Фильтр \n ");

        FilterUtils filter = new FilterUtils();
        List<String> strings2 = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = filter.filter(strings2, s -> s.length() >= 3);
        System.out.println("Filtered strings: " + filteredStrings);

        // 2. Фильтрация положительных чисел
        List<Integer> numbers2 = List.of(1, -3, 7);
        List<Integer> filteredNumbers = filter.filter(numbers2, n -> n <= 0);
        System.out.println("Filtered numbers: " + filteredNumbers);

        // 3. Фильтрация массивов целых чисел, где нет положительных элементов
        List<int[]> arrays2 = List.of(
                new int[]{1, -2, 3},
                new int[]{-4, -5, -6},
                new int[]{0, -1, -3}
        );
        List<int[]> filteredArrays = filter.filter(arrays2, array -> {
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


        //ЗАДАЧА 3-4

        System.out.println("\nЗадача 3.4 Коллекционирование \n ");

        CollectionProcessor<Integer, ArrayList<Collection<Integer>>> processor = new ProcessorImpl<>();

        // Пример 1: Разделение на два списка
        List<Integer> numbers3 = List.of(1, -3, 7);
        List<Collection<Integer>> positiveAndNegative = processor.process(
                numbers3,
                () -> new ArrayList<>() {{
                    add(new ArrayList<>());
                    add(new ArrayList<>());
                }},
                (number, map) -> {
                    if (number > 0) {
                        map.get(0).add(number);
                    } else {
                        map.get(1).add(number);
                    }
                }
        );
        System.out.println("Положительные: " + positiveAndNegative.get(0));
        System.out.println("Отрицательные: " + positiveAndNegative.get(1));

        CollectionProcessor<String, List<ArrayList<String>>> stringsProcessor = new ProcessorImpl<>();
        // Пример 2: Группировка строк по длине
        List<String> strings3 = List.of("qwerty", "asdfg", "zx", "qw");
        String maxLengthString = Collections.max(strings3, Comparator.comparingInt(String::length));
        List<ArrayList<String>> groupedByLength = stringsProcessor.process(
                strings3,
                () -> new ArrayList<>() {{
                    for(int i = 0; i < maxLengthString.length()+1; i++) {
                        add(new ArrayList<>());
                    }
                }},
                (str, map) -> {
                    map.get(str.length()).add(str);
                }
        );
        System.out.println("Группировка по длине: " + groupedByLength);


        CollectionProcessor<String, HashSet<String>> uniqueProcessor = new ProcessorImpl<>();
        // Пример 3: Уникальные значения
        List<String> duplicates = List.of("qwerty", "asdfg", "qwerty", "qw");
        HashSet<String> uniqueSet = uniqueProcessor.process(
                duplicates,
                HashSet::new,
                (elem, lst) -> {
                    lst.add(elem);
                }
        );
        System.out.println("Уникальные значения: " + uniqueSet);
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
