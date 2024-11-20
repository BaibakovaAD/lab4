import java.util.ArrayList;
import java.util.List;

public class FilterUtils {
    // Метод фильтрации
    public <T> List<T> filter(List<T> list, Tester<T> tester) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (tester.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}