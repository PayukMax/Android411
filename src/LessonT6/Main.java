package LessonT6;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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

//        String s = "я буду хорошим программистом...";
//        int[] result = new int['я'-'а'+1];
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
////            System.out.println(c);
//            if(c>='а'&&c<='я'){
//                result[c-'а']++;
//            }
//
//        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.println((char)(i+'а')+" = "+result[i]);
//        }
//        System.out.println(Arrays.toString(result));

//        String s1 = "";
//        if (s1.length()==0 || s1.isEmpty()) System.out.println("Строка пустая..."); // два способа проверки пустой строки дающие одинаковый результат

//        String str1="https://www.oracle.com/java/technologies/downloads/#jdk20-";
//        char[] res = str1.toCharArray();
//        System.out.println("Массив символов ->"+ str1);
//        for (int i = 0; i < res.length; i++) {
//            if (res[i]=='/') res[i]= '\\';
//        }
//        String result = new String(res);
//
//        System.out.println("Рес "+result);
//        str1.indexOf() // поиск первого вхождения, или indexOf('f',5) симфво f  начиная с 5 позиции
//        str1.lastIndexOf() // то же самое только с конца, или с позиции Х влево. Возвраает позицию или -1 если не найдено

//        String str="I learning Java";
//        String str11=str.substring(5,10);// выдираем подстроку с позиции до позиции. если второго аргумента нет то до конца строки
//        System.out.println(str11);

//        System.out.print("Введите два слова через пробел -> ");
//        String str = input.nextLine();
//        int x = str.indexOf(' ');
//        System.out.println(str.substring(x-1)+" "+str.substring(0,x));


//        String str = "I learning Java";
//        String[] words = str.split(" "); // делит строку на подстроки по символу-разделителю
//        for(String word : words) System.out.println(word);

//        System.out.print("Введите ФИО (пробелы) ->");
//        String str1= input.nextLine();
//        String[] words = str1.split(" "); // делит строку по разделителю на массив строк
//        System.out.println(Arrays.toString(words));
//        System.out.println(words[0]+" "+words[1].charAt(0)+"."+words[2].substring(0,1)+".");

//        String str = "Строка...";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(str.length()-1-i));
//        }

//        String res = String.join(":","00","22","33");
//        System.out.println(res);
//        String[] text = new String[]{"Я","буду","хорошим","прогером"};
//        String str = String.join(" && ",text);
//        System.out.println(str);

//        String text = "Я изучаю Java. Мне нравится Java.";
//        System.out.println(text);
//        String[] array = text.split("Java");
//        System.out.println(Arrays.toString(array));
//        String res = String.join("Android",array);
//        System.out.println(res);

//        String text = "Я изучаю Java. Мне нравится Java.";
//        String text1=text.replace("Java","Android");
//        System.out.println(text);
//        System.out.println(text1);

//        String text = "Замените в этой строке все появления буквы 'o' на букву 'О', кроме первого и последнего вхождения";
//        String text2 = "";
//        char x;
//        int pos1=text.indexOf('о');
//        int pos2=text.lastIndexOf('о');
//        for (int i = 0; i < text.length(); i++) {
//            x=text.charAt(i);
//            if (x=='о'&& i!=pos1&& i!=pos2) {
//                x='О';
//            }
//            text2 +=x;
//        }
//        System.out.println("Исходная строка -> "+text);
//        System.out.println("Результирующая -> "+text2);


//        String a = "Hallo";
//        String b = "Hallo";
//        String c = "Good bye";
//        String d = "HALLO";
//        System.out.println(a+" == "+b+" -> "+a.equals(b));
//        System.out.println(a+" == "+c+" -> "+a.equals(c));
//        System.out.println(a+" == "+d+" -> "+a.equals(d));
//        System.out.println(a+" == "+d+" -> "+a.equalsIgnoreCase(d));
//
//        System.out.println("I learning Java".endsWith("Java")); // заканчивается на чтото
//        System.out.println("I learning Java".startsWith("I"));// начинается с чего то
//        System.out.println("I learning Java".contains("lear")); // содержит в строке чтото


//        System.out.print("Введите название документа ->");
//        String path = input.nextLine();
//        if (path.endsWith(".jpg")||path.endsWith(".jpeg")) System.out.println("Это изображение");
//        else if(path.endsWith(".html")) System.out.println("Это HTML страница");

//        String s="АЯаяёЁПривет мир...I learning Java";
//        int n;
//        n=s.codePointAt(0);
//        System.out.println(n+" "+s.charAt(0));
//        System.out.println(s.codePointAt(1)+" "+s.charAt(1));
//        System.out.println(s.codePointAt(2)+" "+s.charAt(2));
//        System.out.println(s.codePointAt(3)+" "+s.charAt(3));
//        System.out.println(s.codePointAt(4)+" "+s.charAt(4));
//        System.out.println(s.codePointAt(5)+" "+s.charAt(5));
//        System.out.println(s.codePointAt(6)+" "+s.charAt(6));

