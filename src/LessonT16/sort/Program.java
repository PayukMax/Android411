package LessonT16.sort;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        University nu1 = new University("Университет", 300);
        University nu2 = new University("Нач школа", 150);
        University nu3 = new University("Средняя школа", 357);
        University nu4 = new University("Высшая школа", 246);
        University nu5 = new University("Музыкальная школа", 789);
        SortUniv sort = new SortUniv();
        int res = sort.compare(nu1,nu2);

        switch (res){
            case 1:
                System.out.println(nu1.getName()+ " больше!");
                break;
            case -1:
                System.out.println(nu2.getName()+ " больше!");
                break;
            default:
                System.out.println("Два учебных завадения равны по численности...");
        }
        ArrayList<University> list = new ArrayList<>();
        list.add(nu1);
        list.add(nu2);
        list.add(nu3);
        list.add(nu4);
        list.add(nu5);
        System.out.println("\nСортировка по имени:");
        SortNameUniv nameComp = new SortNameUniv();
        Collections.sort(list,nameComp);
        for (University name:list){
            System.out.println(name.getName()+" "+name.getNumOfStudents());
        }
        System.out.println();
        System.out.println("Сортировка по количеству учеников:");
        Collections.sort(list,sort);
        for (University name:list){
            System.out.println(name.getName()+" "+name.getNumOfStudents());
        }



    }
}

class University {
    private String name;
    private int numOfStudents;

    public University(String name, int numOfStudents) {
        this.name = name;
        this.numOfStudents = numOfStudents;
    }

    public String getName() {
        return name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

}

class SortUniv implements Comparator<University>{

    @Override
    public int compare(University o1, University o2) {
        if(o1.getNumOfStudents()==o2.getNumOfStudents()) return 0; else if (o1.getNumOfStudents()>o2.getNumOfStudents()) return 1; else return -1;
    }
}

class SortNameUniv implements Comparator<University>{

    @Override
    public int compare(University o1, University o2) {
        return o1.getName().compareTo(o2.getName());
    }
}