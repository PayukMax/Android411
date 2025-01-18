package LessonT14.exeption;

public class Test4 {
    public static void main(String[] args) {
        try{
            ex();

        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ex() throws RuntimeException{
        throw new RuntimeException("Hello Exceptions...");
    }
}
