package LessonT4;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        float num = 5.5f;
//        System.out.println(Math.round(num)); // округление по мат правилам до целого!!!
//        System.out.println(Math.floor(num)); // округление вниз
//        System.out.println(Math.ceil(num)); // округление вверх
//        System.out.println(Math.sqrt(64));// квадратный корень
//        System.out.println(Math.pow(6,4)); // возволдим в степень
////        System.out.println(Math.PI); // в библиотеке и константы
//        System.out.print("катет 1:");
//        int kat1 = input.nextInt();
//        System.out.print("катет 2:");
//        int kat2 = input.nextInt();
//
//        System.out.printf("Гипотенуза : %.2f",Math.sqrt(Math.pow(kat1,2)+Math.pow(kat2,2)));

//        getSum(2,5);
//
//        hallo("Irina");
//        hallo("Igor");

//        symbolDraw(9,'+','-');
//        symbolDraw(7,'X','0');

//        System.out.print("a = ");
//        int a=input.nextInt();
//        System.out.print("b = ");
//        int b=input.nextInt();


//        for (int i = 1; i <1 ; i++) {
//            System.out.println(i+" в кубе = "+cub(i));
//        }

//        for (int i = 1; i <=10 ; i++) {
//            if (i<6 )draw(i); else draw(10-i);
//            System.out.println();
//        }

//        sum(1,2,3);
//        sum(1,2,3,4,5);
//        sum();

//        sumStr("Сумма двух чисел ",20,10);
//        sumStr("Сумма трех чисел ",20,10,3);
//        sumStr("Сумма ");

//        sear13(2,7,0,3,1,5,-13);
//        sear13(2,7,0,3,1,5,-13,13);
//        sear13(26);
//        sear13(99,99,100,34,-39);
//        sear13(99,39,99,100,34);

//        System.out.println(ch(1,2,3,4,5,6,7,8,9));
//        System.out.println(ch(3,6,1,9,5));


        int[] num1 = {3,8,9,4,1,2,5};
        int[] num2 = {1,2,5};

        System.out.println(max(num1));
        System.out.println(max(num2));




    }

    public static int max (int [] mas){
        int mx = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mx<mas[i]) mx=mas[i];
        }
        return mx;
    }


    public static ArrayList ch(int...num){
        ArrayList <Integer> mas = new ArrayList<>();
        float srAr=0;
        for(int x:num) srAr+=x;
        srAr=srAr/(num.length);
        System.out.println("Среднее арийметическое: "+srAr);
        for(int x:num) if (x<srAr) mas.add(x);

            return mas;
    }

    public static void sumStr(String mes, int ...num){
        int res=0;
        for(int i=0; i<num.length; i++)
            res+=num[i];

        System.out.print(mes);
        System.out.println(res);

    }

    public static void sear13(int ...num ){
        int max=0;
        for(int n:num){
            if(n%13 == 0 && n > 0 ) {if (max<n) max=n;}
        }
        System.out.println(max>0? max: "Число не найдеено..");
    }

    public static void sum(int ...num ){
        int res=0;
        for(int n:num)
            res+=n;
        System.out.println(res);
    }

        public static void draw(int a) {
            for (int i = 1; i <= a; i++) {
                System.out.print(i + " ");
            }
        }
    public static int cub(int a) {
        return a*a*a;
        }



            public static void swapFunc(int a, int b){
        System.out.println("До замены:\n а = "+a+"\nb= "+b);
        int c;
        c=a;
        a=b;
        b=c;
        System.out.println("После замены:\n а = "+a+"\nb= "+b);
    }

    public static void symbolDraw(int count, char a, char b){
        for (int i = 0; i < count; i++) {
            if (i%2==0) System.out.print(a); else System.out.print(b);
        }
        System.out.println();
    }

    public static void hallo(String nam){
        System.out.println("Hallo "+nam+"!");
    }
    public static void getSum(int a, int b){
        System.out.println("Сумма чисел "+(a+b));
    }
}
