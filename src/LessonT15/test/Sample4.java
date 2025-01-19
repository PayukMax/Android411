package LessonT15.test;

import org.w3c.dom.ls.LSOutput;

interface StringFunc{
    String func(String n);
}
public class Sample4 {
    public static void main(String[] args) {
        String inStr = "лямбда выражения в Java";
        System.out.println("Исходная строка: "+inStr);
        String outStr = stringOp(str -> str.toUpperCase(), inStr);
        System.out.println("В верхнем регистре: "+outStr);

        StringFunc revers = (str) -> {// Тут описываем реализацию метода func интерфейса StringFunc, если описание многострочное заключаем его в фигурные скобки - сохраняем его в переменную типа интерфейса
            String res="";
            for (int i = str.length()-1; i >=0 ; i--) {
                res +=str.charAt(i);
            }
            return res;
        };// закончилось описание реализации метода func интерфейса StringFunc

        System.out.println("Развернутая строка: "+stringOp(revers,inStr));

        System.out.println("Развернутая строка: "+stringOp(revers,inStr));



    }

    static String stringOp(StringFunc sf, String s){
        return sf.func(s);
    }
}
