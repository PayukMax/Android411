package LessonT16.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap1 {
    public static void main(String[] args) {
        Map<Integer,String> linkHMap = new LinkedHashMap<>(16,0.75f,true);
        linkHMap.put(1,"obj1");
        linkHMap.put(15,"obj15");
        linkHMap.put(4,"obj4");
        linkHMap.put(38,"obj38");

        System.out.println(linkHMap);
        System.out.println(linkHMap.size());
        System.out.println(linkHMap.get(4));
        System.out.println(linkHMap.get(1));
        System.out.println(linkHMap);

    }
}
