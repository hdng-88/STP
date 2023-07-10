package QuanMaDuocChon;

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
    static int T, N, K, M, D, count;
    static P ans;
    static P[] quanMa;
    static int[][] a;

    static int[] rs = { 1, 1, 2, 2,-1,-1,-2,-2 };
    static int[] cs = { 2,-2, 1,-1, 2,-2, 1,-1 };

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/Array/src/QuanMaDuocChon/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            M = sc.nextInt();
            D = sc.nextInt();

            a = new int[N][N];
            quanMa = new P[K];

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = 0;
                }
            }

            for (int i = 0; i < K; i++) {
                quanMa[i] = new P(sc.nextInt(), sc.nextInt());
                a[quanMa[i].x][quanMa[i].y] = 1;
            }

            for (int i = 0; i < M; i++) {
                a[sc.nextInt()][sc.nextInt()] = 2;
            }

            for (int i = 0; i < D; i++) {
                a[sc.nextInt()][sc.nextInt()] = 3;
            }

            for (int i = 0; i < K; i++) {
                int r = quanMa[i].x;
                int c = quanMa[i].y;
                int tmp = 0;

                for (int j = 0; j < 8; j++) {
                    int cr = r+rs[j];
                    int cc = c+cs[j];
                    
                    if(cr>=0&&cr<N&&cc>=0&&cc<N){
                        if(a[cr][cc] == 1 || a[cr][cc] == 2){
                            tmp++;
                        }
                    }

                    if(tmp>count){
                        count = tmp;
                        ans = new P(r, c);
                    }
                }
            }

            System.out.println("#" + tc + " " + ans.x + " " + ans.y + " " + count);
        }
    }
}