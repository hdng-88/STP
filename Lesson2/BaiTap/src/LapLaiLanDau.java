import java.io.FileInputStream;
import java.util.Scanner;

public class LapLaiLanDau {
    static int T, N, ans;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Lesson2\\BaiTap\\lib\\input3.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();   //so luong so nguyen

            nums = new int[N]; //cac so nguyen

            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            
            // idx = -1;
            // int tmp;
            // for (int i = 0; i < nums.length - 1; i++) {
            //     tmp = SoLanLap(nums, i);
            //     if(idx == -1){
            //         if(tmp > idx){
            //             idx = tmp;
            //         }
            //     }
            //     else{
            //         if(tmp<idx && tmp!=-1){
            //             idx = tmp;
            //         }
            //     }
            // }
            // if(idx == -1){
            //     ans = -1;
            // }
            // else{
            //     ans = nums[idx];
            // }
            ans = SoLanLap(nums);
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static int SoLanLap(int[] a) {
        // for (int i = index + 1; i < a.length; i++) {
        //     if(a[i] == a[index]){
        //         return i;
        //     }
        // }
        int[] count = new int[101];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {            
            count[a[i]]++;
            if(count[a[i]] == 2){
                return a[i];
            }            
        }
        return -1;
    }
}
