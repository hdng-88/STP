import java.io.FileInputStream;
import java.util.Scanner;

public class QuanLyMang {
    static int T, N, M, ans;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Lesson2\\BaiTap\\lib\\input4.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();   //so luong phan tu

            nums = new int[1000]; //cac so nguyen

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            
            M = sc.nextInt();

            for (int i = 1; i <= M; i++) {
                String mode = sc.next();
                switch (mode) {
                    case "insert":
                        int idxI = sc.nextInt();
                        int numI = sc.nextInt();

                        for (int j = N; j > idxI; j--) {
                            nums[j] = nums[j-1];
                        }
                        nums[idxI] = numI;
                        N++;
                        break;

                    case "update":
                        int idxU = sc.nextInt();
                        int numU = sc.nextInt();

                        nums[idxU] = numU;
                        break;

                    case "delete":
                        int idxD = sc.nextInt();
                        for (int j = idxD; j < N - 1; j++) {
                            nums[j] = nums[j+1];
                        }
                        N--;
                        break;
                    default:
                        break;
                }
            }
            
            System.out.print("#" + test_case);
            for (int i = 0; i < N; i++) {
                System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }
}
