package LessonT15.func;

import java.util.function.Consumer;

public class Lambda4 {
    public static void main(String[] args) {
        Consumer<Integer> printer = x -> System.out.println(x+" рублей");
        printer.accept(700);

        Consumer<String> pr2 = str -> System.out.println(str.toUpperCase());
        pr2.accept("Hello");
    }
}
