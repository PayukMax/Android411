package LessonT14.generics.hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите количество элементов числового массива");
        int num1 = getSizeArray();
        Integer[] ar1 = new Integer[num1];
        for (int i = 0; i < num1; i++) ar1[i] = getNum();


        System.out.print("Введите количество элементов массива строк");
        int num2 = getSizeArray();
        String[] ar2 = new String[num2];
        for (int i = 0; i < num2; i++) ar2[i] = getStr();

        System.out.print("Массив: ");
        Printing.printArray(ar1);

        System.out.print("Массив: ");
        Printing.printArray(ar2);


    }


    public static Integer getSizeArray() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.print(": ");
        while (true) {
            try {
                num = input.nextInt();
                if (num > 0) break;
                else System.out.print("Необходимо положительное число. Попробуйде еще раз: ");
            } catch (InputMismatchException e) {
                System.out.print("Необходмо ввести целое положительное число. Введите снова : ");
                input.nextLine();
            }

        }
        return num;
    }

    public static Integer getNum() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.print("-> ");
        while (true) {
            try {
                num = input.nextInt();
                if (num > 0) break;
                else System.out.print("Необходимо положительное число. Попробуйде еще раз: ");
            } catch (InputMismatchException e) {
                System.out.print("Необходмо ввести целое положительное число. Введите снова : ");
                input.nextLine();
            }
        }
        return num;
    }

    public static String getStr() {
        Scanner input = new Scanner(System.in);
        String str;
        System.out.print("-> ");
        str = input.nextLine();
        return str;
    }
}



class Printing{

    public static <T> void printArray(T[] mass){
        for (int i = 0; i < mass.length; i++) System.out.print(mass[i]+" ");
        System.out.println();
    }

}
