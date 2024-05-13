package SumMax2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, maxAns, idxSum;
    static int[] valueSum;
    static int[][] a;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/SumMax2/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            
            a = new int[N][N];
            valueSum = new int[N*2+2];
            idxSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            maxAns = 0;
            // Tong tung hang
            for (int r = 0; r < N; r++) {
                sumOfRow(r);
            }

            
            // Tong tung cot
            
            for (int c = 0; c < N; c++) {
                sumOfCol(c);
            }
            

            // 2 duong cheo
            sumOfDiagonal();

            System.out.println(maxAns);
        }            
    }
    private static void sumOfDiagonal() {
        // TODO Auto-generated method stub
        int sumCheoChinh = 0;   
        for (int i = 0; i < N; i++) {
            sumCheoChinh += a[i][i];
        }

        if(maxAns < sumCheoChinh){
            maxAns = sumCheoChinh;
        }

        int sumCheoPhu = 0;
        for (int i = 0; i < N; i++) {
            sumCheoPhu += a[i][N-1-i];
        }

        if(maxAns < sumCheoPhu){
            maxAns = sumCheoPhu;
        }
    }
    private static void sumOfCol(int c) {
        // TODO Auto-generated method stub
        int sumCol = 0;
        for (int r = 0; r < N; r++) {
            sumCol += a[r][c];
        }

        if(maxAns < sumCol){
            maxAns = sumCol;
        }
    }
    private static void sumOfRow(int r) {
        // TODO Auto-generated method stub
        int sumRow = 0;
        for (int c = 0; c < N; c++) {
            sumRow += a[r][c]; 
        }

        if(sumRow > maxAns){
            maxAns = sumRow;
        }
    }
    
    

    
}