package LessonT11;
// абстрактные классы - классы и методы
// реализация который в родительском отсутствует
// но обязывает реализовать оверрайд в дочернем
// классе



public class Sample {
    public static void main(String[] args) {
    Dog d1 = new Dog("Бобик");
    Animal d2 = new Cat("Мурзик");

    d1.makeSound();
    d1.sleep();
    d2.makeSound();
    d2.sleep();

    // еще вариант реализации - создать по родителю коллеуцию и напихать туда потомков
    Animal an[]= new Animal[2];
    an[0]=d1;
    an[1]=d2;

        for (int i = 0; i < an.length; i++) {
            an[i].makeSound();

        }

    }
}

abstract class Animal{
    private String name;

    public Animal(String name){
        this.name= name;
    }
    public void sleep(){
        System.out.println(name+" спит...");
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" гавкает...");
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" мяукает...");
    }
}