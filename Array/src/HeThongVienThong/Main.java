package HeThongVienThong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, M, N, ans;
    static String a;
    static String[][] s;

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
            sc.nextLine();

            s = new String[M][N];

            for (int i = 0; i < M; i++) {
                a = sc.nextLine();
                s[i] = a.split("");
            }

            ans = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (s[i][j].equals("A")) {
                        int r = i;
                        int c = j;

                        for (int k = 0; k < 4; k++) {
                            int cr = r + rs[k];
                            int cc = c + cs[k];

                            if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc].equals("H")) {
                                s[cr][cc] = "X";
                            }
                        }
                    }

                    else if (s[i][j].equals("B")) {
                        int r = i;
                        int c = j;

                        for (int k = 0; k < 4; k++) {
                            int count = 2;
                            int cr = r;
                            int cc = c;
                            while (count-- > 0) {
                                cr += rs[k];
                                cc += cs[k];

                                if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc].equals("H")) {
                                    s[cr][cc] = "X";
                                }
                            }
                        }
                    }

                    else if (s[i][j].equals("C")) {
                        int r = i;
                        int c = j;

                        for (int k = 0; k < 4; k++) {
                            int count = 3;
                            int cr = r;
                            int cc = c;
                            while (count-- > 0) {
                                cr += rs[k];
                                cc += cs[k];

                                if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc].equals("H")) {
                                    s[cr][cc] = "X";
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(s[i][j].equals("H")){
                        ans++;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}