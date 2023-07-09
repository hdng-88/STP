import java.io.FileInputStream;
import java.util.Scanner;

public class QuanMaTanCong {
    static int T, N, count;
    static int[][] a, done;
    static int[] rs = { -1, -1, 1, 1, - 2, -2, 2, 2 };
    static int[] cs = { -2, 2, -2, 2, -1, 1, 1, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input5.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            sc.nextInt();

            a = new int[N][N];
            done = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                    done[i][j] = 0;
                }
            }

            count = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (a[i][j] == 2) {
                        for (int k = 0; k < 8; k++) {
                            int cr = i + rs[k];
                            int cc = j + cs[k];
                            if (cr >= 0 && cr < N && cc >= 0 && cc < N && a[cr][cc] == 1 && done[cr][cc] == 0) {
                                done[cr][cc] = 1;
                                count++;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
