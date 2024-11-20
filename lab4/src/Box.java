public class Box<T> {
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


    }

