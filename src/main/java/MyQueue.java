public class MyQueue<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    private int nextIndex(int index) {
        return (index + 1) % capacity;
    }

    public void insert(T item) {
        checkSizeArray();
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue us empty");
        }
        return list[begin];
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T temp = list[begin];
        list[begin] = null;
        begin = nextIndex(begin);
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private void checkSizeArray() {
        if (size == capacity) {
            extendArray();
        }
    }

    private void extendArray() {
        capacity = (int) (capacity * 1.5 + 1);
        T[] extendArray = (T[]) new Object[capacity];

        System.arraycopy(list, begin, extendArray, 0, size - begin);
        System.arraycopy(list, 0, extendArray, size - end, end);

        begin = 0;
        end = size;

        list = extendArray;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = begin, j = 0; j < size; i = nextIndex(i), j++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
