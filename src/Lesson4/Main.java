package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(rnd.nextInt(10));
        }
//        String text1 = "";
//        System.out.print("Введите число от 1 до 99 :");
//        int sum = input.nextInt();
//        if (sum >= 1 && sum <= 99) {
//            int x = sum % 10;
//            if (x >= 5 && x <= 9 || x == 0 || sum >= 11 && sum <= 14) text1 = " копеек";
//            else {
//                if (x == 1) text1 = " копейка";
//                else text1 = " копейки";
//            }
//            System.out.println(sum + text1);
//
//        } else {
//            System.out.println("Введено некорректное число...");
//        }
//
//        input.close();

//        int a=2, b=3;
//        System.out.println(b==0 ? "На 0 делить нельзя..." : (float) a/b);

//        int n;
//        System.out.print("\tВыберите цвет светофора:\n1(11)-красный, 2(22)-желтый, 3(33)-зеленый: ");
//        n = input.nextInt();
//        switch (n) {
//            case 1:
//            case 11:
//                System.out.println("Стоим");
//                break;
//            case 2:
//            case 22:
//                System.out.println("Приготовились");
//                break;
//            case 3:
//            case 33:
//                System.out.println("Идем");
//                break;
//            default:
//                System.out.println("Нет такого цвета");
//        }

//

//

//        System.out.print("Введите балл по 12ти бальной системе: ");
//        int num = input.nextInt();
//        System.out.print("Ваш балл по 5ти бальной системе ");
//        switch ((num >= 1 && num <= 3) ? 2 :
//                (num >= 4 && num <= 6) ? 3 :
//                (num >= 7 && num <= 9) ? 4 :
//                (num>=10&&num<=12)? 5 : 0) {
//            case 2 -> System.out.println(2);
//            case 3 -> System.out.println(3);
//            case 4 -> System.out.println(4);
//            case 5 -> System.out.println(5);
//            case 0 -> System.out.println("Такого значения нет...");
//        }        System.out.print("Введите балл по 12ти бальной системе: ");


//        int num = input.nextInt();
//        System.out.print("Ваш балл по 5ти бальной системе ");
//        switch ((num >= 1 && num <= 3) ? 2 :
//                (num >= 4 && num <= 6) ? 3 :
//                (num >= 7 && num <= 9) ? 4 :
//                (num>=10&&num<=12)? 5 : 0) {
//            case 2 -> System.out.println(2);
//            case 3 -> System.out.println(3);
//            case 4 -> System.out.println(4);
//            case 5 -> System.out.println(5);
//            case 0 -> System.out.println("Такого значения нет...");
//        }

//        int n, sum=0;
//        System.out.print("Введите число: ");
//        while (input.hasNextInt()){
//            System.out.print("Введите число :");
//            n=input.nextInt();
//            sum+=n;
//        }
//        System.out.println("Сумма введенных чисел "+sum);
//        input.close();

//        int start,finish, sum=0;
//        System.out.print("Введите начало диапазона: ");
//        start=input.nextInt();
//        System.out.print("Введите конец диапазона: ");
//        finish=input.nextInt();
//
//        while (start<=finish){
//            if (start%2!=0) {
//                System.out.println(start);
//                sum+=start;}
//            start++;
//        }
//        System.out.println("Сумма нечетных чисел "+sum);
//        input.close();

//        int i = 5;
//        do {
//            System.out.println(" i = "+i);
//            i++;
//        }while (i<5);


//        System.out.print("Введите количество часов: ");
//        int num = input.nextInt();
//        switch ((num >= 0 && num < 6) ? 1 :
//                (num >= 6 && num < 13) ? 2 :
//                (num >= 13 && num < 17) ? 3 :
//                (num >=17 && num < 0)? 4 : 0) {
//            case 1 -> System.out.print("Доброй ночи");
//            case 2 -> System.out.print("Доброе утро");
//            case 3 -> System.out.print("Добрый день");
//            case 4 -> System.out.print("Добрый вечер");
//            case 0 -> System.out.print("Не корректное время");
//        }
//        System.out.println("!");

