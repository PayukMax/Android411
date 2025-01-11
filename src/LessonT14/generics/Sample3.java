package LessonT14.generics;

public class Sample3 {
    public static void main(String[] args) {
        Point2<Integer> pt = new Point2<>(1,2);
        Point2<Double> pt2 = new Point2<>(1.0,2.3);
        System.out.println(pt.getMax());
        System.out.println(pt2.getMax());
    }
}

class Point2<T extends Number>{
    public T x,y;

    public Point2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    double getMax(){
        double xd = x.doubleValue();
        double yd = y.doubleValue();

        return (xd<yd)? yd:xd;
    }
}