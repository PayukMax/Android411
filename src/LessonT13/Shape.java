package LessonT13;

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

class Line extends Shape {
    private int x1, x2, y1, y2;

    public Line(int width, String color, int x1, int x2, int y1, int y2) {
        super(width, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    void draw() {
        System.out.println("Рисуем линию...");
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
