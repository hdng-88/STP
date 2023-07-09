import java.io.FileInputStream;
import java.util.Scanner;

public class ChungKhoan {
    static int T, N, M;
    static int ans, soCP = 0;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\BaiTap\\lib\\input7.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // so ngay giao dich
            int beginM = sc.nextInt(); // so tien von ban dau

            nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            M = beginM; // số tiền hiện có
            calc();
            ans = M - beginM;

            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static void calc() {
        int cIdx = 0;
        int cMax = nums[0];

        while (cIdx < N - 1) {
            int minI = cIdx; // thứ tự ngày có giá thấp nhất trong khoảng xét
            int maxI = cIdx; // thứ tự ngày có giá cao nhất trong khoảng xét

            if (nums[minI] >= nums[minI + 1]) { // giá hôm nay > hôm sau
                cIdx++; // không làm gì cả
                continue;
            }

            while (nums[cIdx] < nums[++cIdx]) { // giá hôm nay < hôm sau
                cMax = nums[++maxI];
                if (cIdx == N - 1) { // ngày cuối
                    break;
                }
            }
            // mua
            soCP = M / nums[minI]; // tính số cổ phiếu
            M -= soCP * nums[minI]; // trừ đi số tiền mua cổ phiếu
            // ban
            M += soCP * cMax; // cộng vào số tiền bán cổ phiếu
            soCP = 0; // hét cổ phiếu
        }

    }
}
