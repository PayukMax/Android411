package LessonT11.hw;

public class Main {
    public static void main(String[] args) {
        Student mass[] = new Student[3];
        mass[0] = new Student("Виктор", "Вербов", "Gr111", 5);
        mass[1] = new Aspirant("Александр", "Невзоров", "Gr222", 3, "Work1");
        mass[2] = new Aspirant("Антон", "Бобров", "Gr333", 5, "Work2");

        for (int i = 0; i < mass.length; i++) {
            mass[i].showData();
        }

    }
}
