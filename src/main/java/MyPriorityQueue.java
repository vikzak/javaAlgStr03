import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    /** Вставка O(n) */
    /*public void insert(T item) {
        checkSizeArray();
        list[size] = item;
        size++;
        int i = size - 1;
        while(i > 0 && list[i].compareTo(list[i - 1]) < 0) {
            swap(i, i - 1);
            i--;
        }
    }*/

    /** Извлечение O(1) */
    /*public T remove() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }*/

    /** Вставка О(1) */
    public void insert(T item) {
        checkSizeArray();
        list[size] = item;
        size++;
    }

    /** Извлечение О(n). Через метод выбором */
    public T remove() {
        // если пустая очередь
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // если 1 элемент
        if (size == 1) {
            T temp = list[0];
            list[0] = null;
            return temp;
        }

        // если более 1 элемента
        int indexMax = 0;
        T maxValue = list[indexMax];

        for (int i = 1; i < size; i++) {
            if (list[i].compareTo(maxValue) > 0) {
                indexMax = i;
                maxValue = list[indexMax];
            }
        }

        swap(indexMax, size - 1);
        size--;

        return maxValue;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    private void checkSizeArray() {
        if (isFull()) extendArray();
    }

    private void extendArray() {
        capacity = (int) (capacity * 1.5 + 1);
        T[] extendArray = (T[]) new Comparable[capacity];

        System.arraycopy(list, 0, extendArray, 0, size);

        list = extendArray;
    }
}
