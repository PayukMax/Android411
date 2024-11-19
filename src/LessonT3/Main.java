package LessonT3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Вводим размерность массива и заполняем его. Если введено меньше 5 то заполняем выбранные  остальное до 5 добиваем 0ми
//        System.out.print("Введите количество элементов массива : ");
//        int size=input.nextInt();
//        int[] array;
//        if (size<=5){
//            array=new int[5];} else {
//            array=new int[size];
//        }
//
//        for (int i = 0; i < size ; i++) {
//            System.out.print("->");
//            array[i]=input.nextInt();
//        }
//        System.out.println();
//
//        for (int i = 0; i < array.length ; i++) {
//            System.out.print("array["+i+"]-> "+array[i]+"; ");
//            }

//        int [] array = new int[10];
//                for (int i=0 ; i<array.length; i++){
//                    System.out.print("-> ");
//                    array[i]=input.nextInt();
//                }
//
//        for (int i = array.length-1; i >= 0 ; i--) {
//            System.out.print(array[i]+" ");
//        }

//        int[] array={1,2,3,7,5,3,2};
//        System.out.print(Arrays.toString(array)); // вывод содержимого массива из библиотеки
//        input.close();
//
//        System.out.print("Вводим размер массива: ");
//        int size=input.nextInt();
//        int[] array = new int[size];
//        int sum=0;
//
//        for (int i = 0; i < array.length ; i++) {
//            System.out.print("->");
//            array[i]=input.nextInt();
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]<0) sum+=array[i];
//            }
//        System.out.println(Arrays.toString(array));
//        System.out.println("Сумма отрицательных элементов: "+sum);

//        System.out.print("Вводим размер массива: ");
//        int size=input.nextInt();
//        int[] array = new int[size];
//        int min;
//
//        for (int i = 0; i < array.length ; i++) {
//            System.out.print("->");
//            array[i]=input.nextInt();
//        }
//
//        System.out.println(Arrays.toString(array));
//        for (int i = 1; i < array.length; i++) {
//            if (array[i]>array[i-1]) System.out.print(array[i])+" ";
//        }

//        int[] a1 = {1,2,3,4};
//        int[] a2 = new int [a1.length];
//        for (int i = 0; i < a1.length; i++) {
//            a2[a1.length-1-i]=a1[i];
//
//        }
//        System.out.println(Arrays.toString(a1));
//        System.out.println(Arrays.toString(a2));

//        int[] array = new int[20];
//        for (int i = 0; i < array.length; i++) {
//            array[i]=(int) (Math.random()*40+10);
//             }
//        System.out.println(Arrays.toString(array));
//        for (int i = 0; i < array.length ; i++) {
//
//        }

//        int[] numbers = {10,20,30,40,50};
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.print(numbers[i]+" ");
//        }
//        System.out.println();
//
//        for (int x:numbers){
//            System.out.print(x+" "); // в переменную Х поочередно попадают все значения элементов массива
//        }

//        String[] names = {"Олег","Иван","Дима","Юля"};
//        for(String n:names){
//            System.out.print(n+"\t");
//        }

//        int[] array = new int[12];
//        for (int i = 0; i < array.length; i++) {
//            array[i]=(int) (Math.random()*40+10);
//             }
//        for (int x:array){
//            System.out.print(x+" ");
//        }


//        System.out.print("Введите начало диапазона: ");
//        int pos1=input.nextInt();
//        System.out.print("Введите конец диапазона: ");
//        int pos2=input.nextInt();
//        if (pos2<pos1) {// приводим начало и конец диапазона к удобному виду
//            pos2=pos2+pos1;
//            pos1=pos2-pos1;
//            pos2=pos2-pos1;
//        }
//        int[] mass =new int [pos2-pos1+1];
//        for (int i = 0; i < mass.length; i++) {
//            mass[i]=pos1+i;
//            System.out.print(mass[i]+" ");
//        }

//        String[] cities = {"Брянск","Иркутск","Владивосток","Армавир"};
//        String[] cities2= new String[cities.length+1];
//        for (int i = 0; i < cities.length; i++) {
//            cities2[i]=cities[i];
//            cities2[cities.length]="Красноярск";
//
//        }
//        System.out.println(Arrays.toString(cities2));

//        ArrayList<String> cities = new ArrayList<>();
//        cities.add("Брянск");
//        cities.add("Усть-Каменогорск");
//        cities.add("Владивосток");
//        cities.add("Новосибирск");
//        cities.add(1,"Красноярск"); // вставка нового по индексу с раздвижкой вправо
//        System.out.println(cities);
//        System.out.println(cities.get(2)); // получаем значение по индексу
//        cities.set(1,"Караганда"); // изменение значения по индексу
//
//        cities.remove(1); // удаляем из коллекции элемент по индексу
//        cities.remove("Владиволсток"); // удаляем из коллекции элемент по значению
//
//        for(String nam:cities){
//            System.out.print(nam+"\t");
//        }
//        System.out.println();
//        System.out.println(cities.size());
//        System.out.println(cities.indexOf("Новосибирск")); // выводим индекс при наличии в коллекции, если нет то -1
//        System.out.println(cities.contains("Караганд1а")); // выдает true/false по наличию в коллекции

