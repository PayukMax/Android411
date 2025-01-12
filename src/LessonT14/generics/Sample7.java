package LessonT14.generics;

public class Sample7 {
    public static void main(String[] args) {
    Point2D<Integer> p1 = new Point2D<>(1,50,70);
    Point3D<Float> p2 = new Point3D<>(2f,10f,20f,30f);

        System.out.println(p1);
        System.out.println(p2);
    }
}

class PointProp<T>{
    T id;

    public PointProp(T id) {
        this.id = id;
    }
}

class Point2D<T2D> extends PointProp<T2D>{
    T2D x,y;

    public Point2D(T2D id, T2D x, T2D y) {
        super(id);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "id "+id+": "+x+", "+y;
    }
}

class Point3D<T3D> extends PointProp<T3D>{
    T3D x,y,z;

    public Point3D(T3D id, T3D x, T3D y, T3D z) {
        super(id);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "id "+id+": "+x+", "+y+", "+z;
    }
}