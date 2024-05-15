package TroChoi2048;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int T, N, pos, count, cnt;
    static boolean check;
    static int[] a;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("BaiTap/BaiTap/src/TroChoi2048/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            
            check = true;
            count = 0;
            while (check) {
                cnt = 0;
                pos = N - 1;
                while (pos > 0) {
                    if (a[pos - 1] == a[pos]) {
                        cnt++;
                        a[pos - 1] *= 2;
                        if (pos != N - 1) {
                            for (int i = pos; i < N-1; i++) {
                                a[i] = a[i + 1];
                            }
                            N--;
                        } else {
                            N--;
                        }
                        pos -= 2;
                    } else {
                        pos--;
                    }
                }

                if(cnt>0){
                    check = true;
                    count++;
                }
                else{
                    check = false;
                }
            }

            System.out.println("#" + tc + " " + count + " " + a[N-1]);

        }
    }
}
