package LessonT15.test;

interface Calc4 {
    int calculate();
}

public class Sample2 {
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {

//        Calc operation = () -> x + y;
//        System.out.println(operation.calculate());
        Calc4 operation = () -> {x=30; return x+y;}; // если более одной строки обязательны фигурные скобки и наличие return, не забываем про области видимости переменных
        System.out.println(x);
        System.out.println(operation.calculate());
    }
}
