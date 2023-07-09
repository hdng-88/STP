package QueensKnightsAndPawns_Easy;

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
    static int m, n, Q, K, P, ans, test_case;
    static P[] posQ, posK, posP;
    static int[][] a;

    static int[] rsQ = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int[] csQ = { 0, 0, -1, 1, -1, 1, 1, -1 };

    static int[] rsK = { -1, -1, 1, 1, -2, -2, 2, 2 };
    static int[] csK = { -2, 2, -2, 2, -1, 1, 1, -1 };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        while (n != 0 && m != 0) {
            test_case++;
            ans = 0;
            a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = 0;
                }
            }

            Q = sc.nextInt();
            posQ = new P[Q];
            for (int i = 0; i < Q; i++) {
                posQ[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);

                a[posQ[i].x][posQ[i].y] = 1;
            }

            K = sc.nextInt();
            posK = new P[K];
            for (int i = 0; i < K; i++) {
                posK[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);

                a[posK[i].x][posK[i].y] = 2;
            }

            P = sc.nextInt();
            posP = new P[P];
            for (int i = 0; i < P; i++) {
                posP[i] = new P(sc.nextInt() - 1, sc.nextInt() - 1);

                a[posP[i].x][posP[i].y] = 3;
            }

            // for (int i = 0; i < n; i++) {
            // for (int j = 0; j < m; j++) {
            // System.out.print(a[i][j] + " ");
            // }
            // System.out.println();
            // }

            for (int i = 0; i < posQ.length; i++) {
                int r = posQ[i].x;
                int c = posQ[i].y;

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

            for (int i = 0; i < posK.length; i++) {
                int r = posK[i].x;
                int c = posK[i].y;

                for (int j = 0; j < 8; j++) {
                    int cr = r + rsK[j];
                    int cc = c + csK[j];

                    if (cr >= 0 && cr < n && cc >= 0 && cc < m && a[cr][cc] == 0) {
                        a[cr][cc] = -1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(a[i][j] == 0){
                        ans++;
                    }
                }
            }

            System.out.println("Board " + test_case + " has " + ans + " safe squares.");

            n = sc.nextInt();
            m = sc.nextInt();
        }
    }

}