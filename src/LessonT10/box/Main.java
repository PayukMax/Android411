package LessonT10.box;

public class Main {
    public static void main(String[] args) {

        Box box1 = new Box(5,3,2);
        System.out.println(box1);

        box1.setW(10);
        box1.setH(5);
        box1.setL(7);
        System.out.println("Новые значения\nШирина: "+box1.getW()+"\nВысота: "+box1.getH()+"\nГлубина: "+box1.getL());

        System.out.println(box1);


    }
}
