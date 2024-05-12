package SumMax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, maxAns;
    static int[][] a;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/SumMax/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            
            a = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            maxAns = 0;
            for (int r = 0; r < N; r++) {
                maxOfRow(r);
            }

            for (int c = 0; c < N; c++) {
                maxOfCol(c);
            }

            maxOfDiagonal();

            System.out.println("#" + tc + " " + maxAns);
        }            
    }
    
    private static void maxOfRow(int r) {
        // TODO Auto-generated method stub
        int sumRow = 0;
        for (int c = 0; c < N; c++) {
            sumRow += a[r][c];    
        }

        if(sumRow > maxAns){
            maxAns = sumRow;
        }
    }
    
    private static void maxOfCol(int c) {
        // TODO Auto-generated method stub
        int sumCol = 0;
        for (int r = 0; r < N; r++) {
            sumCol += a[r][c];
        }

        if(sumCol > maxAns){
            maxAns = sumCol;
        }
    }

    private static void maxOfDiagonal() {
        // TODO Auto-generated method stub
        int sumDia = 0;

        //Tinh tong cheo xuoi
        for (int i = 0; i < N; i++) {
            sumDia += a[i][i];
        }

        if(sumDia > maxAns){
            maxAns = sumDia;
        }

        //Tinh tong cheo nguoc
        sumDia = 0;
        for (int i = 0; i < N; i++) {
            sumDia += a[i][N-i-1];
        }

        if(sumDia > maxAns){
            sumDia = maxAns;
        }

    }

    
}