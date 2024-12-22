package LessonT11.shape;
// демонстрация принципа полиморфизма. Мы можем создать коллекцию типа родительского класса, но ложим в нее
// экземпляры потомков, в потомкаж переопределены методы родительского класса в итоге получаем желаемое поведение.
// родительский класс является объединяющим для добавления в коллекцию дочерних...
// при таком случае мы имеем доступ к переопределенным родительским методам, но теряем доступ к уникальным дочерним методам
public class Main {
    public static void main(String[] args) {
        Shape s[] = new Shape[3];
        s[0] = new Circle();
        s[1] = new Triangle();
        s[2] = new Square();

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i].draw());
            System.out.println(s[i].erase());

        }

    }
}

class Shape{
    public String draw(){
        return "Рисуем фигуру...";
        }

        public String erase(){
        return "Стираем фигуру...";
        }
}

class Circle extends Shape{
    @Override
    public String draw() {
        return "Рисуем круг...";
    }

    @Override
    public String erase() {
        return "Стираем круг...";
    }
}

class Triangle extends Shape{
    @Override
    public String draw() {
        return "Рисуем треугольник...";
    }

    @Override
    public String erase() {
        return "Стираем треугольник...";
    }
}
class Square extends Shape{
    @Override
    public String draw() {
        return "Рисуем квадрат...";
    }

    @Override
    public String erase() {
        return "Стираем квадрат...";
    }
}