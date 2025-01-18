package LessonT14.exeption.dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        dog.putCollar();
        dog.putLeash();
        dog.putMuzzle();

        try {
            dog.walk();
        }catch (DogsIsNotReadyExeption e){
            System.out.println(e.getMessage());
            System.out.println("\nПроверяем снаряжение:\nошейник - "+dog.isCollarPutOn+"\nповодок - "+dog.isLeashPutOn+"\nнамордник - "+dog.isMuzzlePutOn+"\n");
        }


    }
}
