package LessonT11.test;

public class Rect2 extends Rect{
    private String r1;
    private String r2;
    private String r3;

    public Rect2(int w, int l, String r1, String r2, String r3) {
        super(w, l);
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Рамка: "+r1+" "+r2+" "+r3);

    }
}
