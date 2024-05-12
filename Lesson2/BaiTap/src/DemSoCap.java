import java.io.FileInputStream;
import java.util.Scanner;

public class DemSoCap {
    static int T, N, K, count, ans;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Lesson2\\BaiTap\\lib\\input1.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();   //so luong so nguyen
            K = sc.nextInt();   //cac cap so co hieu la K

            nums = new int[N]; //cac so nguyen

            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            
            ans = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[i] - nums[j] == K || (nums[i] - nums[j]) == -K){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
