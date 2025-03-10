package LessonT15.test.hw;

@FunctionalInterface
interface Operation {
    int execute(int x, int y);
//    String concat (String a, String b);// указав FunctionalInterface ограничиваем создание в интерфейсе только одного метода, поскольку далее через лямбду мы будем реализовывать сей метод. Если этой аннотации не сделать модно добавить еще методов но в таком случае лямбда не смоет опредеделить какой метод переопределяется
}

public class LambdaApp {
    public static void main(String[] args) {
        Operation func = action(1);
        int a = func.execute(6,5);
        System.out.println(a);

        int b = action(2).execute(8,2);
        System.out.println(b);
    }

    private static Operation action(int number) {
        switch (number) {
            case 1:
                return (x, y) -> x + y;
            case 2:
                return (x, y) -> x - y;
            case 3:
                return (x, y) -> x * y;
            default:
                return (x, y) -> 0;

        }
    }
}
