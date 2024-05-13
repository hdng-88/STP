package VuotChuongNgaiVat;

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
            System.setIn(new FileInputStream("BaiTap/BaiTap/src/VuotChuongNgaiVat/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            a = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            count = 0;

            do {
                check = false;
                nextVal = 1001;
                for (int i = 0; i < 8; i++) {
                    cr = x + moveR[i];
                    cc = y + moveC[i];

                    if (cr >= 0 && cr < N && cc >= 0 && cc < N) {
                        if (a[cr][cc] > a[x][y] && a[cr][cc] < nextVal) {
                            nextVal = a[cr][cc];
                            nextX = cr;
                            nextY = cc;
                            check = true;
                        }
                    }
                }

                if (check) {
                    x = nextX;
                    y = nextY;
                    count++;
                }

            } while (check);

            System.out.println("#" + tc + " " + count);

        }
    }
}
