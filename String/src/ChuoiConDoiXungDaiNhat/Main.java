package ChuoiConDoiXungDaiNhat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Main
 */
public class Main {

    static int T, ans;
    static String s, tmpString;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/String/src/ChuoiConDoiXungDaiNhat/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            s = sc.nextLine();

            ans = 0;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j <= s.length() - i; j++) {
                    tmpString = s.substring(j, j+i);
                    if(check(tmpString)){
                        ans = i;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static boolean check(String s){
        boolean flag = true;

        int strlen = s.length();

        if(strlen % 2 == 0){
            for (int i = 0; i <= strlen/2; i++) {
                if(s.charAt(i) != s.charAt(strlen - i - 1)){
                    flag = false;
                }
            }
        }
        else{
            for (int i = 0; i < strlen/2; i++) {
                if(s.charAt(i) != s.charAt(strlen - i -1)){
                    flag = false;
                }
            }
        }

        return flag;

    }
}
