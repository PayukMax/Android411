package LessonT16.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet12 {
    public static void main(String[] args) {
        TreeSet<Student2> treeSet = new TreeSet<>();
        Student2 st1 = new Student2("Ваня", 3);
        Student2 st2 = new Student2("МИхаил", 1);
        Student2 st3 = new Student2("ольга", 3);
        Student2 st4 = new Student2("Алеск", 2);
        Student2 st5 = new Student2("Петя", 4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());

        Student2 st6 = new Student2("AAAAAAA", 3);
        System.out.println(treeSet.headSet(st6));// объекты меньше сравниваемо
        System.out.println(treeSet.tailSet(st6));// объекты равно и больше сравниваемого
        Student2 st7 = new Student2("BBBBB", 2);
        Student2 st8 = new Student2("CCC", 4);
        System.out.println(treeSet.subSet(st7, st8));// объекты между предлагаемыми
        System.out.println("++++++++++++++++++++++");
        Iterator<Student2> iter = treeSet.iterator(); // прогоняем по увеличению
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("++++++++++++++++++++++");
        Iterator<Student2> iter2 = treeSet.descendingIterator();// прогоняем по убыванию
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}

class Student2 implements Comparable<Student2> {
    String name;
    int course;

    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student2 o) {
        return this.course - o.course;
    }
}