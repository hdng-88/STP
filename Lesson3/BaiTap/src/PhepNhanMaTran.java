import java.io.FileInputStream;
import java.util.Scanner;

public class PhepNhanMaTran {
    static int T, n, m, p;
    static long[][] a, b, c;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input6.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            m = sc.nextInt();
            n = sc.nextInt();
            p = sc.nextInt();

            a = new long[m][n];
            b = new long[n][p];
            c = new long[m][p];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j] = 0;
                }
            }

            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    for (int k = 0; k < n; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("#" + test_case + " ");
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
