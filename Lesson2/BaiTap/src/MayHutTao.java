import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MayHutTao {
    static int T, n, H, ans;
    static int[] a;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\BaiTap\\lib\\input8.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            H = sc.nextInt();

            a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }

            ans = 0;
            calc();

            System.out.println("#" + test_case + " " + ans);

        }
    }

    public static void calc() {
        for (int i = 0; i < a.length; i++) {
            int soCay = H / 3;
            int cPos = i;
            int tmp = a[i];
            int idx = 1;
            while (idx <= soCay) {
                int left = cPos - idx;
                int right = cPos + idx;
                if (left >= 0 && left < n) {
                    tmp += a[left];
                }

                if (right >= 0 && right < n) {
                    tmp += a[right];
                }

                idx++;
            }


            if(tmp > ans){
                ans = tmp;
            }
        }
    }
}
