package LessonT16.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Hw {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>(Arrays.asList("Красный","Оранжевый","Желтый","Зеленый","Голубой","Синий","Фиолетовый"));
        System.out.println("Список: "+colors);
        System.out.println("\nСписок итераторов в прямом направлении:");
        ListIterator<String> p = colors.listIterator();
//        while(p.hasNext())  System.out.println("Индекс = "+p.nextIndex()+", Элемент = "+p.next());
        System.out.println("\nСписок итераторов в обратном направлении:");

        while (p.hasPrevious()) System.out.println("Индекс = "+p.previousIndex()+", Элемент = "+p.previous());

    }
}
