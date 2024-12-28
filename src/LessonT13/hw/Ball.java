package LessonT13.hw;

public class Ball extends Figure{
    private int rad;

    public Ball(String type, int rad) {
        super(type);
        this.setRad(rad);
    }

    public void setRad(int rad) {
        if (rad>0) this.rad = rad;
    }

    @Override
    public double getVol() {
        return Math.PI*Math.pow(this.rad,3)*(4/3.0);
    }

    @Override
    public void showData() {
        System.out.printf("Фигура: %s\t\t | Оъем фигуры: %.2f%n",this.getType(),this.getVol());
    }
}