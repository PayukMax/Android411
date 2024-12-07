package LessonT7;

import java.util.Arrays;

public class New2Main {
    public static void main(String[] args) {
////        String s = "Я ищу совп.дения 21:22в 2024 году. И я их найду в 2 счёта.";
////        String[] arr = s.split("\\."); // split разбивает строку по символу разделителю и вернет массив
//        String s = "Паюк Максим, Россия,    г.Новос,     +7 999 999 999999";
//        String[] arr = s.split(",\\s*"); // split разбивает строку по символу разделителю и вернет массив, в данном случай разделителем является запятая и некоторое количество пробелов

        String s = "05-03-1987 //Дата рождения";
        String s2 = s.replaceAll("\\s//.*","").replaceAll("-",".");

        System.out.println("Дата рождения: "+ s2);

//        System.out.println(Arrays.toString(arr));
//        for(String tmp:arr){
//            System.out.println(tmp);
//        }
    }
}
