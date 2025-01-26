package LessonT16.collection;

import java.util.*;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Валера");
        list.add("Ирина");
        list.add("Игорь");
        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<>(20);
        list2.add("Валера");
        list2.add("Ирина");
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("Валера");
        list3.add("Ирина");
        System.out.println(list3);

        ArrayList<String> list4 = new ArrayList<>(list);
        System.out.println(list4);
        list4.add("Владимир");
        System.out.println(list4);
        System.out.println(list);

        ArrayList list5 = new ArrayList();
        list5.add("Петя");
        list5.add(7);
        list5.add(true);
        System.out.println(list5);

        ArrayList<String> list6 = new ArrayList<>();
        list6.add("!!!!!");
        list6.add("??????");
        list6.addAll(1,list); // добавляем из списка с позиуии
        System.out.println(list6);
//        list6.removeAll(list); // удаляем все что в списке
//        System.out.println(list6);
        list6.retainAll(list); // удаляем все кроме того что в списке
        System.out.println(list6);

        List <String> myList = list6.subList(1,3); // копируем во второй список фрагмент из первого списка
        System.out.println(myList);
        myList.add("Борис1111");
        System.out.println(myList);
        System.out.println(list6);// Опаньки - при добавлении во второй список правится и исходный - особенность subList

        String[] array = list6.toArray(new String[0]);// даже если укажем размер массива 0 он создастся по размеру list6, если укажем больше - создаст сколько указали заполнив пустые null
        for (String s:array) System.out.print(s+" ");
        System.out.println("\n"+array.length);

        Collections.sort(list6); //  Collections методом сортирует изменяя исходный список статическим методом
        System.out.println(list6);

//        Collections.shuffle(list6); // произвольная сортировка
//        System.out.println(list6);

        Collections.reverse(list6); // разворот списка
        System.out.println(list6);

        Collections.swap(list6,0,2); // меняем в списке местами элементы
        System.out.println(list6);

        // ИТЕРАТОР

        Iterator<String> iter =  list6.iterator();
//        System.out.println(iter);
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next()); //  в таком виде налетаем на исключение - закончился список
        while (iter.hasNext()) System.out.println(iter.next()); // а вот так норм - hasNext - true если следующий есть, когда окончится списк то false

        while (iter.hasNext()){
            iter.next(); // сначала найдем элемент
            iter.remove();// и только после этого его удаляем, иначе нарвемся на исключение
        }




    }
}
