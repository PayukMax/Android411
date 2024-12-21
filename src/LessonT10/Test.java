package LessonT10;

public class Test {
    public static void main(String[] args) {
        Line l1 = new Line();
//    l1.color = "красный";
//    l1.width = 5;
        l1.x1 = l1.y1 = 0;
        l1.x2 = l1.y2 = 10;
        l1.show();
        l1.showId();

//    l1.show();
    }
}

class Properties {
    int width;
    String color;
    protected int id = 1;

    public Properties() {
        System.out.println("Конструктор Properties...");
    }

    public Properties(int width, String color) {
        this.width = width;
        this.color = color;
        System.out.println("Конструктор Properties ()...");
    }

    void show() {
        System.out.println("Ширина - " + width + " px, Цвет - " + color);
    }
}

class Line extends Properties {
    double x1, y1;
    double x2, y2;
    int id = 2;

    public Line() {
        super(3, "желтенький");
        System.out.println("Конструктор Line...");
    }
//    public Line() {
//        System.out.println("Конструктор Line...");
//    }

    @Override
    void show() {
        System.out.println("Координаты линии = х1:" + x1 + " x2:" + x2 + " y1:" + y1 + " y2:" + y2);
        super.show();
    }

    void showId() {
        System.out.println("Id :" + id + " super.id: " + super.id);
    }
}


class Triangle extends Properties {
    double x1, y1;
    double x2, y2;
    double x3, y3;

}
