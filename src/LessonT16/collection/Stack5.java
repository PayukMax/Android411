package LessonT16.collection;

import java.util.Stack;

public class Stack5 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println(stack.add("Катя"));
        stack.push("Виктор");
        stack.push("Маша");
        stack.push("Коля");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

    }
}
