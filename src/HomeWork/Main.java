package HomeWork;

public class Main {
    public static void main(String[] args) {
        String str = " Текст с повторяющимися символами   ...";
        System.out.println("Исходная строка  -\"" + str + "\"");
        System.out.println("Измененная строка - \"" + newModifyStr(str) + "\"");
    }

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
