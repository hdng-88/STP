package VuotChuongNgaiVat;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution2 {
	static int T, N, x, y, count, idxMin, idxMatrix;
	static int[][] a;
	static int[] matrixX, matrixY;
	
	static int[] rs = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] cs = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Array/src/VuotChuongNgaiVat/input.txt"));

        Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			a = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			count = 0;
			do {
				idxMatrix = 0;
				matrixX = new int[10];
				matrixY = new int[10];
				
				for (int i = 0; i < 8; i++) {
					int cr = x + rs[i];
					int cc = y + cs[i];
					if (cr >= 0 && cr < N && cc >= 0 && cc < N && a[cr][cc] > a[x][y]) {
							matrixX[idxMatrix] = cr;
							matrixY[idxMatrix] = cc;
							idxMatrix++;
					}
				}
				
				if (idxMatrix > 0) {
					idxMin = 0;
					int cMin, value;
					
					for (int i = 1; i < idxMatrix; i++) {
						cMin = a[matrixX[idxMin]][matrixY[idxMin]];
						value = a[matrixX[i]][matrixY[i]];
						
						if (value < cMin) {
							idxMin = i;
						}
					}
                    x = matrixX[idxMin];
                    y = matrixY[idxMin];
                    count++;
				}
				
			} while(idxMatrix > 0);
			System.out.println("#" + tc + " " + count);
		}
	}

}
