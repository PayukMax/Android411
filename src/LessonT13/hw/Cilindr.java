package LessonT13.hw;

public class Cilindr extends Figure{
    private int h;
    private int rad;

    public Cilindr(String type, int r, int h) {
        super(type);
        this.setRad(r);
        this.setH(h);
    }

    public void setRad(int r){
        if (r>0) this.rad=r;
    }

    public void setH(int h) {
        if (h>0) this.h = h;
    }

    @Override
    public double getVol() {
        return Math.PI*Math.pow(this.rad,2)*this.h;
    }

    @Override
    public void showData() {
        System.out.printf("Фигура: %s\t | Оъем фигуры: %.2f%n",this.getType(),this.getVol());
    }
}
