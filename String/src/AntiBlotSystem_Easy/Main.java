package AntiBlotSystem_Easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static int T, tmp;
    static String s;
    static String[] element;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("STP/String/src/AntiBlotSystem_Easy/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            s = sc.nextLine();
            element = new String[3];

            element[0] = s.substring(0, s.indexOf(" + "));
            element[1] = s.substring(s.indexOf(" + ") + 3, s.indexOf(" = "));
            element[2] = s.substring(s.indexOf(" = ") + 3);


            for (int i = 0; i < 3; i++) {
                if(element[i].indexOf("machula") != -1){
                    if(i == 2){
                        tmp = parseInt(element[0]) + parseInt(element[1]);
                        element[2] = tmp + "";
                    }
                    else{
                        tmp = parseInt(element[2]) - parseInt(element[2-i-1]);
                        element[i] = tmp + "";
                    }
                }
            }

            System.out.println(element[0] + " + " + element[1] + " = " + element[2]);
        }
    }

    public static int parseInt(String s){
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num = num*10 + (s.charAt(i) - '0');
        }
        return num;
    }
}