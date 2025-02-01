package LessonT16.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSet8 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(21,54,24,43,31,null));
        System.out.println(set);
        Integer max=null;
        for (Integer t:set) {
            if (max == null) max = t;
            else if (max < t) max = t;
        }
        System.out.println("Максимальное "+max);

//        System.out.println("Минимальное - "+ Collections.min(set));
    }
}
