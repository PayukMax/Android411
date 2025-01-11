package LessonT14.generics;

import java.util.ArrayList;

public class Sample2 {
    public static void main(String[] args) {
        PrintList<Integer> pl = new PrintList<>();
        for (int i = 0; i < 10; i++) {
            pl.add(i);

        }
        System.out.println(pl);
        pl.printList(false);
    }
}

class PrintList<T>{
    private ArrayList<T> list;

    public PrintList() {
        this.list = new ArrayList<T>();
    }
    public void add(T data){
        list.add(data);
    }

    public void printList(boolean isOdd){
        if (isOdd){
            for (int i = 1; i < list.size(); i+=2) {
                System.out.print(list.get(i)+" ");
            } }else {for (int i = 0; i < list.size(); i+=2) System.out.print(list.get(i)+" ");
           }
        }


    @Override
    public String toString() {
        return "PrintList{" +
                "list=" + list +
                '}';
    }
}
