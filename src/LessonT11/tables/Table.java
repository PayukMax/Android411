package LessonT11.tables;

public abstract class Table {
    private int width;
    private int height;
    private double radius;

    public Table(int width) {
        this.width = this.height = width;
    }

    public Table(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public Table(double radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public abstract void calcArea();
}
