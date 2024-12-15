package LessonT10.person;

public class Teacher extends Human{
    private String predmet;
    private int experience;

    public Teacher(String lastName, String firstName, int age, String predmet, int experience) {
        super(lastName, firstName, age);
        setPredmet(predmet);
        setExperience(experience);
//        System.out.println("Teacher constructor...");
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString()+" Teacher{" +
                "predmet='" + predmet + '\'' +
                ", experience=" + experience +
                '}';
    }
}
