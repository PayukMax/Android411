package LessonT13.hw;

public abstract class Figure {
    private String type;
    public abstract double getVol();
    public abstract void showData();

    public Figure(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}


