package LessonT16.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet7 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        a.addAll(Arrays.asList(1,2,3,4,5,6,7));
        b.addAll(Arrays.asList(5,6,7,8,9));

        System.out.println("a- "+a);
        System.out.println("b- "+b);

        HashSet<Integer> union = new HashSet<>(a);
        System.out.println("union "+union);
        union.addAll(b); // в надор попадают уникальные из 2х сетов
        System.out.println("union+ "+union);

        HashSet<Integer> intersect = new HashSet<>(a);
        intersect.retainAll(b); // в набор попадает пересечение двух сетов - общие элементы из двух сетов
        System.out.println("int "+intersect);

        HashSet<Integer> substract = new HashSet<>(a);
        substract.removeAll(b); // в набор попадает вычитагние второго сета из первого - общие второго и первого исключились из первого
        System.out.println("sub "+substract);

    }
}
