package LessonT8.cars;

import java.util.ArrayList;
import java.util.Scanner;

/*
Доброго дня
Во исполнении задания, для примера были созданы 2 эеземпляра класса, в первом случае для заполнения полей использовался
конструктор, во втором поля уже созданного экземпляра заполнялись через сеттеры.
Для вывода информации использовался метод, обращающийся к полям метода через геттеры (сие избыточно,но соответствует
заданию)
Для примера в 2-х сеттерах проводятся проверки:
- setPrice на отрицательное значение цены
- setYear на корректное значение года выпуска, от года выпуска первого автомобиля до текущего года

Формат вывода нескольк отличается, так показалось красивее...
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Cars> carsList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        Cars car = new Cars("X7 M50i", 2021, "BMW", 530, "white", 10790000);
        carsList.add(car);

        car = new Cars();
        car.setModel("Granta");
        car.setYear(2024);
        car.setColor("красненькая");
        car.setPow(160);
        car.setBrand("АвтоВАЗ");
        car.setPrice(1980000);
        carsList.add(car);

        car = new Cars();
        System.out.print("Название модели: ");
        car.setModel(input.nextLine());
        do {
            System.out.print("Год выпуска: ");
        } while (!car.setYear(input.nextInt()));
        input.nextLine();
        System.out.print("Производитель: ");
        car.setBrand(input.nextLine());
        System.out.print("Мощность двигателя: ");
        car.setPow(input.nextInt());
        input.nextLine();
        System.out.print("Цвет машины: ");
        car.setColor(input.nextLine());
        System.out.print("Цена: ");
        car.setPrice(input.nextInt());
        carsList.add(car);

//        carsList.add(new Cars("X7 M50i", 2021, "BMW", 530, "white", 10790000));

        for (Cars tmp : carsList) {
            tmp.displayData();
            System.out.println("------------------------------------------");
        }
        input.close();
    }
}
