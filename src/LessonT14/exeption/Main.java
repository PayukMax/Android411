package LessonT14.exeption;

public class Main {
    public static void main(String[] args) throws NegativeWidthExceptions {
    Square sq = new Square(10);
    sq.setWidth(-2);
        System.out.println("Ширина квадрата: "+sq.getWidth());
        System.out.println("Площадь: "+sq.calcArea(sq.getWidth()));
    }
}

class NegativeWidthExceptions extends Exception{
    public NegativeWidthExceptions(String message) {
        super(message);
    }
}

class Square{
    private int width;

    public Square(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int calcArea(int width) throws NegativeWidthExceptions{
        if (width>=0)return width*width; else {
            throw new NegativeWidthExceptions("Ширина квадрата: "+width+" Значение не может быть отрицательным...");
        }
    }
}
