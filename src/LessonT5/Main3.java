// Введение в работу с исключениями

package LessonT5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        try {  // попытаться выполнить код в фигурных скобках
//            System.out.print("Введите первое число: ");
//            int a = input.nextInt();
//            System.out.print("Введите второе число: ");
//            int b = input.nextInt();
//            System.out.println( a / b);
//        } catch (InputMismatchException e) { // если поймали такое исключение выполнить вторые фигурные скоб4ки
//            System.out.println("Вы ввели не целое число..." + e);
//        } catch (ArithmeticException e) { // искллючения можно отлавливать не одно а сколько необходимо
//            System.out.println("На ноль делить нельзя..."+ e);
//        } finally { // этот блок отработает в любом случае - были ли исключения или нет
//            System.out.println("Исполнение окончено...");
//        }
//        // исколчения можно делать не несколькими catch а одним
//        // catch (InputMismatchException | ArithmeticException e)
//        // но блок отрабатывать будет один в фигурных скобках, в e лежит само исключение


//        try {
//            int[] numbers = new int[3];
//            numbers[3] = 9;
//        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Не корректный индекс... "+e);
//        }

        // факториал числа - числа от 1 до этого числа перемноженные
        // 6! = 1*2*3*4*5*6

        int res = getFactorial(-5);
        System.out.println(res);


    }

    public static int getFactorial(int num) {
        int res = 1;
        try {
            if (num < 1) {
                throw new Exception("Число меньше 1 указывать нельзя..."); // выбрасываем исключения сами
            }

            for (int i = 1; i <= num; i++) {
                res *= i;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            res = num;
        }
        return res;
    }

}

