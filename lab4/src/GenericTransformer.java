import java.util.ArrayList;
import java.util.List;

public class GenericTransformer {
    // Универсальный метод для преобразования списка
    public <T, P> List<P> transform(List<T> input, Function<T, P> transformer) {
        List<P> result = new ArrayList<>();
        for (T item : input) {
            result.add(transformer.apply(item));
        }
        return result;
    }
}