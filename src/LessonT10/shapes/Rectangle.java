package LessonT10.shapes;

public class Rectangle extends Figure {
private int width;
private int height;

    public Rectangle(int width, int height, String color) {
        super(color);
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width>0) this.width = width; else {
            throw new IllegalArgumentException("Требуется положительное число"); // в случае некорректных значений можем вывалить исключение
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height>0) this.height = height;
    }

    public int area(){
        return width*height;
    }
}
