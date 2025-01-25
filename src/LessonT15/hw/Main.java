package LessonT15.hw;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String str1 = "   ";
        String str2 = "Строка содержит текст!";
        Predicate<String> stringEmpty = str -> str.replaceAll("\\s","").length()==0? true: false;

        System.out.println("Строка 1: "+str1);
        System.out.println("Строка 1 пустая: "+stringEmpty.test(str1));
        System.out.println();
        System.out.println("Строка 2: "+str2);
        System.out.println("Строка 2 пустая: "+stringEmpty.test(str2));
    }
}
