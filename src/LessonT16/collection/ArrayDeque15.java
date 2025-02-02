package LessonT16.collection;

import java.util.ArrayDeque;

public class ArrayDeque15 {
    public static void main(String[] args) {
        ArrayDeque<String> states = new ArrayDeque<>();
        states.add("red");
        states.add("blue");
        states.add("white");
        states.add("green");
        states.add("black");

        System.out.println(states);
        System.out.println(states.getFirst());
        System.out.println(states.getLast());
        System.out.println(states);
        while (states.peek()!=null){// вариант проверки кроме !states.isEmpty()
            System.out.println(states.pop());
        }
        System.out.println(states);

    }
}
