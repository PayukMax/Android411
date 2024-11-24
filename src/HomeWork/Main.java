package HomeWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = "";
        do {
            System.out.print("Введите строку (пустая строка - окончание работы)-> ");
            text = input.nextLine();
            if (text.isEmpty()) break;
            String result = text.toLowerCase().replaceAll("\\s", "");
            String result2 = "";
            for (int i = 0; i < result.length(); i++) {
                result2 += result.charAt(result.length() - 1 - i);
            }
            System.out.println(text + ": " + (result.equals(result2) ? "" : "не") + " является палиндромом");
        } while (true);

        input.close();
    }
}
