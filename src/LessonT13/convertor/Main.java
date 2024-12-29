package LessonT13.convertor;

public class Main {
    public static void main(String[] args) {
        double temp = 21.5;
        final int n=3;
        Converter conv[] = new Converter[n];
        conv[0] = new Celsius();
        conv[1] = new Kelvin();
        conv[2] = new Farengate();

        for (Converter c:conv) {
            System.out.println("t = "+c.getConvertedValue(temp));

        }
    }
}

interface Converter {
    double getConvertedValue(double baseValue);
}

class Celsius implements Converter {
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue;
    }
}

class Kelvin implements Converter{
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue+273.15;
    }
}

class Farengate implements Converter {
    @Override
    public double getConvertedValue(double baseValue) {
        return 1.8*baseValue+32;
    }
}