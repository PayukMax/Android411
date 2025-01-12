package LessonT14.generics;

import java.util.ArrayList;

public class Sample3 {
    public static void main(String[] args) {
//        ArrayList<Point2> ptl = new ArrayList<>();// это уже после урока извращаюсь
//        ptl.add(new Point2<Integer>(100,200));// это уже после урока извращаюсь
//        ptl.add(new Point2<Double>(1.99,2.31));// это уже после урока извращаюсь

        Point2<Integer> pt = new Point2<>(1,2);
        Point2<Double> pt2 = new Point2<>(1.0,2.0);
        System.out.println(pt.equalsPoint(pt2));// казалось бы - сравниваем 2 разных типа Integer и Double однако в функции реализовали приведение

//        for (Point2 t : ptl) System.out.println(t.toString()+" - "+t.getMax());// это уже после урока извращаюсь
//        System.out.println(ptl.get(1));// это уже после урока извращаюсь

        System.out.println(pt.getMax());
        System.out.println(pt2.getMax());
    }
}

class Point2<T extends Number>{
    private T x,y;

    public Point2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    double getMax(){
        double xd = x.doubleValue();
        double yd = y.doubleValue();

        return (xd<yd)? yd:xd;
    }

    boolean equalsPoint(Point2<?> pt){// вопрос в типе данных означает что не обязательно прилетит тот же тип что и сравниваемый, мы приведение производим уже внутри метода
        return x.doubleValue() == pt.x.doubleValue() && y.doubleValue()==pt.y.doubleValue();
    }

}