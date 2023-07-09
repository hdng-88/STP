import java.io.FileInputStream;
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

public class QuanMaDuocChon {
    static int T, N, K, M, D, x, y, count, countMax, idxMax;
    static P[] quanMa;
    static int[][] a;

    static int[] rs = { -1, -1, 1, 1, -2, -2, 2, 2 };
    static int[] cs = { -2, 2, -2, 2, -1, 1, 1, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input8.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            M = sc.nextInt();
            D = sc.nextInt();

            a = new int[N][N];
            quanMa = new P[K];

            countMax = 0;

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = 0;
                }
            }

            for (int i = 0; i < K; i++) {
                quanMa[i] = new P();
                quanMa[i].x = sc.nextInt();
                quanMa[i].y = sc.nextInt();

                a[quanMa[i].x][quanMa[i].y] = 1;
            }

            for (int i = 0; i < M; i++) {
                x = sc.nextInt();
                y = sc.nextInt();

                a[x][y] = 2;
            }

            for (int i = 0; i < D; i++) {
                x = sc.nextInt();
                y = sc.nextInt();

                a[x][y] = -1;
            }

            // in ra
            // for (int i = 0; i < a.length; i++) {
            //     for (int j = 0; j < a.length; j++) {
            //         System.out.print(a[i][j] + "\t");
            //     }
            //     System.out.println();
            // }

            // ===================
            for (int i = 0; i < K; i++) {
                int r = quanMa[i].x;
                int c = quanMa[i].y;

                count = 0;
                for (int j = 0; j < 8; j++) {
                    int cr = r + rs[j];
                    int cc = c + cs[j];

                    if (cr >= 0 && cr < N && cc >= 0 && cc < N && (a[cr][cc] == 2 || a[cr][cc] == 1)) {
                        count++;
                    }
                }
                if(count > countMax){
                    countMax = count;
                    idxMax = i;
                }
            }

            System.out.println("#" + test_case + " " + quanMa[idxMax].x + " " + quanMa[idxMax].y + " " + countMax);
        }
    }
}
