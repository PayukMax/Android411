package HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* Доброго дня. В сем коде не получилось добиться идельного вычленения валидного почтового адреса с помошью шаблона,
При наличии запрещенных символов почтовый адрес корректируется до близкого к валидному но не идеальному, ну
или я не до конца понял возможности регулярных выражений. В жизни здесь потребуется доработка иными методами.
Например при прохождении не корректного почтового имени login..3-67@i.ru через фильтр пройдет .3-67@i.ru и лидирующую
точку тоже потребуется убрать. При почтовом адресе 1lo----gin@ru.name.ru пройдет --gin@ru.name.ru.
Хотя в этих случаях возможен второй каскад и новый шаблон уже с иными правилами.

 */
public class Main {
    public static void main(String[] args) {
        try {
            String s = "123456@i.ru, 123_456@ru.name.ru, login@i.ru, логин-1@i.ru, login.3@i.ru, login.3-67@i.ru, 1login@ru.name.ru";
            String pattern = "[\\wА-яёЁ[^!~#$%=&,'\\s\\.\\-]]*[\\-\\.]?[\\wА-яёЁ[^!~#$%=&,'\\s\\-\\.]]*\\-?\\.?[\\wА-яёЁ[^!~#$%=&,'\\s\\-\\.]]+@\\w+\\.{1}\\w+\\.?\\w*";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(s);

            while (matcher.find()) {
                System.out.println(matcher.group()+ " ;"); // и смотрим результат

            }
        } catch (PatternSyntaxException e) {
            System.out.println("Не правильное регулярное выражение... "+e.getMessage());
            System.out.println("Описание: "+e.getDescription());
            System.out.println("Позиция: "+e.getIndex());
            System.out.println("Неправильный шаблон: "+e.getPattern());
        }


    }
}