package LessonT15.func;

import java.util.function.Predicate;

public class Lambda2 {
    public static void main(String[] args) {
        Predicate<Integer> isSimple = num -> {// в Predicate есть метод test принимающий что-то (в нашем случае num типа Integer) возвращающий boolean и требующий реализации, вот его мы в лямбда выражении и реализуем
            if (num < 2) return false;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) return false;
            }

            return true;
        };

        int m = 5;
        System.out.println("Простое число" + m + ": " + isSimple.test(m)); // а теперь используем
        m = 4;
        System.out.println("Простое число" + m + ": " + isSimple.test(m));
        m = 7;
        System.out.println("Простое число" + m + ": " + isSimple.test(m));

    }
}


