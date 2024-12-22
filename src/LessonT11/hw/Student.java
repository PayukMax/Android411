package LessonT11.hw;

public class Student {
    private String fName;
    private String lName;
    private String group;
    private int averageBall;

    public Student(String fName, String lName, String group, int averageBall) {
        this.fName = fName;
        this.lName = lName;
        this.group = group;
        setAverageBall(averageBall);
    }

    public String getfName() {
        return fName;
    }

    public String getLname() {
        return lName;
    }

    public String getGroup() {
        return group;
    }

    public int getAverageBall() {
        return averageBall;
    }

    public void setAverageBall(int ball) {
         if (ball>0 && ball<=5) this.averageBall=ball;
    }

    public double getSum(){
        if (averageBall==5) return 1000; else return 800;
    }

    public void showData(){
        System.out.println(this.getfName()+" "+this.getLname()+", группа "+this.getGroup()+", сумма стипендии: "+this.getSum());
    }
}
