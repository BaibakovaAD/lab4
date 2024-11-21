import java.util.*;
import java.util.function.*;

public interface CollectionProcessor<T, P extends Collection> {
    P process(
            List<T> sourceList,
            Supplier<P> collectionFactory,
            BiConsumer<T, P> processingLogic
    );
}
