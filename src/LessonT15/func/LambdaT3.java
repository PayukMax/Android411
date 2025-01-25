package LessonT15.func;

import java.util.Scanner;
import java.util.function.Supplier;

public class LambdaT3 {
    public static void main(String[] args) {
//        String t="One";
//        Supplier<String> supl = () -> t.toUpperCase();
//        System.out.println(supl.get());
        Supplier<User> userFactory = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String nam = input.nextLine();
            return new User(nam);
        };

        User us1 = userFactory.get();
        User us2 = userFactory.get();
        System.out.println("Имя пользователя 1: "+us1.getName());
        System.out.println("Имя пользователя 2: "+us2.getName());



    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


