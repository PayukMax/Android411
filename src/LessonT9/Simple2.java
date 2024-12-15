package LessonT9;

public class Simple2 {
    public static void main(String[] args) {
      Dog d1 = new Dog("Шарик");
      Dog d2 = new Dog("Найда");
      d1.run();
      d2.run();

    }
}

class Dog{
    private String name;
    private Foot foot;

    public Dog(String name) {
        this.name = name;
        foot = new Foot();
    }

    void run() {
        foot.run();
    }

    class Foot{
        void run(){
            String name = "ASASS";
            System.out.println("Собака "+Dog.this.name+" бежит...");// указываем что обращение идет не к ближайшему name а к name принадлежащему экземпляру класса Dog
        }
    }
}