package LessonT10.person;

public class Specialist extends Graduate{
    private int ball;

    public Specialist(Graduate other, int ball) {
        super(other);
        this.ball = ball;
    }

    @Override
    public String toString() {
        return super.toString()+" Specialist{" +
                "ball=" + ball +
                '}';
    }
}
