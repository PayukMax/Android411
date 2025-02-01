package LessonT16.collection;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class Hw2 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println("Введите 5 целых чисел: ");
        for (int i = 0; i < 5; i++) treeSet.add(getsNum());
        System.out.println("Наименьший элемент в TreeSet: "+treeSet.first());
    }

    public static Integer getsNum() {
        Integer num ;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("-> ");
            try {
                num = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число!!!");
                input.nextLine();
            }
        }
        return num;
    }
}
