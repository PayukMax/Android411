package LessonT14.generics;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {2,1,5,3,4};
        Double[] doubleArray = {3.3,2.2,1.1,4.4};
        Character[] charArray = {'G','e','n','e','r','i','c'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

    }

//    public static void printArray(Integer[] inputArray){ // в случай других типов меняем тип данных на Double или Character
//        for (Integer el:inputArray){ // здесь тоже меняем на Double или Character. Примитивные в этом случае использовать нельзя
//            System.out.printf("%s ",el);
//        }
//        System.out.println();
//    }


    public static <T> void printArray(T[] inputArray){// перед void говорим <T> - будем использовать обобщенные типы данных и далее указываем где именно они применяются
        for (T el:inputArray){
            System.out.printf("%s ",el);
        }
        System.out.println();
    }
}
