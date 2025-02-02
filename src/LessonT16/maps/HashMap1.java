package LessonT16.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(334455,"Михаил Борисов");
        map1.put(445566,"Борис Михайлов");
        map1.put(556677,"Роман Обрамович");
        map1.put(667788,"Анна Полякова");
        map1.put(667781,"Анна Полякова");
        map1.put(334455,"Ольга");
        map1.put(22,null);
        map1.put(null,"Вася");

        System.out.println(map1.size());
        System.out.println(map1.get(null));
                System.out.println(map1);
    }
}
