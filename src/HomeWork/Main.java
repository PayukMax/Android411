package HomeWork;

public class Main {
    public static void main(String[] args) {

        String s = "Hello World...";
        int small = 0, big = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') big++;
            else if ((c >= 'a' && c <= 'z')) small++;
        }
        System.out.println("Дана строка - "+s);
        System.out.printf("Количество строчных букв - %d, количество прописных букв - %d",small,big);

}
}
