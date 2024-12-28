package LessonT13.hw;

public class Pyramid extends Figure{
    private int h;
    private int a;

    public Pyramid(String type, int h, int a) {
        super(type);
        this.setH(h);
        this.setA(a);
    }

    public void setH(int h) {
        if(h>0) this.h = h;
    }

    public void setA(int a) {
        if(a>0) this.a = a;
    }

    @Override
    public double getVol() {
        return ((double)h*a*a)/3;
    }

    @Override
    public void showData() {
        System.out.printf("Фигура: %s | Оъем фигуры: %.2f%n",this.getType(),this.getVol());
    }
}
