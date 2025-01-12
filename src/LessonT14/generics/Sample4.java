package LessonT14.generics;

public class Sample4 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Average<Integer> integerAverage = new Average<>(intArray);
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Average<Double> doubleAverage = new Average<>(doubleArray);

        System.out.println(integerAverage.average());
        System.out.println(doubleAverage.average());

    }
}

class Average<T extends Number> {
    private T[] array;

    public Average(T[] array) {
        this.array = array;
    }

    public double average() {
        double sum = 0;
        for (T val : array) sum += val.doubleValue();
        return sum / array.length;
    }
}