package LessonT16.maps;

import java.util.HashMap;

public class hw {
    public static void main(String[] args) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Integer,Character> map2 = new HashMap<>();
        map1.put('X',1);
        map1.put('Y',2);
        map1.put('Z',3);
        System.out.println("Исходный Map: "+map1);
        for (Character ch :map1.keySet()){
            map2.put(map1.get(ch),ch);
        }
        System.out.println("Измененный Map: "+map2);
//      Для преподавателя - если необходимо СТРОГОЕ соответствие картинке в задании необходимо раскоментировать код ниже

//        String str="";
//        str=str+"Измененный MAP: {";
//        for (Integer x : map2.keySet()){
//            str=str+x+"=["+map2.get(x)+"], ";
//        }
//        str=str.substring(0,str.length()-2);
//        str+="}";
//        System.out.println(str);
    }
}
