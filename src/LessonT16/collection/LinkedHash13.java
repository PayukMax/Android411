package LessonT16.collection;

import java.util.LinkedHashSet;

public class LinkedHash13 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(7);
        lhs.add(33);
        lhs.add(3);
        lhs.add(1);
        lhs.add(4);
        lhs.add(9);
        lhs.add(33);

        System.out.println(lhs);
        lhs.remove(1);
        System.out.println(lhs);
        System.out.println(lhs.contains(1));
        System.out.println(lhs.contains(33));
        System.out.println(lhs.removeIf(x-> x>5)); // удалить все что удовлетворяет условию
        System.out.println(lhs);
    }
}
