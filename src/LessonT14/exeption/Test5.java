package LessonT14.exeption;

public class Test5 {
    public static void main(String[] args) {
        try {com(1);
        com(20);} catch (NewException e){
            System.out.println("Перехваченное исключение "+e);
        }

    }

    public static void com (int a) throws NewException{
        System.out.println("Вызван метод com ("+a+")");
        if (a>10){
            throw  new NewException(a,"Не корректное значение...");
        }
        System.out.println("Нормальное значение...");
    }

}

class NewException extends Exception{
    private  int detail;

    public NewException( int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "NewException{" +
                "detail=" + detail +
                " message="+getMessage()+"}";
    }
}
