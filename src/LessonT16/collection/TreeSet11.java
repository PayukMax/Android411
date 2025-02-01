package LessonT16.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSet11 {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(3);
        System.out.println(treeSet);
        treeSet.remove(3);// удаление происходит по значению
        System.out.println(treeSet);
        System.out.println(treeSet.contains(3));// проверка наличия в наборе
        System.out.println(treeSet.contains(5));
    }
}
