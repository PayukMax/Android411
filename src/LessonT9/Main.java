package LessonT9;
// еще раз о перегрузке методов различными способами - по количеству передаваемых параметров,
// по типу передаваемых параметров и по порядку указания параметров

public class Main {
    public static void main(String[] args) {
        Calculation obj = new Calculation();
        // по количеству параметров
        obj.calculate(1, 2);
        obj.calculate(1, 2,3);
        // по типу передаваемых параметров
        obj.calculate(2.5, 3.4);
        //  по порядку параметров
        obj.calculate(2.5, 2);
        obj.calculate(2, 3.4);
    }
}
    class Calculation{
        public void calculate(int a, int b){
            System.out.println("Сумма двух целых чисел: "+(a+b));
        }

        public void calculate(int a, int b, int c){
            System.out.println("Сумма трех целых чисел: "+(a+b+c));
        }

        public void calculate(double a, double b){
            System.out.println("Сумма двух вещественных чисел: "+(a+b));
        }

        public void calculate(double a, int b){
            System.out.println("В результате вещественное число: "+(a+b));
        }

        public void calculate(int a, double b){
            System.out.println("В результате целое число: "+(int)(a+b));
        }


    }

