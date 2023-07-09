package HeThongVienThong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, M, N;
    static boolean check;
    static int[] height, count, ans;
    static String[] a;

    static int[] rs = { 0, 0, 1, -1 };
    static int[] cs = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/Array/src/HeThongVienThong/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();

            a = new String[M];

            for (int i = 0; i < M; i++) {
                a[i] = sc.nextLine();
                System.out.println(a[i]);
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (a[i].charAt(j) == 'A') {
                        int r = i;
                        int c = j;

                        for (int k = 0; k < 8; k++) {
                            int cr = r + rs[k];
                            int cc = c + cs[k];

                            if (cr >= 0 && cr < M && cc >= 0 && cc < N && a[cr].charAt(cc) == 'H') {
                                // a[cr].charAt(cc) ='X';
                            }
                        }
                    }
                }
            }

        }
    }
}