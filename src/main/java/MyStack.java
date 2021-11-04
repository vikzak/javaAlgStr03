import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(T item) {
        checkSizeArray();
        list[size] = item;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    private void checkSizeArray() {
        if (isFull()) extendArray();
    }

    private void extendArray() {
        capacity = (int) (capacity * 1.5 + 1);
        T[] extendArray = (T[]) new Object[capacity];

        System.arraycopy(list, 0, extendArray, 0, size);

        list = extendArray;
    }
}
