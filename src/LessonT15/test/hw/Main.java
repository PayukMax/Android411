package LessonT15.test.hw;

interface Words {
    String getMinWord(String str1, String str2);
}

public class Main {
    public static void main(String[] args) {
        String st1 = "Собака";
        String st2 = "   Кот    ";
        Words words = new Words() {
            @Override
            public String getMinWord(String str1, String str2) {
                return (str1.trim().length() > str2.trim().length() ? str2.trim() : str1.trim());
            }
        };
        System.out.println("Первое слово: " + st1 + "\nВторое слово: " + st2);
        System.out.println("Самое короткое слово: " + words.getMinWord(st1, st2));
        Words words1 = (str1, str2) -> (str1.trim().length() > str2.trim().length() ? str2.trim() : str1.trim());
        System.out.println("Второй вариант - через лямбда выражение:" + words1.getMinWord(st2, st1));

    }
}
