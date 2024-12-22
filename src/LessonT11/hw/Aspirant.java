package LessonT11.hw;

public class Aspirant extends Student{
private String tema;

    public Aspirant(String fName, String lname, String group, int averageBall, String tema) {
        super(fName, lname, group, averageBall);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public double getSum() {
        if (this.getAverageBall()==5) return 2000; else return 1800;
    }

    @Override
    public void showData() {
        System.out.println(this.getfName()+" "+this.getLname()+", группа "+this.getGroup()+", тема работы: '"+this.getTema()+"', сумма стипендии: "+this.getSum());
    }
}
