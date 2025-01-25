package LessonT15.test;

interface Converter<F,T>{// используем 2 типа дженериков
    T convert(F from); // один принимаем как входное значение - второй как выход
}


public class Sample6 {
    public static void main(String[] args) {
//Converter<String, Integer> converter = (String from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf; // другая запись того же, избавились от промежуточной переменной from

Integer converted = converter.convert("123");
        System.out.println(converted+10);
    }
}
