package LessonT14.generics.program;

public class FigureStatistics<T extends Figure> {
    T[] arr;

    public FigureStatistics(T[] arr) {
        this.arr = arr;
    }

    public double getSumArea() {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i].getArea();

        }
        return result;
    }

    public double getMaxArea() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].getArea()) max = arr[i].getArea();
        }
        return max;
    }

    public double getMinArea() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i].getArea()) min = arr[i].getArea();
        }
        return min;

    }
}
