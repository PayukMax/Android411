package LessonT9.grouph;

public class Student {
    private String name;
    private String initials;
    private int group;
    private int marks[];
    private int nMark;

    public Student(String name, String initials, int group) {
        this.name = name;
        this.initials = initials;
        this.group = group;
        this.marks = new int[5];
        this.nMark = 0;

    }

    public boolean addGrade(int grade) {
        if (nMark >= 5)
            return false;

        this.marks[nMark] = grade;
        nMark++;
        return true;
    }

    public boolean isGood(){
        for (int i = 0; i < marks.length; i++) {
            if (marks[i]>=1 && marks[i] <= 4) return false;
        }
        return true;
    }

    public void print() {
        System.out.printf("%-16s %-8s", name, initials);
        System.out.printf("Группа: %-4d Оценки: ", group);
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}
