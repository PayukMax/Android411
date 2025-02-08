package LessonT16.maps;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
//        TreeMap<String,String> fileExt = new TreeMap<>();
        TreeMap<String,String> fileExt = new TreeMap<>(new Comparator<String>() {// переопределяем метод сортировки и как следствие ключей стало меньше
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });


        fileExt.put("Python","*.py");
        fileExt.put("C++","*.cpp");
        fileExt.put("JavaScript","*.js");
        fileExt.put("Goland","*.go");
        fileExt.put("Java","*.java");
        fileExt.put("java","*.java1");

        System.out.println(fileExt);
        System.out.println(fileExt.get("Java"));
        System.out.println(fileExt.keySet()); // возвращает массив с ключами
        System.out.println(fileExt.descendingMap()); // возвращает развернутый список
        System.out.println(fileExt.descendingMap().keySet());// соответственно ключи в массиве в развернутом виде
        System.out.println(fileExt.lastKey()); // последний ключь (или значение если last
    }
}
