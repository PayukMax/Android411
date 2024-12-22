package LessonT10.box;

public class Box extends Rect {
    private double h;

    public Box(double w, double l, double h) {
        super(w, l);
        setH(h);
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        if (h > 0) this.h = h;
    }

    @Override
    public double getArea() {
        return super.getArea() * h;
    }

    @Override
    public String toString() {
        return "Объект Box3D {ширина = " + this.getW() + ", высота = " + this.getH() + ", глубина = " + this.getL() + "}\nОбъем: " + this.getArea() + "\n";
    }
}
