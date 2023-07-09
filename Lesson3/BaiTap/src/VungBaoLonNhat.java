import java.io.FileInputStream;
import java.util.Scanner;

public class VungBaoLonNhat {
    static int T, H, W, M, N, sum, sumMax;
    static int[][] a;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input10.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            H = sc.nextInt();
            W = sc.nextInt();
            M = sc.nextInt();
            N = sc.nextInt();

            a = new int[M][N];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            sum = sumMax = 0;

            for (int beginR = 0; beginR < M - H; beginR++) {
                for (int beginC = 0; beginC < N - W; beginC++) {
                    for (int r = 0; r < H; r++) {
                        for (int c = 0; c < W; c++) {
                            if (a[r + beginR][c + beginC] % 2 == 0) {
                                sum += a[r + beginR][c + beginC];
                            }
                        }
                    }

                    if (sum > sumMax) {
                        sumMax = sum;
                    }
                    sum = 0;

                }
            }

            System.out.println("#" + test_case + " " + sumMax);
        }
    }
}
