package LessonT15.func;

import java.util.function.Predicate;

public class Lambda1 {
    public static void main(String[] args) {
//        Predicate<Integer> isPositive = x -> x>0;
//        System.out.println(isPositive.test(5));
//        System.out.println(isPositive.test(-7));

        Predicate<String> isPalindrom = str -> {String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
        };// создаем новый тип StringBuilder которому перелдаем строку, методом reverse разворачиваем ее и методом toString возвращаем в виде строки обратно
        String str1="радар";
        System.out.println(str1+" это палиндром: "+isPalindrom.test(str1));

        str1="asdgadfh";
        System.out.println(str1+" это палиндром: "+isPalindrom.test(str1));

    }
}
