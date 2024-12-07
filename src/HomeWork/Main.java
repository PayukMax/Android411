package HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Main {
    public static void main(String[] args) {
        try {
            String s = " +7 499 456-45-78,+74994564578, 7 (123) 4!6-78-90,  +7 ( 777 ) !126-31-67,    7 (499) 456 45 78, +7 (499) 456-45-78, 7(777247--57), 7 (777) 247    25-57, 7(960) 828-07-51";
            String tmp = s.replaceAll("\\s","").replaceAll("\\(","").replaceAll("\\)","").replaceAll("-","");
            System.out.println("Из перечня :" + s);

            String pattern = "\\+?7\\d{10}";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(tmp);

            while (matcher.find()) {
                System.out.println("Валидные номера -> "+matcher.group()+ " ;"); // и смотрим результат

            }
        } catch (PatternSyntaxException e) {
            System.out.println("Не правильное регулярное выражение... "+e.getMessage());
            System.out.println("Описание: "+e.getDescription());
            System.out.println("Позиция: "+e.getIndex());
            System.out.println("Неправильный шаблон: "+e.getPattern());
        }


    }
}