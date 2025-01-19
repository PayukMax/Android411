package LessonT15.test;

interface Calc2<T> {
    T calc1(T x, T y);
}
public class Sample3 {
    public static void main(String[] args) {
        Calc2<Integer> op1 = (a,b) -> a+b;
        Calc2<String> op2 = (a,b) -> a+" "+b;

        System.out.println(op1.calc1(5,10));
        System.out.println(op2.calc1("asdasdasd","qweqweqw"));
    }
}
