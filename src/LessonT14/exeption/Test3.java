package LessonT14.exeption;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int a=0,b=0;
        try {
            a = getNum("Введите первое число");
            b = getNum("Введите второе число");
        }catch (NumberFormatException e){
            System.out.println("Значения не корректны...");
        }
        System.out.println("Результат: "+(a+b));
    }

    public static int getNum(String message) throws NumberFormatException{
        Scanner input = new Scanner(System.in);
        System.out.print(message+": ");
        String s = input.nextLine();
        return Integer.parseInt(s);
    }
}
