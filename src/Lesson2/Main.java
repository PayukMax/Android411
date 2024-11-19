package Lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.print("Введите пятизначное число :");
//        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//        int n5=num%10;
//        int n4=(num/10)%10;
//        int n3=(num/100)%10;
//        int n2=(num/1000)%10;
//        int n1= (num/10000)%10;
//        System.out.printf("Произведение цифр числа %d: %d %n",num,n1*n2*n3*n4*n5);
//        System.out.printf("Среднее арифметическое числа %d: %.1f %n",num,(float)(n1+n2+n3+n4+n5)/5);
//        input.close();

        Scanner input = new Scanner(System.in);
        System.out.print("Введите число от 1 до 99 :");
        int sum = input.nextInt();
        if (sum>=1 && sum<=99){
            int x=sum%10;
            String text1="";
            if (x>=5 && x<=9 || x==0 || sum>=11 && sum<=14) text1=" копеек"; else {
                if (x==1) text1=" копейка"; else text1=" копейки";
            }
            System.out.println(sum + text1);

        } else {System.out.println("Введено некорректное число...");}

//        Scanner input = new Scanner(System.in);
//        System.out.print("Введите день недели (от 1 до 7) :");
//        int day = input.nextInt();
//        if (day>=1 && day<=7){
//            if (day==1) System.out.println("Рабочий день : "+day+" - понедельник");
//            if (day==2) System.out.println("Рабочий день : "+day+" - вторник");
//            if (day==3) System.out.println("Рабочий день : "+day+" - среда");
//            if (day==4) System.out.println("Рабочий день : "+day+" - четверг");
//            if (day==5) System.out.println("Рабочий день : "+day+" - пятница");
//            if (day==6) System.out.println("Выходной день : "+day+" - суббота");
//            if (day==7) System.out.println("Выходной день : "+day+" - воскресенье");
//
//        } else {
//            System.out.println("Не существующий день недели...");
//        }
//
//        System.out.print("Введите вторую сторону :");
//        int side2 = input.nextInt();
//        System.out.print("Введите третью сторону :");
//        int side3 = input.nextInt();
//
//        if (side1==side2 && side1==side3 && side2==side3){
//            System.out.println("Треугольник расновторонний...");
//        } else {
//            if (side1==side2 || side1==side3 || side2==side3) {
//                System.out.println("Треугольник равнобедренный...");
//            } else {System.out.println("Треугольник разносторонний...");}
//        }




    }
}
