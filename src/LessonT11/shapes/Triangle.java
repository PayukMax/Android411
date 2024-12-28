package LessonT11.shapes;


public class Triangle extends Shape{
    private int side;

    public Triangle(int side, String color) {
        super(color);
        this.setSide(side);
    }

    public void setSide(int side) {
        if (side>0) this.side = side;
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3)*side*side)/4;
    }

    @Override
    public double getPerimetr() {
        return side*3;
    }

    @Override
    public void info() {
        System.out.println("=== Треугольник ===\nСторона: "+side+"\nЦвет: "+getColor()+"\nПлощадь: "+getArea()+"\nПериметр: "+getPerimetr());
        this.draw();

    }

    @Override
    public void draw() {
        int copy = (int) side;
        for (int i = 0; i <= side ; i++) {
            for (int j = i; j < side ; j++) {
                System.out.print("  ");

            }
            for (int j = 0; j < i; j++) {
                System.out.print(" *  ");

            }
            System.out.println();

        }

    }
}
