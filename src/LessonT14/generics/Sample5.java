package LessonT14.generics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Sample5 {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(num);
//        Convert<Integer> rNum = new Convert<>(num);
        System.out.println(reverseList(num));


//        System.out.println(rNum);

        ArrayList<String> num1 = new ArrayList<>(Arrays.asList("Red","Green","Orange"));
        System.out.println(num1);
        System.out.println(reverseList(num1));
    }
    public static <T> ArrayList<T> reverseList(ArrayList<T> originalList){ // принимаем массив типа T.. обрабатываем и возвращаем тоде ArrayList того же типа T
        ArrayList<T> nevAr = new ArrayList<>(); // создаем массив который будем возвращать, тип T
        for (int i = originalList.size()-1; i >=0 ; i--) {
            nevAr.add(originalList.get(i));

        }
        return nevAr; // возвращаем чего наделали

    }
}

//class Convert<T>{
//    private ArrayList<T> array;
//
//    public Convert(T array) {
//        this.array = array;
//    }
//
//    public T getConvert(){
//        ArrayList<T> ar = new ArrayList<>();
//        for (T tmp:array) ar.add(0,tmp);
//        return ar;
//    }
//}

