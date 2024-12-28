package LessonT11.shapes;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimetr();
    public abstract void info();
    public abstract void draw();

}
