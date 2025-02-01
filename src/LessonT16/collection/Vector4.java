package LessonT16.collection;

import java.util.Vector;

public class Vector4 {
    public static void main(String[] args) {
        Vector<String> vec = new Vector<>();
        vec.add("Сегрей");
        vec.add("Михаил");
        vec.add("Николай");
        vec.add("Виктор");

        System.out.println(vec);

        System.out.println(vec.firstElement());
        System.out.println(vec.lastElement());
        vec.remove(1);
        System.out.println(vec);
    }
}
