package LessonT16.collection;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        compareLists();
    }
    public static void  compareLists(){
        ArrayList<Double> arr1 = new ArrayList<>();
        LinkedList<Double> arr2 = new LinkedList<>();
        final int N = 1000000;
        final int M = 1000;

        System.out.println("Заполнение");
        System.out.println("Array");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arr1.add(Math.random());
//            arr2.add(Math.random());
        }
        System.out.println(System.currentTimeMillis()-startTime);

        System.out.println("Linked");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
//            arr1.add(Math.random());
            arr2.add(Math.random());
        }
        System.out.println(System.currentTimeMillis()-startTime);


        startTime = System.currentTimeMillis();
//        System.out.println(startTime);
        System.out.println("Array");
        for (int i = 0; i < M; i++) {
            arr1.get((int)(Math.random()*(N-1)));
            arr1.get((int)(Math.random()*(N-1)));
        }
        System.out.println(System.currentTimeMillis()-startTime);

        startTime = System.currentTimeMillis();
//        System.out.println(startTime);
        System.out.println("Linked");
        for (int i = 0; i < M; i++) {
            arr2.get((int)(Math.random()*(N-1)));
        }
        System.out.println(System.currentTimeMillis()-startTime);

    }
}
