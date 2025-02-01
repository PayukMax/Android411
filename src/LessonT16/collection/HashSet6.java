package LessonT16.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSet6 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Валентин");
        set.add("Александ");
        set.add("Григорий");
        set.add("Николай");
        set.add("Валентин");
        set.add("Оля");
        set.add("Мария");
        set.add(null);

        System.out.println(set);
        System.out.println(set.contains("Оля"));
        System.out.println(set.remove("Оля"));
        System.out.println(set.contains("Оля"));
        System.out.println(set.size());
        for (String a:set) System.out.println(a);
        set.remove(null);
        System.out.println(set);
    }

}
