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

public class QuanHauMaTot {
    static int n, m, Q, K, P, test_case, count;
    static P[] quanMa, quanHau, quanTot;
    static int[][] a;

    static int[] rsQ = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int[] csQ = { 0, 0, -1, 1, -1, 1, 1, -1 };

    static int[] rsK = { -1, -1, 1, 1, -2, -2, 2, 2 };
    static int[] csK = { -2, 2, -2, 2, -1, 1, 1, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "Lesson3\\BaiTap\\lib\\input9.txt"));

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        test_case = 0;

        while (n != 0 && m != 0) {
            test_case++;
            count = 0;
            a = new int[n][m];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = 0;
                }
            }
            Q = sc.nextInt();
            quanHau = new P[Q];
            for (int i = 0; i < Q; i++) {
                quanHau[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);
                a[quanHau[i].x][quanHau[i].y] = 1;
            }

            K = sc.nextInt();
            quanMa = new P[K];
            for (int i = 0; i < K; i++) {
                quanMa[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);
                a[quanMa[i].x][quanMa[i].y] = 2;
            }

            P = sc.nextInt();
            quanTot = new P[P];
            for (int i = 0; i < P; i++) {
                quanTot[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);
                a[quanTot[i].x][quanTot[i].y] = 3;
            }

            for (int i = 0; i < quanHau.length; i++) {
                int r = quanHau[i].x;
                int c = quanHau[i].y;
                for (int j = 0; j < 8; j++) {
                    int cr = r + rsQ[j];
                    int cc = c + csQ[j];
                    while (cr >= 0 && cr < n && cc >= 0 && cc < m) {
                        if (a[cr][cc] == 0 || a[cr][cc] == -1) {
                            a[cr][cc] = -1;
                        } else {
                            break;
                        }
                        cr = cr + rsQ[j];
                        cc = cc + csQ[j];
                    }
                }
            }

            for (int i = 0; i < quanMa.length; i++) {
                int r = quanMa[i].x;
                int c = quanMa[i].y;
                for (int j = 0; j < 8; j++) {
                    int cr = r + rsK[j];
                    int cc = c + csK[j];

                    if (cr >= 0 && cr < n && cc >= 0 && cc < m && a[cr][cc] == 0) {
                        a[cr][cc] = -1;
                    }
                }
            }

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == 0) {
                        count++;
                    }
                }
            }

            System.out.println("Board " + test_case + " has " + count + " safe squares.");

            n = sc.nextInt();
            m = sc.nextInt();
        }

    }
}
