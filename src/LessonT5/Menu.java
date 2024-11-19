package LessonT5;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size;
        size = input.nextInt();
        int[] list = new int[size];
        int option;
        do {
            System.out.print("Меню:\n1.Ввод элементов массива\n2.Отображение массива\n3.Поиск элементов в массиве\n4.Сортировка массива\n5.Выход\nСделайте выбор ->");
            option = input.nextInt();
            switch (option) {
                case 1:
                    inputArray(list);
                    break;
                case 2:
                    showArray(list);
                    break;
                case 3:
                    System.out.print("Введите элемент для поиска: ");
                    int item = input.nextInt();
                    int index = searchArray(list, item);
                    if (index==-1)
                        System.out.println("Элемент не найден...");
                    else
                        System.out.println("Элемент найден на позиции "+ (index+1));
                    break;
                case 4:
                    System.out.println("Отсортированный массив: ");
                    sortArray(list);
                    showArray(list);
                    break;
                case 5:
                default:
            }
        } while (option != 5);


    }

    static void inputArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("-> ");
            array[i] = input.nextInt();

        }
    }

    static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static int searchArray(int[] array, int data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]==data) return i;

        }
        return -1;
    }

    static void sortArray(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1 ; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

}