package OneTwoThree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, Q, ans, soNguoi;
    static int[] out, aQ, select;
    static int[][] a, start, end;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Array\\src\\OneTwoThree\\input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            Q = sc.nextInt();

            out = new int[N];
            aQ = new int[N];

            for (int i = 0; i < Q; i++) {
                select = new int[4];
                for (int j = 0; j < N; j++) {
                    aQ[j] = sc.nextInt();
                    if (out[j] == 0) {
                        select[aQ[j]] = 1;
                    }
                }

                int sum = 0;
                for (int j = 1; j < 4; j++) {
                    sum += select[j];
                }

                if(sum == 2){
                    if(select[1] == 1 && select[2] == 1){
                        for (int j = 0; j < N; j++) {
                            if(out[j] == 0 && aQ[j] == 1){
                                out[j] = 1;
                            }
                        }
                    }
                    else if(select[1] == 1 && select[3] == 1){
                        for (int j = 0; j < N; j++) {
                            if(out[j] == 0 && aQ[j] == 3){
                                out[j] = 1;
                            }
                        }
                    }
                    else if(select[3] == 1 && select[2] == 1){
                        for (int j = 0; j < N; j++) {
                            if(out[j] == 0 && aQ[j] == 2){
                                out[j] = 1;
                            }
                        }
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                if(out[i] == 0){
                    System.out.print((i+1) + " ");
                }
            }
            System.out.println();
        }
    }
}