//        int number, copy, reverse_number = 0;
//        System.out.print("Введите число :");
//        number= input.nextInt();
//        copy = number;
//        do {
//            reverse_number *= 10;
//            reverse_number += copy % 10;
//            copy /=10;
//        } while (copy>0);
//        System.out.println("Число "+number+(reverse_number==number ? " " : " не")+ "полиндром");



//        int i=0;
//        while (i<10){
//            if (i==3) {i++; continue;}  // демонстрация пропуска оставшего кода цикла
//            System.out.println(i);
//            if (i==5) break; // демонстрация прерывания цикла
//            i++;
//        }
//        System.out.println("Цикл завершен...");


//        int i=0;
//        while (true){
//            System.out.println(i);
//            if (i==5) break;   //  пример бесконечного цикла с условием вываливания из него
//            i++;
//        }

//        int n=0, proizv=0;
//
//        while (true){
//            System.out.print("Введите число: ");
//            n=input.nextInt();
//            if (n==0) break;
//            if (proizv==0) proizv++;
//            proizv*=n;
//        }
//        System.out.println("Произведение чисел : "+proizv);

//        int i=1;
//        while (i<10){
//            int j=1;
//            while (j<10){
//                System.out.print(i+" * "+j+" = "+i*j+"\t\t");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }

//        int i=0;
//        while (i<5){
//            int j=0;
//            while (j<5){
//                System.out.print(i==j ? "+" : " ");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }

//        int i;
//        for (i=0; i<5; i++ ){
//            System.out.println(i);
//        }
//        int count=0;
//        for (int i=0;i<6;i++){
//            System.out.print("->");
//            if(input.hasNextInt()){
//                count++;
//
//            }
//            input.nextLine();
//
//        }
//        System.out.println("Вы ввели чисел : "+count);


//        int num;
//        do {
//            System.out.print("Количество символов : ");
//            num=input.nextInt();
//            if (num>0) break; else System.out.println("Количество символов должно быть не отрицательным и не нулевым...");
//        } while(true);
//
//        System.out.print("Тип символа : ");
//        char symb=input.next().charAt(0);
//
//
//        System.out.println("0 - горизонтальная \n1 - вертикальная");
//        int typ;
//        do {
//            System.out.print("ориентация линии : ");
//            typ=input.nextInt();
//            if (typ==0 || typ==1) break; else System.out.println("Знчение ориентации может быть 0 или 1");
//        } while(true);
//
//
//        for (int i=0; i<num; i++){
//            System.out.print(symb);
//            if (typ==1) System.out.println(); else System.out.print(" ");
//        }

//        System.out.print("Введите цнлое число: ");
//        int n = input.nextInt();
//        for (int i=1; i<=n; i++){
//            if (n/%i==0) System.out.println(i+" ");
//        }

//        for (int i=10; i<100; i++){
//            if (i/10==i%10) System.out.print(i+" ");
//        }


//        int a=0;
//        for (int i=5; i>0; i--,a++){
//            System.out.println("I="+i+" A="+a);
//        }


//        System.out.print("Введите ширину прямоугольника: ");
//        int w = input.nextInt();
//        System.out.print("Введите высоту прямоугольника: ");
//        int h=input.nextInt();
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) if (i==0|| i==h-1|| j==0 || j==w-1) System.out.print("*"); else System.out.print(" ");
//            System.out.println();
//        }


        // ДЗ  - нарисовать елочку
//        Scanner input = new Scanner(System.in);
//        int pos=1;
//        do {
//            System.out.print("Введите ширину елочки (при вводе четного числа ширина будет +1): ");
//            pos = input.nextInt();
//            if (pos>0) break; else System.out.println("Количество символов должно быть не отрицательным и не нулевым...");
//        } while(true);
//
//        for(int i=0; i<=pos/2;i++) {
//            for (int j = 0; j <=pos ; j++) {
//                if ((j>=pos/2-i) && (j<=pos/2+i)) System.out.print("*"); else System.out.print(" ");
//            }
//            System.out.println();
//        }




        input.close();

    }
}
