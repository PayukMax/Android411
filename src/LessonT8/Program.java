package LessonT8;

public class Program {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.name = "Irina";
//        p1.age = 28;
//        Person p2 = new Person("Валентин");
        Person p3 = new Person("Marina",330);
//        p1.displayInfo();
//        p2.displayInfo();
//        p3.name="Валера";
//        p3.age=18;
        p3.displayInfo();
        System.out.println(p3.getName());
        p3.setName("Valera");
        System.out.println(p3.getName());
        p3.setAge(200);
        p3.displayInfo();

    }
}

class Person {
    private String name;
    private int age;
    {
        name = "неизвестно";
        age = 18;
    } // инициализатор по умолчанию, отрабатывает ДО конструктора


    public Person(){
 //       this("Неизвестно",18); // при использовании инициализации по умолчанию можно закоментировать
    }

    public Person(String name){
        this(name,0);
    }
    public Person(String name, int age){
//        this.name=name;
//        this.age=age;
        setName(name);
        setAge(age);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if (age>0 && age<110)
        this.age=age;
    }

    void displayInfo(){
        System.out.printf("Name: %s  Age: %d%n",name,age);
    }
}