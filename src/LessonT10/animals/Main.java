package LessonT10.animals;

public class Main {
    public static void main(String[] args) {
        Animal an = new Animal();
//        Animal an1 = new Cat();
        Cat an1 = new Cat();
        Animal an2 = new Dog();
        an.voice();
        an1.voice("Мурзик");
        an2.voice();

    }
}
