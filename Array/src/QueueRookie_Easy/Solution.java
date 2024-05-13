package QueueRookie_Easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int T, n;
    static int[] height, cnt, queue;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/QueueRookie_Easy/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            height = new int[n];
            cnt = new int[n];
            queue = new int[n];

            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                cnt[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                queue[i] = -1;
            }

            // thêm sort theo chiều cao
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (height[i] > height[j] || (height[i] == height[j] && cnt[i] > cnt[j])) { // ngoài việc xét chiều
                                                                                                // cao lớn lơn thì nếu
                                                                                                // hai thằng chiều cao
                                                                                                // bằng nhau thì ta xếp
                                                                                                // theo số thằng đứng
                                                                                                // trước từ bé đến lớn)
                        int tmp = height[i];
                        height[i] = height[j];
                        height[j] = tmp;

                        tmp = cnt[i];
                        cnt[i] = cnt[j];
                        cnt[j] = tmp;
                    }
                }
            }
            // ---------------------------------

            for (int i = 0; i < n; i++) {
                int count = cnt[i];

                for (int j = 0; j < n; j++) {
                    if (queue[j] == -1 && count == 0) {
                        queue[j] = height[i];
                        break;
                    } else if (queue[j] == -1 || queue[j] > height[i]) /*
                                                                        * bỏ dấu = ở queue[j] >= height[i]
                                                                        * vì mảng cnt chứa giá trị những thằng
                                                                        * có chiều cao LỚN HƠN đứng trước
                                                                        */
                    {
                        count--;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(); // in ra xong thì xuống dòng
        }
    }
}