//        String s="";
////        double d=3.3567;
////        int d = -123;
//        boolean d=true;
//        s=String.valueOf(d);
//        System.out.println(s);

//        String str="1";
//        System.out.println("1 > 5 ->"+str.compareTo("5"));
//        System.out.println("1 > 1 ->"+str.compareTo("1"));
//        str ="7";
//        System.out.println("7 > 1 ->"+str.compareTo("5")); // сравниваются н сами символы а из индексы в таблице UTF-8

//        System.out.println("Введите текст с пробелами -> ");
//        String text = input.nextLine();
//        String result;
//        System.out.println(text);
//        String[] array = text.split(" ");

//        System.out.println("Заменяемая строка -> ");
//        String text1 = input.nextLine();
//        System.out.println("Новая строка -> ");
//        String text2 = input.nextLine();
//        if (text.contains(text1))  result = text.replaceAll(text1,text2);
//        System.out.println(result);

//        System.out.println(Arrays.toString(array));
//        String res = String.join("Android",array);
//        System.out.println(res);


//        // домашняя - порверить введенную строку на палиндром (выполнено 24.11.2024)
//        String text="";
//        do {
//        System.out.print("Введите строку (пустая строка - окончание работы)-> ");
//        text = input.nextLine();
//        if (text.length()==0) break;
//        String result = text.toLowerCase().replaceAll("\\s","");
//        String result2="";
////        System.out.println(result);
//        for (int i = 0; i < result.length(); i++) {
//            result2 += result.charAt(result.length()-1-i);
//        }
//        System.out.println(text+": "+(result.equals(result2)? "": "не")+" является палиндромом");
////        System.out.println(result2);
//        } while (true);

        // занятие 30.11.2024
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//        System.out.println(sb+"\n");
//
//        StringBuilder sb1 = new StringBuilder(1000);
//        System.out.println(sb1.capacity());
//        System.out.println(sb1.length());
//        System.out.println(sb1+"\n");
//
//        StringBuilder sb2 = new StringBuilder("Java");
//        System.out.println(sb2.capacity());
//        System.out.println(sb2.length());
//        System.out.println(sb2+"\n");
//
//        StringBuilder sb3 = new StringBuilder("String");
//        System.out.println(sb3.capacity());
//        System.out.println(sb3.length());
//        System.out.println(sb3+"\n");
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.append(true);
//        sb.append(10); // метод преобразует аргумент к строковому типу и добавляет в sb в конец
//        sb.insert(5,"!!!"); // вставка в произвольный учксток
//        sb.insert(sb.length(),"aaa"); // результат аналогичный append, если сделаем с позиции 0 - то добавление в начало
//        System.out.println(sb);
//        sb.delete(3,14); // удаляем с позиции до позиции, конечная позиция может выходить за груницу
//        sb.deleteCharAt(1); // удаляет один символ
//        sb.append(" Hello world!!!");
//        sb.replace(9,14,"Java");
//        System.out.println(sb);
//        System.out.println(sb.substring(3,8));
//        sb.reverse(); // разворот строки с последнего до первого
//        System.out.println(sb);
//
//        System.out.println(sb.indexOf("a"));
//        System.out.println(sb.reverse().indexOf("Java")); // ищем в строке вхождение "Java" и возвращаем позицию на которой оно находится, если не нашли -1
//        System.out.println(sb.indexOf("a",4)); // поиск фрагмента с позиции

//        StringBuilder sb1 = createStr(5,3);
//        System.out.println(sb1);
//
//        modifyStr(sb1,"=","равно");
//        modifyStr(sb1,"+", "плюс");
//        modifyStr(sb1,"-", "минус");
//        modifyStr(sb1,"*", "умножить");
//        System.out.println(sb1);

        String str = " Текст с повторяющимися символами   ...";
        System.out.println("Исходная строка  -\""+str+"\"");
        System.out.println("Измененная строка - \""+newModifyStr(str)+"\"");



    }

//    public static StringBuilder createStr(int a, int b){
//        StringBuilder res = new StringBuilder();
//        res.append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
//        res.append(a).append(" - ").append(b).append(" = ").append(a-b).append("\n");
//        res.append(a).append(" * ").append(b).append(" = ").append(a*b).append("\n");
//        return res;
//    }

//    public static void modifyStr(StringBuilder stByld, String oldStr, String newStr){
//        int pos;
//        while ((pos= stByld.indexOf(oldStr)) != -1) {
//            stByld.replace(pos,pos+1,newStr);
//
////            stByld.deleteCharAt(pos);
////            stByld.insert(pos, newStr);
//        }
//        return stByld; // если в описании метода делаем void то можем не нужно делать return, иначе возвращаемое значение StringBuilder вместо void
//}
    public static StringBuilder newModifyStr(String str1){
        str1=str1.replaceAll(" ","");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if(res.indexOf(String.valueOf(str1.charAt(i))) == -1) {
                res.append(str1.charAt(i));
            }
        }
        return res;
    }

}
