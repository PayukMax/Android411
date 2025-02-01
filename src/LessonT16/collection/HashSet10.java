package LessonT16.collection;

import java.util.*;

public class HashSet10 {
    public static void main(String[] args) {
        try {
            List<Integer> numb = readNumbers();
            checkDublicates(numb);
        } catch (Dubl_Numb_Exceptions e){
            System.out.println("Ошибка "+e.getMessage());
        }
//        System.out.println(numb);


    }

    public static List<Integer> readNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("К-во чисел: ");
        int count = input.nextInt();
        System.out.println("Введите целые числа: ");
        for (int i = 0; i < count; i++) {
            System.out.print("-> ");
            int num = input.nextInt();
            numbers.add(num);
            }
        return numbers;
    }

    public static void checkDublicates(List<Integer> numbers) throws Dubl_Numb_Exceptions{
        Set<Integer> unicNumb = new HashSet<>();
        for (int num : numbers){
            if (unicNumb.contains(num)){
                throw  new Dubl_Numb_Exceptions("Обнаружен повторяющийся номер: "+num);
            }
            unicNumb.add(num);
        }

    }

}

class Dubl_Numb_Exceptions extends Exception{
    public Dubl_Numb_Exceptions(String message) {
        super(message);
    }

}