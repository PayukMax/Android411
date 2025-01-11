package LessonT14.generics;

public class Sample1 {
    public static void main(String[] args) {
        Point<Integer, String> pt = new Point<Integer,String>(1,2,"point_1");
//        pt.x = 10;
//        pt.y = 20;

        Point<Double,Integer> pt2 = new Point<>(10.5,20.3,10);
//        pt2.x=15.7;
//        pt2.y = 10.5;

        System.out.println(pt.getX()+" "+pt.getY()+ " "+pt.getId());
        System.out.println(pt2.getX()+" "+pt2.getY()+ " "+pt2.getId());
    }
}

class Point<T,V>{
    private T x,y;
    private V id;

    public Point(T x, T y, V id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public V getId() {
        return id;
    }
}