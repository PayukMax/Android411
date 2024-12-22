package LessonT11.test;

public class Rect1 extends Rect {
    private String fon;

    public Rect1(int w, int l, String fon) {
        super(w, l);
        this.fon = fon;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Фон: "+fon);
    }
}
