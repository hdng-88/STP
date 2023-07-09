package LogoDoiXung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N;
    static boolean checkX, checkY;
    static String ans;
    static int[][] a, ssX1, ssX2, ssY1, ssY2;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("D:\\Dung\\Code STP\\test\\STP\\Array\\Array\\src\\LogoDoiXung\\input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            a = new int[N][N];

            ssX1 = new int[N / 2][N];
            ssX2 = new int[N / 2][N];

            ssY1 = new int[N][N / 2];
            ssY2 = new int[N][N / 2];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            checkX = checkY = true;

            // so sanh truc x
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N; j++) {
                    ssX1[i][j] = a[i][j];
                }
            }
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N; j++) {
                    ssX2[i][j] = a[N - 1 - i][j];
                }
            }

            for (int i = 0; i < ssX1.length; i++) {
                for (int j = 0; j < ssX1[i].length; j++) {
                    if (ssX1[i][j] != ssX2[i][j]) {
                        checkX = false;
                    }
                }
            }

            // so sanh truc y
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N / 2; j++) {
                    ssY1[i][j] = a[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    ssY2[i][j] = a[i][N - 1 - j];
                }
            }

            for (int i = 0; i < ssY2.length; i++) {
                for (int j = 0; j < ssY2[i].length; j++) {
                    if (ssY1[i][j] != ssY2[i][j]) {
                        checkY = false;
                    }
                }
            }

            ans = checkX && checkY ? "YES" : "NO";
            System.out.println("#" + test_case + " " + ans);
        }
    }
}