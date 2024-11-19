package LessonT5;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);




//        System.out.print("На каком этаже ");
//        int n1 = input.nextInt();
//        elevator(n1);
//    }
//
//    public static void elevator(int n) {
//        if (n == 0) {
//            System.out.println("Вы в подвале...");
//            return;
//        }
//        System.out.println("-> "+n);
//        elevator(n-1);
//        System.out.print(n+" ");
//


//        int[] mas={1,3,5,7,9};
//        System.out.println(sumList(0, mas));

        System.out.println(toStr(254,16));




    }

//    public static int sumList(int[] arr){   // вариант без рекурсии
//        int sum =0;
//        for (int i:arr) sum+=i;
//        return sum;
//    }

    public static String toStr(int n, int base){
        String[] convert = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        if (n<base)
            return convert[n];
        else
            return toStr(n / base, base)+convert[n % base];

    }


public static int sumList(int i, int[] arr){ // вариант с рекурсией
        if (i==arr.length-1) return arr[i];
        return arr[i]+sumList(i+1,arr);
}

}

