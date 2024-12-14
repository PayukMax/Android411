package LessonT9;

public class Program {
    public static void main(String[] args) {
        Point p1= new Point(1,2);
        System.out.println(p1.getCount());
        Point p2= new Point(3,4);
        Point p3= new Point(2,5);
//        System.out.println(Point.count); // после установки private это перестает работать
//        Point.count()++; // посте установки private обращение к count не возможно
        System.out.println(Point.getCount());




    }
}

class Point {
    private static int count; // делаем свойство приватным, то есть закрытым для долступа из вне класса
    int x;
    int y;

    static { // статический инициализатор - установка первоначальных значений если его убрать то при создании каждого экземпляра класса значение count будет установлено в 10
        count=10;
    } // то есть static относится к КЛАССУ а не к ЭКЗЕМПЛЯРУ КЛАССА

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    public static int getCount() {
        return count;
    }
}