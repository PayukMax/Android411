package LessonT10.box;

public class Rect {
    private double w;
    private double l;

    public Rect(double w, double l) {
        setW(w);
        setL(l);
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        if(l > 0) this.l = l;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        if (w > 0) this.w = w;
    }

    public double getArea(){
        return w*l;
    }
}
