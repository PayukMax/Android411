package LessonT16.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(334455, "Михаил Борисов");
        map1.put(445566, "Борис Михайлов");
        map1.put(556677, "Роман Обрамович");
        map1.put(667788, "Анна Полякова");
        map1.put(667781, "Анна Полякова");
        map1.putIfAbsent(334455, "Ольга");// если ключь существует то элемент не перезаписывается
        map1.putIfAbsent(334499, "Ольга");// если ключь существует то элемент не перезаписывается
        map1.put(22, null);
        map1.put(null, "Вася");


        System.out.println(map1.size());
        System.out.println(map1.get(null));
        System.out.println(map1);
        System.out.println(map1.get(334499)); // получить значение оп ключу
        System.out.println(map1.get(33449944)); // получить значение оп ключу - если элемента нет возвращает null
        System.out.println(map1.remove(334455));
        System.out.println(map1);
        System.out.println(map1.containsValue("Ольга"));// возвращает true если запись с таким значением есть, есть метод проверяющий наличие заиси по ключу
        System.out.println(map1.keySet()); // возвращает массив содержащий все ключи
        System.out.println(map1.values()); // возвращает массив содержащий все значения


    }
}
