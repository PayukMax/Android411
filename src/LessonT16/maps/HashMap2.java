package LessonT16.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMap2 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Вася", "Борисов", 2);
        Student st2 = new Student("Анна", "Полякова", 1);
        Student st3 = new Student("Ирина", "Ринатова", 1);
        map.put(st1, 8.6);
        map.put(st2, 7.9);
        map.put(st3, 9.3);
        System.out.println(map);
        Student st4 = new Student("Вася", "Борисов", 2);
        System.out.println(map.containsKey(st4));
        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());

        for (Map.Entry<Student, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
//        st1.course = 3;
        System.out.println("Key1 enable?" + st1.hashCode() + " - " + map.containsKey(st1));
    }
}

class Student {
    final String name;
    final String surname;
    final int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

//    @Override
//    public int hashCode() {
//        return name.length()+surname.length()+course;
//    }

}