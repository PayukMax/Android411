package LessonT13;

interface GeomInterface{
    int MIN_COORD = 0; // в интерфейсе автоматом устанавлияваются модификаторы достукпа public statis final
    int MAX_COORD = 1000; // таким образом константы могут присутствовать в интерфейсах

    static void showInterval (){
        System.out.println("["+MIN_COORD+":"+MAX_COORD+"]"); // статические методы с реализацией могут существовать в интерфесе, обращение к методам через обращение к интерфейсу
    }
    private void testMetod(){
        // в интерфейсах могут быть реализованы private методы
    }
}

interface MathShape {
    double getSquare();
}

abstract class Shape {
    private int width;
    private String color;

    public Shape(int width, String color) {
        this.width = width;
        this.color = color;
    }

    abstract void draw();
}

class Line extends Shape implements GeomInterface{
    private int x1, x2, y1, y2;

    public Line(int width, String color, int x1, int x2, int y1, int y2) {
        super(width, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean isCheck (int val){
        return val>=MIN_COORD && val<=MAX_COORD;
    }

    public void setCoord (int x1, int x2, int y1, int y2){
        if (isCheck(x1)&&isCheck(x2)&&isCheck(y1)&&isCheck(y2)) {this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;}
    }

    @Override
    void draw() {
        System.out.println("Рисуем линию...");
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                '}';
    }
}

class Rectangle extends Shape implements MathShape {
    private int width;
    private int height;

    public Rectangle(int width, String color, int width1, int height) {
        super(width, color);
        this.width = width1;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return width * height;
    }

    @Override
    void draw() {
        System.out.println("Рисуем прямоугольник...");
    }
}

class Triangle extends Shape implements MathShape{
    private int length;
    private int height;

    public Triangle(int width, String color, int length, int height) {
        super(width, color);
        this.length = length;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return 0.5 * length * height;
    }

    @Override
    void draw() {
        System.out.println("РИсуем треугольник...");
    }
}

class InterfaceGroup{
    interface Interface_1{
        void metod_1();
    }
    interface Interface_2{
        void metod_2();
    }
}

class RealisIntrface implements InterfaceGroup.Interface_1 {

    @Override
    public void metod_1() {

    }
}

//interface MathShape{
//    double getSqare();
//
//    default double getRad(){ // методы по умолчанию могут быть реализованы в интерфейсах и использоваться в классах имплементирующие этот интерфейс
//        return 0;
//    }
//}

abstract class Geom implements MathShape{
    int width,color;
    abstract void draw();
}

//class mLine extends Geom{// класс реализующий абстрактный который расширялся интерфейсом обязан реализовать и методы абстрактного класса так и методы расширяющего его интерфейса

//}
