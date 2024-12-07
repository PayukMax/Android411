package LessonT7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class NewMain {
    public static void main(String[] args) {
        try {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите дату в формате dd-mm-yyyy ");
        String s = input.nextLine();
        String pattern = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9][0-9]|20[0-9][0-9])";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group()); //

        }
    } catch (PatternSyntaxException e) {
        System.out.println("Не правильное регулярное выражение... "+e.getMessage());
        System.out.println("Описание: "+e.getDescription());
        System.out.println("Позиция: "+e.getIndex());
        System.out.println("Неправильный шаблон: "+e.getPattern());
    }

    }
}
