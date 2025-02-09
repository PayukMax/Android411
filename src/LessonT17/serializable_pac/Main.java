package LessonT17.serializable_pac;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) { // сохранение одиночного объекта
//            Person p = new Person("Александр",37,187,true);
//            oos.writeObject(p);
//
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) { // считывание одиночного объекта
//            Person p = (Person) ois.readObject();
//            System.out.println("Имя "+p.getName()+"\nВозраст "+p.getAge());
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        String fileName = "people.txt";
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(new Person("Михаил",30,170,false));
//        people.add(new Person("Александр",20,180,true));
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(people);
//            System.out.println("Файл записан...");
//
//        } catch (Exception e){
//            System.out.println("Проблемка - "+e.getMessage());
//        }

        String fileName = "people.txt";
        ArrayList<Person> newPeople = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) { // считывание одиночного объекта
            newPeople = (ArrayList<Person>) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Person pr:newPeople){
            System.out.println("Имя "+pr.getName()+"\nВозраст "+pr.getAge()+"\nЖенат - "+pr.isMarried()+"\n");
        }

    }
}
class   Person implements Serializable {
    private String name;
    private int age;
    private double height;
    private boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMarried() {
        return married;
    }
}