public class Main {
    public static void main(String[] args) {
        // Создать программу, которая переворачивает вводимые строки (читает справа налево).
        MyReverseString reverseString = new MyReverseString("Привет! Как дела?");
            System.out.println("Исходная строка: " + reverseString.getString());
            System.out.println("Реверсия строки: " + reverseString.getReverseString());

        // Приоритетная очередь. Вставка О(1), извлечение О(n)
        System.out.println("\nПриоритетная очередь. Вставка О(1), извлечение О(n):");
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>(3);
        myPriorityQueue.insert(7);
        myPriorityQueue.insert(6);
        myPriorityQueue.insert(3);
        myPriorityQueue.insert(2);
        myPriorityQueue.insert(9);
        myPriorityQueue.insert(2);
            System.out.println(myPriorityQueue);
            System.out.println(myPriorityQueue.remove());
            System.out.println(myPriorityQueue.remove());
            System.out.println(myPriorityQueue.remove());
            System.out.println(myPriorityQueue);

        // Двунаправленная очередь
        System.out.println("\nДвунаправленная очередь:");
        MyDeque<Integer> myDeque = new MyDeque<>(3);
        myDeque.backInsert(2);
        myDeque.backInsert(3);
            System.out.println("очередь: " + myDeque);
            System.out.println("вместимость: " + myDeque.capacity());
            System.out.println("размер: " + myDeque.size());
        myDeque.backInsert(6);
        myDeque.backInsert(7);
            System.out.println("очередь: " + myDeque);
            System.out.println("вместимость: " + myDeque.capacity());
            System.out.println("размер: " + myDeque.size());
        myDeque.frontInsert(5);
        myDeque.frontInsert(10);
        myDeque.frontInsert(15);
        myDeque.frontInsert(20);
            System.out.println("очередь: " + myDeque);
            System.out.println("вместимость: " + myDeque.capacity());
            System.out.println("размер: " + myDeque.size());
        myDeque.frontInsert(25);
            System.out.println("очередь: " + myDeque);
            System.out.println("вместимость: " + myDeque.capacity());
            System.out.println("размер: " + myDeque.size());
            System.out.println("Элемент с конца: " + myDeque.backPeek());
            System.out.println("Элемент с начала: " + myDeque.frontPeek());
            System.out.println("Получение с конца: " + myDeque.backRemove());
            System.out.println("Получение с начала: " + myDeque.frontRemove());
            System.out.println("очередь: " + myDeque);
            System.out.println("Получение с начала: " + myDeque.frontRemove());
            System.out.println("Получение с начала: " + myDeque.frontRemove());
            System.out.println("очередь: " + myDeque);
    }
}
