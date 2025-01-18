package LessonT14.exeption;

public class Test2 {
    public static void main(String[] args) {
        int numbers[] = {4,8,16,32,64,128};
        int denominator[] = {2,0,4,4,0,8};

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(numbers[i] + "/" + denominator[i] + "=" + numbers[i] / denominator[i]);
            } catch (ArithmeticException e) {
                System.out.println("На ноль делить нельзя ");

            }

        }
    }
}
