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
        Graduate graduate = new Graduate("Русанов", "Василий", 35,"Сети", "DS_11", 20, 60 , "Защита перс данных");
        System.out.println(graduate);

        Student student1 = new Student(human, "Физика", "Ф-23",0,0);
        System.out.println(student1);

        Graduate graduate1 = new Graduate(student, "Мат анализ и вычисления");
        System.out.println(graduate1);

        Specialist spec = new Specialist(graduate,5);
        System.out.println(spec);

    }
}
