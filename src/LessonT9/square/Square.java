package LessonT9.square;

/* в классе проводится примитивная проверка корректности принимаемых значений, отрицательные
и нулевые значения к вычислению не принимаются и соответственно счетчик вычислений не увеличивают
 */
public class Square {
    private static int count;

    public static double triangle(int a, int b, int c) {
        if (a > 0 && b > 0 && c > 0) {
            int p = (a + b + c) / 2;
            count++;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else return 0;
    }

    public static double triangle(int a, int b) {
        if (a > 0 && b > 0) {
            count++;
            return (a * b) / 2;
        } else return 0;
    }

    public static int rectangle(int a) {
        if (a > 0) {
            count++;
            return (a * a);
        } else return 0;
    }

    public static int rectangle(int a, int b) {
        if (a > 0 && b > 0) {
            count++;
            return (a * b);
        } else return 0;
    }

    public static int getCount() {
        return count;
    }
}
