import java.io.FileInputStream;
import java.util.Scanner;

public class XepHangTanBinh {
    static int T, N;
    static int[] ans;
    static int[][] a;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\BaiTap\\lib\\input6.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // so luong nguoi

            a = new int[2][N];
            ans = new int[N];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            Bubble_sort(a);

            duyetViTri();

            for (int n : ans) {
                System.out.print(n + " ");
            }

            System.out.println();
        }
    }

    public static void duyetViTri() {
        int lastPos = 0;
        for (int index = 0; index < N; index++) {
            int cVal = a[0][index];
            int sl = a[1][index];
            int count = 0;
            for (int i = 0; i < lastPos; i++) {
                if (ans[i] > cVal) {
                    count++;
                }
                if (count > sl) {
                    insert(i, cVal);
                    lastPos++;
                    break;
                }
            }
            if (count <= sl) {
                ans[lastPos] = cVal;
                lastPos++;
            }
        }
    }

    public static void Bubble_sort(int[][] a) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j > i; j--) {
                if (a[1][j] < a[1][j - 1]) {
                    int tmp = a[1][j];
                    a[1][j] = a[1][j - 1];
                    a[1][j - 1] = tmp;

                    int tmp2 = a[0][j];
                    a[0][j] = a[0][j - 1];
                    a[0][j - 1] = tmp2;
                }
            }
        }
    }

    public static void insert(int idx, int n) {
        for (int j = N-1; j > idx; j--) {
            ans[j] = ans[j - 1];
        }
        ans[idx] = n;
    }
}
