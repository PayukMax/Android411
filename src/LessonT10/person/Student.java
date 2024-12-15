package LessonT10.person;

public class Student extends Human{
    private String spec;
    private String group;
    private double rating;
    private double attendance;

    public Student(String lastName, String firstName, int age, String spec, String group, double rating, double attendance) {
        super(lastName, firstName, age);
//        this.spec = spec;
//        this.group = group;
//        this.rating = rating;
//        this.attendance = attendance;
        setSpec(spec);
        setGroup(group);
        setRating(rating);
        setAttendance(attendance);
//        System.out.println("Student constructor...");
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return super.toString()+" Student{" +
                "spec='" + spec + '\'' +
                ", group='" + group + '\'' +
                ", rating=" + rating +
                ", attendance=" + attendance +
                '}';
    }
}
