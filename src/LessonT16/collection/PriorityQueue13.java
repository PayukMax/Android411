package LessonT16.collection;

import java.util.PriorityQueue;

public class PriorityQueue13 {
    public static void main(String[] args) {
        PriorityQueue<Integer> task = new PriorityQueue();
        task.add(5);
        task.add(1);
        task.add(9);
        task.add(2);
        task.add(3);
        task.add(3);
        System.out.println(task);
        while (!task.isEmpty()) {
            System.out.println(task.remove());// или pool - он удаляет без выставления исключения при окончании элементов
        }
        System.out.println(task.peek());// вернуть верхушку очереди, не удаляя элемент
        System.out.println(task.element()); //  то же что peek, но при пустой очереди вывалит исключение
    }
}
