package VuotChuongNgaiVat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class P {
    int x, y;

    public P() {
    }

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int T, N, x, y, check, count;
    static boolean flag;
    static P cPos, nPos;
    static int[][] a;

    static int[] rs = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] cs = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/VuotChuongNgaiVat/input.txt"));
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

            cPos = new P(x, y);            
            count = 0;

            do {
                flag = false;
                check = 1001;
                for (int i = 0; i < 8; i++) {
                    int cr = cPos.x + rs[i];
                    int cc = cPos.y + cs[i];

                    if (cr >= 0 && cr < N && cc >= 0 && cc < N) {
                        if (a[cr][cc] > a[cPos.x][cPos.y] && a[cr][cc] < check) {
                            check = a[cr][cc];
                            nPos = new P(cr, cc);
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    cPos = nPos;
                    count++;
                }
            } while (flag);

            System.out.println("#" + tc + " " + count);
        }
    }
}