package LessonT14.exeption.dog;

public class Dog {
    String name;
    boolean isCollarPutOn;// ошейник
    boolean isLeashPutOn; // поводок
    boolean isMuzzlePutOn; // намордник

    public Dog(String name) {
        this.name = name;
    }
    public void putCollar(){
        System.out.println("Ошейник одет...");
        isCollarPutOn = true;
    }
    public void putLeash(){
        System.out.println("Поводок одет...");
        isLeashPutOn = true;
    }
    public void putMuzzle(){
        System.out.println("Намордник одет...");
        isMuzzlePutOn = true;
    }

    public void walk() throws DogsIsNotReadyExeption{
        System.out.println("Собираемся на прогулку...");
        if(isCollarPutOn && isLeashPutOn && isMuzzlePutOn){
            System.out.println("Ура, идем гулять! "+name+" очень рад...");
        } else {
            throw  new DogsIsNotReadyExeption("Собака "+name+" не готова к прогулке. Проверьте экип...");
        }
    }

}
