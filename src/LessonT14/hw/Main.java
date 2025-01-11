package LessonT14.hw;

public class Main {
    public static void main(String[] args) {
        System.out.println("Скорость самолете составляет "+Transport.AIRPLANE.getSpeed()+" миль в час.\n");
        System.out.println("Скорости транспортных средств:");
        for (Transport tmp:Transport.values()){
            System.out.println(tmp+" типичная скорость составляет "+tmp.getSpeed()+" миль в час.");
        }


    }
}
