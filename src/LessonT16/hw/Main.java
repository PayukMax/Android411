package LessonT16.hw;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] mcol = {"red","orange","aqua","pink","gray","blue","white","black","yellow","brown"};
        Map<String,Color> map = new HashMap<>();
        for (int i = 0; i < mcol.length; i++) {
            map.put(mcol[i],new Color(mcol[i].toUpperCase()));
        }

        for (int i = 0; i < mcol.length; i++) {
            System.out.println(i+1+") "+mcol[i]+": "+map.get(mcol[i]));

        }



    }
}
