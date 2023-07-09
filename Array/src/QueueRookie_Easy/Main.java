package QueueRookie_Easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N;
    static int[] height, count, ans;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/Array/src/QueueRookie_Easy/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            height = new int[N];
            count = new int[N];
            ans = new int[N];

            for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                count[i] = sc.nextInt();
            }

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(count[i] > count[j]){
                        int tmp = count[i];
                        count[i] = count[j];
                        count[j] = tmp;
                        
                        tmp = height[i];
                        height[i] = height[j];
                        height[j] = tmp;
                    }
                }
            }

            duyetViTri();

            for (int i = 0; i < N; i++) {
                System.out.print(ans[i] + " ");
            }

            System.out.println();
        }
    }

    public static void duyetViTri(){
        int lastPos = 0;
        
        for (int i = 0; i < N; i++) {
            int dem = 0;
            int cVal = height[i];
            int cnt = count[i];

            for (int j = 0; j < lastPos; j++) {
                if(ans[j] > cVal){
                    dem++;
                }
                if(dem>cnt){
                    insert(cVal, j);
                    lastPos++;
                    break;
                }
            }

            if(dem<=cnt){
                ans[lastPos++] = cVal;
            }

        }
    }

    public static void insert(int val, int pos){
        for (int i = N-1; i > pos; i--) {
            ans[i] = ans[i-1];
        }

        ans[pos] = val;
    }
}