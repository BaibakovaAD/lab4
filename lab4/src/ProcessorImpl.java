import java.util.*;
import java.util.function.*;

public class ProcessorImpl<T, P extends Collection<T>> implements CollectionProcessor<T, P> {

    public P process(List<T> sourceList, Supplier<P> collectionFactory, BiConsumer<T, P> processingLogic) {
        P result = collectionFactory.get();
        for (T item : sourceList) {
            processingLogic.accept(item, result);
        }
        return result;
    }
}