package LessonT15.test;

interface Calc {
    int calculate(int x, int y);
}
public class Sample21 {
//    static int x = 10;
//    static int y = 20;

    public static void main(String[] args) {
        Calc op = (int a, int b) -> {
            if (b==0){return 0;} else {return a/b;}
        };
        System.out.println(op.calculate(20,10));
        System.out.println(op.calculate(20,0));


    }
}

