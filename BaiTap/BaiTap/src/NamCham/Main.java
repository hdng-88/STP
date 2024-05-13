package NamCham;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, M, K, posX, posY, cr, cc, count;
    static int[] nc;
    static int[][] a, visited;

    static int[] moveR = { -1, 0, 1, 0 };
    static int[] moveC = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("BaiTap/BaiTap/src/NamCham/input.txt"));
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

            a = new int[N][M];
            visited = new int[N][M];
            nc = new int[K];

            for (int i = 0; i < K; i++) {
                nc[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    a[i][j] = sc.nextInt();
                    if (a[i][j] == 2) {
                        a[i][j] = 0;
                        posX = i;
                        posY = j;
                        visited[i][j] = 1;
                    } else {
                        visited[i][j] = 0;
                    }
                }
            }

            count = 1;
            for (int i = 0; i < K; i++) {
                do {
                    cr = posX + moveR[nc[i] - 1];
                    cc = posY + moveC[nc[i] - 1];

                    if (cr >= 0 && cr < N && cc >= 0 && cc < M) {
                        if (a[cr][cc] == 0 && visited[cr][cc] == 0) {
                            visited[cr][cc] = 1;
                            count++;
                            posX = cr;
                            posY = cc;
                        } else if (a[cr][cc] == 0 && visited[cr][cc] == 1) {
                            posX = cr;
                            posY = cc;
                        } else if (a[cr][cc] == 1) {
                            break;
                        }
                    }
                    else{
                        break;
                    }
                } while (posX >= 0 && posX < N  && posY >= 0 && posY < M );
            }
            
            System.out.println("#" + tc + " " + count);
        }
    }
}