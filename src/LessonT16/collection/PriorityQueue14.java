package LessonT16.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue14 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));// лямбда выражение возвращается String кретий сортировки - length
        pq.add("Александр");
        pq.add("Игорь");
        pq.add("Андрей");
        System.out.println(pq);
        while (!pq.isEmpty()) System.out.println(pq.remove());
    }
}
