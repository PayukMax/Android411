package LessonT16.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList2 {
    public static void main(String[] args) {
        Student st1 = new Student("Ваня",2);
        Student st2 = new Student("Анна",3);
        Student st3 = new Student("Ирина",1);
        Student st4 = new Student("Игорь",3);
        Student st5 = new Student("Роман",2);
        LinkedList<Student> stll = new LinkedList<>();
        stll.add(st1);
        stll.add(st2);
        stll.add(st3);
        stll.add(st4);
        stll.add(st5);

        System.out.println(stll);
        System.out.println(stll.get(2));
        Student st6 = new Student("Мария",2);
        Student st7 = new Student("Сергей",1);
        stll.add(st6);
        stll.add(0,st7);
        System.out.println(stll);
        Student st8 = new Student("VLAD",3);
        stll.set(1,st8); // на позиции 1 заменяем объект на новый
        System.out.println(stll);

        for (Student o:stll) System.out.println(o);

        for (int i = 0; i < stll.size(); i++) {
            System.out.println("Элемент по индексу "+i+" : "+stll.get(i));
               }

        Iterator p = stll.listIterator(2); // хотим пройтись по коллекци но не с начала а с элемента индекса 2
        while (p.hasNext()) System.out.println(p.next());
        System.out.println();
        Iterator it = stll.descendingIterator(); // пробегаемся итератором с последнего по первый
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("Первый элемент "+stll.getFirst());
        System.out.println("Первый элемент "+stll.getLast());
//        stll.clear();
        System.out.println(stll);
        System.out.println("Пустой список: "+stll.isEmpty());

        ListIterator<Student> li1 = stll.listIterator();
        System.out.println("Итерация прямая: ");
        while (li1.hasNext()){
            System.out.println("Index "+li1.nextIndex()+" Element "+li1.next());
        }
        System.out.println(        );
        while (li1.hasPrevious()){
            System.out.println("Index "+li1.previousIndex()+" Element "+li1.previous());
        }

    }
}

class Student{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
