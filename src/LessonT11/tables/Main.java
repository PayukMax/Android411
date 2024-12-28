package LessonT11.tables;

public class Main {
    public static void main(String[] args) {
        SqTable t1 = new SqTable(20, 10);
        SqTable t2 = new SqTable(20);
        RoundTable t3 = new RoundTable(20);
        t1.calcArea();
        t2.calcArea();
        t3.calcArea();
    }
}
