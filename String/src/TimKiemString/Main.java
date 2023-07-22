package TimKiemString;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, pos, start, ans, check;
    static String s1, s2;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("String/src/TimKiemString/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            T = sc.nextInt();
            sc.nextLine();
            s1 = sc.nextLine();
            s2 = sc.nextLine();

            start = 0;
            ans = 0;
            while (start < s2.length()) {
                pos = s2.indexOf(s1, start);
                if (pos != -1) {
                    ans++;
                    start = pos + 1;
                } else {
                    break;
                }
            }
            // ans = 0;
            // for (int i = 0; i <= s2.length() - s1.length(); i++) {
            // check = 1;
            // for (int j = 0; j < s1.length(); j++) {
            // if (s1.charAt(j) != s2.charAt(i + j)) {
            // check = 0;
            // break;
            // }

            // }
            // if (check == 1)
            // ans++;
            // }
            System.out.println("#" + tc + " " + ans);
        }
    }
}