package LessonT15.test;

interface Printable{
//void    print(String s);
void    print();
}

public class Sample1 {
    public static void main(String[] args) {
//        Printable printable = s -> System.out.println(s); // если принимаемый параметр один - s скобки вокруг можно не ставить, если более то ставим
        Printable printable = () -> System.out.println("asdfgsdfg sdfgsdfg wertwert xfgsd"); // если принимаемых параметров нет - скобки ставим

//        printable.print("asdasdf asdfasdf asdfasd");
        printable.print();
    }
}
