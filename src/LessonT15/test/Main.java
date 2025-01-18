package LessonT15.test;

public class Main {
    public static void main(String[] args) {
        int x = 5, y = 3;
        Calc sum = new Calc();
        sum.calcul(x, y);
//        CalcElse mul = new CalcElse();

        Calc mul = new Calc() { // анонимный класс - при создании экземпляра класса не создаем новый класс с наследованием м переопределением метода а пререопределяем прям здесь, поскольку нового класса не создается обратиться к этому переопределению можно только из созданного экземпляра
            @Override
            public void calcul(int a, int b) {
                System.out.println(a * b);
                 }
        };
                mul.calcul(x,y);
    }
}

class Calc {
    public void calcul(int a, int b) {
        System.out.println(a + b);
    }
}

//class CalcElse extends Calc{
//    @Override
//    public void calcul(int a, int b) {
//        System.out.println(a*b);;
//    }
//}
