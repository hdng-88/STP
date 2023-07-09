package VungBaoLonNhat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int T, H, W, M, N, ans, tmp;
    static int [][] a;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/workspaces/STP/Array/src/VungBaoLonNhat/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            H = sc.nextInt();
            W = sc.nextInt();
            M = sc.nextInt();
            N = sc.nextInt();

            a = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }                
            }

            for (int i = 0; i < M-H; i++) {
                for (int j = 0; j < N-W; j++) {
                    tmp = 0;
                    int r = 1;
                    int c = 1;

                    while (r != H) {
                        tmp += a[r][j] + a[r][j+W-1];
                        r++;
                    }

                    while (c != W) {
                        tmp += a[i][c] + a[i][c+H-1];
                        c++;
                    }

                    if(tmp > ans){
                        ans = tmp;
                    }
                }
            }            
        }
    }
}