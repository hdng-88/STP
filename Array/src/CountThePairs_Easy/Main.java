package CountThePairs_Easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, K, ans;
    static int[] a;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array\\src\\CountThePairs_Easy\\input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();

            a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(a[i] - a[j] == K){
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}