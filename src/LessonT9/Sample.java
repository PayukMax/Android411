package LessonT9;

public class Sample {
    public static void main(String[] args) {
        Outer out = new Outer("внешний...");
        System.out.println(out.name);
//        Outer.Inner in = new Outer.Inner("внутренний") // так обращение к внутреннему классу не работает
        System.out.println(out.inner.innerName); //  а так обратиться можно к экземплру созданного внутреннего класса
        Outer.Inner.info(); // а к статическим методам класса можем обратиться через имена классов, не через экземпляры
        out.inner.func();// к публичным, не статическим, методам обращаемся через экземпляр класса по иерархии
    }
}

class Outer{
    String name;
    Inner inner;

    public Outer(String name) {
        this.name = name;
        inner = new Inner("внутренний..."); // чтобы иметь возможность снаружи обраться к внутремму класу создадим его
    }

    class Inner{
        static int age;
        String innerName;

        static{
            age=18;
        }

        public Inner(String innerName) {
            this.innerName = innerName;
        }

        public static void info(){
            System.out.println("Статический метод...");
        }
        public void func(){
            System.out.println("Метод во вложенном классе...");
        }
    }

}