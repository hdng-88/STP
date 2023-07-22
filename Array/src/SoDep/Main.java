package SoDep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, n, m , x, y, ans;
    static int[] soDep;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/SoDep/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            soDep = new int[n];
            for (int i = 0; i < n; i++) {
                soDep[i] = sc.nextInt();
            }

            x = sc.nextInt();
            y = sc.nextInt();

            ans = 0;
            for (int i = x; i <= y; i++) {
                int count = 0;
                int tmp = 0;
                int cNum = i;
                while (cNum > 0) {
                    tmp++;
                    int num = cNum%10;
                    cNum /= 10;

                    for (int j = 0; j < n; j++) {
                        if(num == soDep[j]){
                            count++;
                            break;
                        }
                    }
                }

                if(count >= m){
                    ans ++;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}