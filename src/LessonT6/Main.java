package LessonT6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        char[] halloArray = {'П','р','и','в','е','т'};
//        String helloString = new String(halloArray);

//        String str1 = "Hallo";
//        int a = 5;
//        String message = str1+a; // на этом месте происходит конкатенация и второе значение приводитс к String

//        int a=5;
//        String str1="2";
//        int message = a+Integer.parseInt(str1);
//        System.out.println(message);

//        String str1 = "Hallo...";
//        System.out.println(str1.length());


//        String name = "NiKita";
//        String name2 = name.toLowerCase();
//
//        String s = "Я буду хорошим программистом...";
//        char res=s.charAt(7); // возвращает букву в массиве String на позичии 7
//        System.out.println(res);
        String s = "я буду хорошим программистом...";
        int[] result = new int['я'-'а'+1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.println(c);
            if(c>='а'&&c<='я'){
                result[c-'а']++;
            }

        }
        for (int i = 0; i < result.length; i++) {
            System.out.println((char)(i+'а')+" = "+result[i]);
        }
        System.out.println(Arrays.toString(result));

    }
}
