package LessonT15.test;

interface CalcInterface{ // функциональный интерфейс - содержит ОДИН не реализованный метод
    int calculate(int a, int b);
}

//class Calc implements CalcInterface{ // один подход - создать класс имплементировать интерфейс с реализацией метода
//    @Override
//    public void calculate(int a, int b) {
//        System.out.println(a+b);
//    }
//}

public class Main {
    // Занятие 30
    public static void main(String[] args) {
        int x = 5, y = 3;
//    CalcInterface sum = new Calc(); // далее создать экземпляр класса и и выполниьт метод
//    CalcInterface sum = new CalcInterface() { // или создать анонимный класс на базе интерфейса с реализацией необходимого интерфейса
//        @Override
//        public void calculate(int a, int b) {
//            System.out.println(a+b);
//        }
//    };
        // то же что было выше - заменили на лямбда выражение (в подсказке серого CalcInterface)
        CalcInterface sum = (a, b) -> (a + b);
        CalcInterface sub = (a, b) -> (a - b);
        CalcInterface mul = (a, b) -> (a * b);
        int res = sum.calculate(x, y);
        System.out.println(res);
        System.out.println(sub.calculate(x, y));
        System.out.println(mul.calculate(x, y));


    }

}



//// Занятие 29
//    public static void main(String[] args) {
//        int x = 5, y = 3;
//        Calc sum = new Calc();
//        sum.calcul(x, y);
////        CalcElse mul = new CalcElse();
//
//        Calc mul = new Calc() { // анонимный класс - при создании экземпляра класса не создаем новый класс с наследованием м переопределением метода а пререопределяем прям здесь, поскольку нового класса не создается обратиться к этому переопределению можно только из созданного экземпляра
//            @Override
//            public void calcul(int a, int b) {
//                System.out.println(a * b);
//                 }
//        };
//                mul.calcul(x,y);
//    }
//}
//
//class Calc {
//    public void calcul(int a, int b) {
//        System.out.println(a + b);
//    }
//}
//
////class CalcElse extends Calc{
////    @Override
////    public void calcul(int a, int b) {
////        System.out.println(a*b);;
////    }
////}
