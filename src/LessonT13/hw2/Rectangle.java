package LessonT13.hw2;

public class Rectangle implements Figure{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.resizeWidth(width);
        this.resizeHeight(height);
    }

    @Override
    public void resizeWidth(int width) {
        if (width>0) this.width=width;
    }

    @Override
    public void resizeHeight(int height) {
    if (height>0) this.height=height;
    }

    public void show(){
        System.out.println("Width: "+width+", Height: "+height);
    }


}
