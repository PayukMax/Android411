package LessonT15.test;

import java.util.ArrayList;
import java.util.Arrays;

interface Bias {
    boolean test(Person p);
}

enum PetPreference {
    DOG, CAT, SNAKE;
}

public class Sample5 {
    public static void main(String[] args) {
        Person p1 = new Person("Вася", 35, true, PetPreference.DOG, new ArrayList<>(Arrays.asList("изучение языков", "чтение")));
        Person p2 = new Person("Анна", 35, true, PetPreference.SNAKE, new ArrayList<>(Arrays.asList("туризм", "путешествие")));
        Person p3 = new Person("Коля", 25, false, PetPreference.CAT, new ArrayList<>(Arrays.asList("ремонт", "вождение", "трюки")));
        Person p4 = new Person("Оля", 50, true, PetPreference.DOG, new ArrayList<>(Arrays.asList("готовка", "вязание")));
        Person p5 = new Person("Женя", 15, false, PetPreference.DOG, new ArrayList<>(Arrays.asList("мотоциклы", "гонки")));
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        System.out.println(people);
        System.out.println(filter(people, p -> p.isExtrovert()));

        System.out.println(filter(people, p -> p.getPetPreference()== PetPreference.CAT? true:false));

    }

    public static ArrayList<Person> filter(ArrayList<Person> peop, Bias bias){
        ArrayList<Person> filtredPeople = new ArrayList<>();
        for (Person p:peop){
            if (bias.test(p)) filtredPeople.add(p);
        }
        return filtredPeople;
    }

}

class Person {
    private String name;
    private int age;
    private boolean extrovert;
    private PetPreference petPreference;
    private ArrayList<String> hobbies;

    public Person(String name, int age, boolean extrovert, PetPreference petPreference, ArrayList<String> hobbies) {
        this.name = name;
        this.age = age;
        this.extrovert = extrovert;
        this.petPreference = petPreference;
        this.hobbies = hobbies;
    }

    public boolean isExtrovert() {
        return extrovert;
    }

    public PetPreference getPetPreference() {
        return petPreference;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", extrovert=" + extrovert +
                ", petPreference=" + petPreference +
                ", hobbies=" + hobbies +
                '}';
    }
}