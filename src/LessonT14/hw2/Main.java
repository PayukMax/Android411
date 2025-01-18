package LessonT14.hw2;

public class Main {
    public static void main(String[] args) {
        String str = "PHPJwДЧш";
        System.out.println("Исходная строка: " + str);
        try {
            checkString(str);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Строка проверена...");

    }

    static void checkString(String str) throws CharException {
        final String shablon = "AEIOUYaeiouyАЕЁИОУЫЭЮЯаеёиоуыэюя";
        boolean test = false;
        for (int i = 0; i < str.length(); i++) {
            if (shablon.contains(str.substring(i, i + 1))) { test = true; break;}
        }
        if (!test) throw new CharException("Строка не содержит гласные буквы...");
    }
}

class CharException extends Exception {
    public CharException(String message) {
        super(message);
    }

}
