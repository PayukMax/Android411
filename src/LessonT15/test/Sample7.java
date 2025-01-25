package LessonT15.test;
interface HumFactory<P extends Human>{
    P create(String fn, String ln);
}
public class Sample7 {
    public static void main(String[] args) {
        HumFactory<Human> hhf = Human::new;
        Human human = hhf.create("Olga", "Pavlova");
        System.out.println(human);

    }
}

class Human{
    String firstName;
    String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}