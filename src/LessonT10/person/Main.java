package LessonT10.person;
/*
Выводы конструкторов в классах временно закоментировал, дабы не мусорили в вывод.
Принцип и порядок работы конструкторов понял.
 */


public class Main {
    public static void main(String[] args) {
        Human human = new Human("Батодалаев", "Даши",16);
        System.out.println(human);
        Student student = new Student("Петров","Василий", 18,"Математика", "NM_220",90,95);
        System.out.println(student);
        Teacher prepodavatel = new Teacher("Башкиров", "Алексей", 45,"Разработка приложений", 20);
        System.out.println(prepodavatel);
    }
}
