package LessonT7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // regular expression

        String s = "Час в 24-часовом формате от 00 до 23. 2021-06-15T21:45. Минуты, в диапазоне от 00 до 59. 2021-06-15T01:09.";
//        String s = "Я ищу совпадения 21:22в 2024 году. И я их найду в 2 счёта.";
//        String pattern = "[А-ЯЁё]";
//        String pattern = "[А-ЯЁё\\[\\]]"; // экранирование [] с помошью \\
//        String pattern = "[0-9][0-9]"; // ищем 2 стоящие рядом цыфры от 0 до 9
//        String pattern = "[^0-9]"; // ищем все что не цифра от 0 до 9
        String pattern = "[012][0-9][:][0-5][0-9]"; // ищем все что не цифра от 0 до 9
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(s);
//        System.out.println(matcher.find());
        while(matcher.find()){
//            System.out.println("Шаблон совпадения найден с "+matcher.start()+ " по "+(matcher.end()-1));
//            System.out.println(s.substring(matcher.start(), matcher.end()));
            System.out.print(matcher.group()+ " ");

        }
    }
}
