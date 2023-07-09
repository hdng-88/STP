import java.io.FileInputStream;
import java.util.Scanner;

public class TroChoiDienSo {
    static int T, N;
    static int[][] a;
     public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "/workspaces/STP/Lesson3/BaiTap/lib/input3.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            a = new int[N][N];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = 0;
                }
            }

            int num = 1;
            a[0][N / 2] = num;

            int i = 0;
            int j = N / 2;

            while (num < (N * N)) {
                i = (i == N - 1) ? 0 : ++i;
                j = (j == 0) ? (j += (N - 1)) : --j;
                if (a[i][j] == 0) {
                    a[i][j] = ++num;
                } else {
                    i = (i == 0) ? N - 2 : ((i == 1) ? N - 1 : i - 2);
                    j = (j == N - 1) ? 0 : ++j;
                    a[i][j] = ++num;
                }
            }

            System.out.println("#" + test_case);
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.print(a[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}
