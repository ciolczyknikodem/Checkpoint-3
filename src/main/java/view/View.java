package view;

class View {

    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected class Iterator<T> {

        private int index;
        private T[] data;

        Iterator(T[] elements) {
            data = elements;
        }

        boolean hasNext() { return index < data.length; }

        public T next() {
            return data[index++];
        }
    }

}

