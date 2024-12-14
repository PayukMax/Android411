package LessonT8.cars;

import java.time.Year;

public class Cars {
    private String model;
    private int year;
    private String brand;
    private int pow;
    private String color;
    private int price;

    public Cars() {
    }

    public Cars(String model, int year, String brand, int pow, String color, int price) {
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.pow = pow;
        this.color = color;
        setPrice(price);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        if (year >= 1886 && year <= Year.now().getValue()) {
            this.year = year;
            return true;
        } else return false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public boolean setPrice(int price) {
        if (price >= 0) {
            this.price = price;
            return true;
        } else return false;
    }

    public void displayData() {
        System.out.println("******************* Данные автомобиля *****************");
        System.out.println("Название модели   : " + this.getModel());
        System.out.println("Год выпуска       : " + this.getYear());
        System.out.println("Производитель     : " + this.getBrand());
        System.out.println("Мощность двигателя: " + this.getPow() + " л.с.");
        System.out.println("Цвет машины       : " + this.getColor());
        System.out.println("Цена              : " + this.getPrice());
        System.out.println("=======================================================");
    }
}
