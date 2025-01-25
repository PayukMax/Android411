package LessonT15.func;

import java.util.function.Function;

public class LambdaT2 {
    public static void main(String[] args) {
        Function<Integer,String> conv = x ->String.valueOf(x)+" долларов";

        System.out.println(conv.apply(5));

        Function<Double,Long> func = d -> Math.round(d);
        System.out.println(func.apply(5.7));


    }
}
