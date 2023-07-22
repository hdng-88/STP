package HeThongPhanTichRemCua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, M, N, ans;
    static int[] a;
    static String string;
    static String[] s;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/HeThongPhanTichRemCua/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            sc.nextLine();

            a = new int[5];
            s = new String[5 * M + 1];

            for (int i = 0; i < s.length; i++) {
                s[i] = sc.nextLine();
            }

            int r  = 0, cr, c, tmpR, cc, type;
           
            while (r < M) {
                cr = 1 + r * 5;
                c = 0;
                while (c < N) {
                    tmpR = cr;
                    cc = 1 + c * 5;
                    type = 0;

                    for (int i = 0; i < 4; i++) {
                        if (s[tmpR++].charAt(cc) == '*') {
                            type++;
                        }
                    }

                    a[type]++;
                    c++;
                }
                r++;
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 5; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}