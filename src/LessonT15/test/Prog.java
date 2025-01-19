package LessonT15.test;

interface WordCounter{
    int calc (String str);
}

public class Prog {
    public static void main(String[] args) {
        String text1="       Лямбда      выражения      ";
        String text2 = "фывыфы фыва укцук вапвапр вапвапр";
        System.out.println("Исходная строка: "+text1);
        WordCounter ob = (s) -> s.trim().split("\\s+").length; // trim - убирает пробелы слева и справа в строке, split делит строку в массив с разделителем - регулярным выражением, а там пробелы в количестве от 1 до более.а потом смотрим размер получившегося массива - это к-во слов
        System.out.println(ob.calc(text1));

        System.out.println("исходная строка: "+text2);
        System.out.println(ob.calc(text2));

    }
}