//        ArrayList<Integer> array = new ArrayList<>();
//        int num=0;
//        while(true){
//            System.out.print("Введите положительные значения :");
//            num=input.nextInt();
//            if (num>0) array.add(num); else break;
//        }
//        System.out.println(array);
//        System.out.print("Ведите индекс :");
//        num=input.nextInt();
//        array.remove(num);
//        System.out.println(array);


//        ArrayList<Integer> array = new ArrayList<>();
//        int num=0;
//        System.out.print("Введите положительные значения :");
//        while((num=input.nextInt())>0){   // по сути тот же смысл но бошлее красивая запись
//            array.add(num);
//        }
//        System.out.println(array);
//        System.out.print("Ведите индекс :");
//        num=input.nextInt();
//        array.remove(num);
//        System.out.println(array);

        ArrayList<Integer> mas = new ArrayList<>();
        for (int i=0; i<10; i++) {
            mas.add((int) (Math.random()*100));
            }
//
//        int max=mas.get(0);
//
//        for(int m:mas){
//            System.out.print(m+"\t");
//        }
//        int pos=0;
//        for (int i = 0; i < 10; i++) {
//            if (mas.get(i)>max) {
//                max=mas.get(i);
//                pos=i;
//            }
//        }
//        System.out.println("\nMax= "+max);
//        mas.remove(pos);
//        mas.add(0,max);
//        System.out.println(mas);


//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
//        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11,22,33));
//        ArrayList<Integer> c = new ArrayList<>();
//
//        for (int i = 0; i < a.size(); i++) {
//            c.add(a.get(i));
//            c.add(b.get(i));
//
//        }
//        System.out.println(c);

//        int [] [] num = {{0,1,2,3},{4,5,6,7},{8,9,10,11}};
//        for (int i = 0; i < num.length; i++) {
//            for (int j = 0; j < num[i].length; j++) {
//                System.out.print(num[i][j]+"\t");
//
//            }
//            System.out.println();
//        }


//        // Домашнее из занятия 9 - вывести первый массив и квадрат каждого значения из превого в каячестве второго массива
//        int [] [] num = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        for (int i = 0; i < num.length; i++) {
//            for (int j = 0; j < num[i].length; j++) {
//                System.out.print(num[i][j]+"\t\t");
//
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < num.length; i++) {
//            for (int j = 0; j < num[i].length; j++) {
//                System.out.print((num[i][j]*num[i][j])+"\t\t");
//
//            }
//            System.out.println();
//        }

//        int n=5;
//        char[][] graph = new char[n][n];
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//               graph[i][j]='*';
//            }
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                System.out.print(graph[i][j]+"\t");
//            }
//            System.out.println();
//        }


//        int[][] mas = new int[3][5];
//        int pos = 0;
//        int sum = 0;
//        int minsum=Integer.MAX_VALUE;
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//               mas[i][j]=(int) (Math.random()*100); // заполняем случайными от -20 до 10
//                System.out.print(mas[i][j]+"\t\t");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                  sum+=mas[i][j];
//            }
//            if (minsum>sum) {
//                minsum=sum;
//                pos=i;
//            }
//            System.out.println("Сумма элементов "+i+" строки: "+sum );
//            sum=0;
//        }
//        System.out.println("Строка с минимальной суммой элементов "+minsum+" имеет номер :"+pos);

        // Зубчатый массив
//        int[][] mas = new int[3][];
//        mas[0] = new int[2];
//        mas[1] = new int[3];
//        mas[2] = new int[4];
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                System.out.print("->");
//                mas[i][j]=input.nextInt();
//
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                System.out.print(mas[i][j]+"\t\t");
//
//            }
//            System.out.println();
//        }

//        int[][] mas = new int[3][]; // варианты заполнения
//        mas[0] = new int[]{1,2};
//        mas[1] = new int[]{3,4,5};
//        mas[2] = new int[]{6,7,8,9,10};

//        int[][] mas = {{1,2},{3,4,5},{6,7,8,9,10}}; // еще вариант заполнения

//        int pos=0;
//        int[][] mas = new int[5][];
//        for (int i = 0; i < 5; i++) {
//            mas[i] = new int [i+1];
//            for (int j = 0; j <= i; j++) {
//                mas[i][j]=(int)(Math.random()*15);
//            }
//
//        }
//
//        for (int i = 0; i <mas.length ; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                System.out.print(mas[i][j]+"\t\t");
//
//            }
//            System.out.println();
//        }

//        int[][] mas=new int[5][];
//        for (int i = 0; i < 5; i++) {
//            mas[i]=new int [mas.length-i];
//        }
//        int count=10;
//
//                // строим треугольник Паскаля
//        int n=5;
//        int tp[][]= new int[n][];
//        for (int i = 0; i <tp.length; i++) {
//            tp[i]=new int[i+1];
//            tp[i][0]=1;
//            tp[i][i]=1;
//            for (int j = 1; j < i; j++) {
//                tp[i][j]= tp[i-1][j-1]+tp[i-1][j];
//            }
//
//        }
//
//        for (int i = 0; i < tp.length; i++) {
//            for (int j = 0; j < tp.length-i; j++) {
//                System.out.print("  ");
//            }
//            for (int j = 0; j < tp[i].length; j++) {
//                System.out.print(tp[i][j]+"   ");
//
//            }
//            System.out.println();
//
//        }


        input.close();
    }
}
