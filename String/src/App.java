public class App {
    public static void main(String[] args) throws Exception {
        String s1 = "java string split method by viettuts";
        String[] words = s1.split("\\s");//tach chuoi dua tren khoang trang
        //su dung vong lap foreach de in cac element cua mang chuoi thu duoc
        for (String w : words) {
         System.out.println(w);     //  java
                                    //  string
                                    //  split
                                    //  method
                                    //  by
                                    //  viettuts
        }
    }
}
