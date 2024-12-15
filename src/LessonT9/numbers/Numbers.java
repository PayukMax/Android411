package LessonT9.numbers;

public class Numbers {
    public static int max(int a, int b, int c, int d) {
        int mx = a;
        if (b > mx) mx = b;
        if (c > mx) mx = c;
        if (d > mx) mx = d;
        return mx;
    }

    public static int min(int... num) {
        int mn = num[0];
        for (int tmp : num)
            if (mn > tmp) mn = tmp;
        return mn;
    }

    public static double average(int... num) {
        double res = 0;
        for (int tmp : num)
            res += tmp;
        return res/num.length;
    }

    public static int factorial(int a) {
        int res = 1;
        for (int i = 1; i <= a; i++) res=res*i;
        return res;
    }


}
