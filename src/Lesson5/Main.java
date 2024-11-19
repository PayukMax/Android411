package Lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] mas = {-2, 3, 8, -11, -4, 6};
        System.out.println("Вычислить количество отрицательных чисел в массиве :");
        System.out.println(Arrays.toString(mas));
        System.out.println("n = "+getMinus(mas,0));
    }

    public static int getMinus(int[] mass, int index) {
        if (index >= mass.length-1)
            if (mass[index]<0 ) return 1; else return 0;
        else {
            return (mass[index]<0? 1:0) + getMinus(mass, index + 1);
        }

    }

}