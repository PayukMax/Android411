package LessonT14.generics;

import java.sql.SQLOutput;

public class Sample6 {
    public static void main(String[] args) {
    Digit d1 = new Digit(10);
    Digit d2 = new Digit(10.5);
    Digit d3 = new Digit(10.5f);
        System.out.println(d1.val+" "+d2.val+" "+d3.val);

        System.out.println(Digit.getNum(100)); // балуюсь
        System.out.println(Digit.getNum(50.43));


    }
}

class Digit{
    public double val;

    public <T extends Number> Digit(T val) {// в конструкторе объявляем что будет приходить дженерик потомок класса Numeric, поэтому в скобках конструктора указываем тип T
        this.val = val.doubleValue(); // приводим входящее значение независимо от того что пришло к типу Double
    }

    public static <T extends Number> T getNum(T num){
        return num;
    }
}