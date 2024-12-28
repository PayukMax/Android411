package LessonT11.shapes;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height, String color) {
        super(color);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setWidth(int width) {
       if (width>0)  this.width = width;
    }

    public void setHeight(int height) {
        if (height>0) this.height = height;
    }

    @Override
    public double getArea() {
        return this.height*this.width;
    }

    @Override
    public double getPerimetr() {
        return 2*(this.width+this.height);
    }

    @Override
    public void info() {
        System.out.println("=== Прямоугольник ===\nШирина: "+width+"\nВысота: "+height+"\nЦвет: "+getColor()+"\nПлощадь: "+getArea()+"\nПериметр: "+getPerimetr());
        this.draw();

    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
        System.out.println();
    }

}
