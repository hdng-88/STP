package XayThap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Solution
 */
public class Main {
    static int T, N, M1, M2, ans;
    static boolean check;
    static int[] a, count;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/workspaces/STP/Array/src/XayThap/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M1 = sc.nextInt();
            M2 = sc.nextInt();

            a = new int[N];
            count = new int[N];

            ans = 0; 
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(a[i]<a[j]){
                        int tmp = a[i];
                        a[i]=a[j];
                        a[j] = tmp;
                    }
                }
            }

            for (int i = 1; i < N; i++) {
                if(i<=M1){
                    count[i]++;
                }
                if(i<=M2){
                    count[i]++;
                }
            }
            int idx = 0;
            for (int i = 1; i < N; i++) {                
                while(count[i]-- > 0){
                    ans += a[idx++]*i;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}