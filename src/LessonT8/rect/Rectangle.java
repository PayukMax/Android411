package LessonT8.rect;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        setLength(length);
        setWidth(width);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length>0) this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width>0) this.width = width;
    }

    public int getAres(){
        return length*width;
    }

    public int getPerim(){
        return 2*(length+width);
    }

    public double getGipotinuse(){
        return Math.sqrt(Math.pow(length,2)+Math.pow(width,2));
    }

    public void drowRect(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

}
