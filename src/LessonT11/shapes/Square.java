package LessonT11.shapes;

public class Square extends Shape {
    private int side;


    public Square(int side, String color) {
        super(color);
        this.setSide(side);
    }

    public void setSide(int side) {
        if (side>0) this.side = side;
    }

    @Override
    public double getArea() {
        return this.side*this.side;
    }

    @Override
    public double getPerimetr() {
        return this.side*4;
    }

    @Override
    public void info() {
        System.out.println("=== Квадрат ===\nСторона: "+side+"\nЦвет: "+getColor()+"\nПлощадь: "+getArea()+"\nПериметр: "+getPerimetr());
        this.draw();
    }

    @Override
    public void draw() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
        System.out.println();
    }
}
