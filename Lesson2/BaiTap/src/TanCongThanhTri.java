import java.io.FileInputStream;
import java.util.Scanner;

public class TanCongThanhTri {
    static int T, N;
    static long ans;
    static long[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\BaiTap\\lib\\input5.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // so luong cac nuoc

            nums = new long[N]; // so quan moi nuoc

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            ans = 0;
            for (int i = 0; i < nums.length; i++) {
                long[] cmp = new long[2];
                if (i == 0) {
                    cmp[0] = QuanDanhBai("Right", i);

                } else if (i == nums.length - 1) {
                    cmp[0] = QuanDanhBai("Left", i);

                } else {
                    cmp[0] = QuanDanhBai("Left", i);
                    cmp[1] = QuanDanhBai("Right", i);
                }

                long tmp = maxArr(cmp);
                if (tmp > ans) {
                    ans = tmp;
                }
            }

            System.out.print("#" + test_case + " " + ans);

            System.out.println();
        }
    }

    public static long maxArr(long[] a) {
        long maxVal = a[0];
        int idxMax = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxVal) {
                maxVal = a[i];
                idxMax = i;
            }
        }
        return maxVal;

    }

    public static long QuanDanhBai(String dirct, int maxI) {
        int cIdx = maxI;
        long cVal = nums[maxI];
        long res = 0;
        switch (dirct) {
            case "Right":
                while (cVal > 0 && cIdx < N - 1) {
                    cIdx++;
                    if (cVal > nums[cIdx]) {
                        if (cVal / 2 < nums[cIdx]) {
                            cVal -= nums[cIdx];
                        } else {
                            cVal += nums[cIdx];
                        }
                        res += nums[cIdx];
                    } else {
                        res += cVal;
                        cVal = 0;
                    }
                }
                break;
            case "Left":
                while (cVal > 0 && cIdx > 0) {
                    cIdx--;
                    if (cVal > nums[cIdx]) {
                        if (cVal / 2 < nums[cIdx]) {
                            cVal -= nums[cIdx];
                        } else {
                            cVal += nums[cIdx];
                        }
                        res += nums[cIdx];
                    } else {
                        res += cVal;
                        cVal = 0;
                    }
                }
                break;
            default:
                break;
        }
        return res;
    }
}
