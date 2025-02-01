package LessonT16.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hashset9 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3,2,4,2,3,5,2,34,5,3};
        System.out.println(Arrays.toString(arr));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
                    }
        System.out.println(set);

        int[] unicArr = new int[set.size()];
        int i=0;
        for (int num:set){
            unicArr[i++]=num;
        }
        System.out.println("Массив без дубликатов "+Arrays.toString(unicArr));



    }
}
