package VungBaoLonNhat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    static int T, H, W, M, N, ans, tmp;
    static int [][] a;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Array/src/VungBaoLonNhat/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            H = sc.nextInt();
            W = sc.nextInt();
            M = sc.nextInt();
            N = sc.nextInt();

            a = new int[M][N];
			ans = 0;
			
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }                
            }

            for (int i = 0; i <= M-H; i++) {
                for (int j = 0; j <= N-W; j++) {
                    tmp = 0;

                    for (int k = i; k < i+H ; k++) {
                        if(a[k][j] % 2 == 0)
                            tmp += a[k][j];
                        if(a[k][j+W-1] % 2 == 0)    
                            tmp += a[k][j+W-1];
                    }

                    for (int k = j+1; k < j+W-1 ; k++) {
                        if(a[i][k] % 2 == 0)
                            tmp += a[i][k];
                        if(a[i+H-1][k] % 2 == 0)    
                            tmp += a[i+H-1][k];
                    }

                    if(tmp > ans){
                        ans = tmp;
                    }
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}