package MyTry.files;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        int count = 0, countD = 0;
        boolean flag;
        Map<String, Rec> mapList = new HashMap<>();

//        BufferedReader bfri = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bfro = new BufferedReader(new FileReader("c:\\MaxTest\\11111.csv"));
        String st;
        String[] rec = {"", "", "", ""};
        while ((st = bfro.readLine()) != null) {
            flag = false;
            st = st.replaceAll("\"", "");
            st = st.replaceAll("=", "");
            st = st.replaceAll(" ", "");
            var recTmp = st.split(";");
//            if (recTmp.length == 1) { // перенос строки в первом поле - исправляем
//                rec[0] = recTmp[0];
//                st = bfro.readLine();
//                st = st.replaceAll("\"", "");
//                st = st.replaceAll("\n", "");
//                st = st.replaceAll("=", "");
//                recTmp = st.split(";");
//            }

//            if (recTmp.length == 2) {
//                rec[0] = rec[0] + recTmp[0];
//                rec[1] = recTmp[1];
//                st = bfro.readLine();
//                st = st.replaceAll("\"", "");
//                st = st.replaceAll("=", "");
//                recTmp = st.split(";");
//
//            }
//            if (recTmp.length == 3) {
//                rec[0] = rec[0] + recTmp[0];
//                rec[1] = rec[1] + recTmp[1];
//                rec[2] = recTmp[2];
//            }

            if (recTmp.length > 3) {
                rec[0] = recTmp[0];
                rec[1] = recTmp[1];
                rec[2] = recTmp[2];
                rec[3] = recTmp[3];
                flag = true;
//                if (rec[1].length()>20) System.out.println(rec[1]+" $$$ "+rec[0]+" $$$ "+rec[2]);

            } else
                System.out.println(" Есть проблемка со строкой....." + recTmp[1] + " - " + recTmp[0] + " - " + recTmp[2]);
//                Проверяем и сохраняем

            if (flag) {
                if (!mapList.containsKey(rec[1])) {
                    mapList.put(rec[1], new Rec(rec[1], rec[0], rec[2], 1));
                    count++;
                } else {
                    Rec tmp = mapList.get(rec[1]);
                    tmp.setDates(tmp.getDates() + "|" + rec[2]);
                    int t = tmp.getVizits();
                    tmp.setVizits(t + 1);
                    mapList.put(rec[1], tmp);
                    countD++;
//                System.out.println(rec[1]+" @ "+rec[0]);

//                if (rec[1].length()>40) System.out.println("!!!!!    "+rec[0]+" !!!! "+ rec[1]);
                }
            }
        }
        bfro.close();


        BufferedWriter bfrw = new BufferedWriter(new FileWriter("c:\\MaxTest\\dataOut.csv"));
        //         перебираем получившийся массив и показываем что насобирали
        var mass = mapList.values();
        bfrw.write("Итого строк обработано - " + count + ";;;");
        bfrw.newLine();
        bfrw.write("В них повторов - " + countD + ";;;");
        bfrw.newLine();
        bfrw.newLine();

        for (Rec tmp : mass) {
            bfrw.write(tmp.getVizits() + ";" + tmp.getTelnum() + ";" + tmp.getDates() + ";" + tmp.getAdress() + ";");
            bfrw.newLine();
            System.out.println(tmp.getVizits() + " " + tmp.getTelnum() + " " + tmp.getDates() + " " + tmp.getAdress());
        }
        bfrw.close();


    }
}

class Rec {
    private String telnum;
    private String adress;
    private String dates;
    private Integer vizits;

    public Rec(String telnum, String adress, String dates, Integer vizits) {
        this.telnum = telnum;
        this.adress = adress;
        this.dates = dates;
        this.vizits = vizits;
    }

    public String getTelnum() {
        return telnum;
    }

    public String getAdress() {
        return adress;
    }

    public String getDates() {
        return dates;
    }

    public Integer getVizits() {
        return vizits;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setVizits(Integer vizits) {
        this.vizits = vizits;
    }
}