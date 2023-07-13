package TimKiemMaTran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, M, K, minK, tmp, tmp2, x, y;
    static int[][] a;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/Array/src/TimKiemMaTran/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            a = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            minK = 10000000;
            tmp2 = 10000000;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    tmp = 0;

                    for (int k = 0; k < M; k++) {
                        int dem = 0;
                        while (dem < M) {
                            tmp += a[i + k][j + dem];
                            dem++;
                        }
                    }

                    int d = tmp - K > 0 ? tmp - K : K - tmp;

                    System.out.print(tmp + " ");

                    if (d < minK || (d == minK && tmp < tmp2)) {
                        minK = d;
                        x = i;
                        y = j;
                        tmp2 = tmp;
                    }
                }
                System.out.println();
            }
            System.out.println("#" + tc + " " + x + " " + y);
        }
    }
}