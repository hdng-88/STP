package XepHinh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int T, N, x, y, cr, cc, nextX, nextY, nextVal, count;
    static boolean check;
    static int[][] a;

    static int[] moveR = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] moveC = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/BaiTap/BaiTap/src/XepHinh/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            sc.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();     
                }
            }
        }
    }
}
