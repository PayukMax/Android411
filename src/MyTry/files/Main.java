package MyTry.files;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bfri = new BufferedReader(new InputStreamReader(System.in));

//        System.out.print("Enter the Path : ");

        // Reading File name
//        String path = bfri.readLine();

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader bfro = new BufferedReader(new FileReader("d:\\MaxTest\\11111.csv"));
        String st;
        String[] rec = {"", "", "", ""};
        while ((st = bfro.readLine()) != null) {
//            System.out.println(st);
            rec = st.split(";");
            if (rec.length>1) {
                for (int i = 0; i < rec.length; i++) {
                    System.out.print(i + ")" + rec[i] + " | ");
                }
                System.out.println();
            } else {
                String temp=rec[0];
                st = bfro.readLine();
                rec = st.split(";");
                rec[0]=temp+rec[0];
                for (int i = 0; i < rec.length; i++) {
                    System.out.print(i + ")" + rec[i] + " | ");
                }
                System.out.println();
            }
        }
    }
}
