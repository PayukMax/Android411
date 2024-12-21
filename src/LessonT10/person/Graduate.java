package LessonT10.person;

public class Graduate extends Student {
    private String subject;

    public Graduate(Graduate other) {
        super(other);
        setSubject(other.subject);
        System.out.println("Grad constructor");
    }



    public Graduate(Student std, String subject) {
        super(std);
        setSubject(subject);
        System.out.println("Grad constructor");
    }

    public Graduate(String lastName, String firstName, int age, String spec, String group, double rating, double attendance, String subject) {
        super(lastName, firstName, age, spec, group, rating, attendance);
        setSubject(subject);
        System.out.println("Grad constructor");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString()+" Graduate{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
