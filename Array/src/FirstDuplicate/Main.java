package FirstDuplicate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static int T, n;
    static boolean check;
    static int[] a, count;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Array/src/FirstDuplicate/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            a = new int[n];
            count = new int[n+1];

            check = false;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if(++count[a[i]] == 2){
                    check = true;
                    System.out.println("#" + tc + " " + a[i]);
                    break;
                }
            }

            if(!check){
                System.out.println("#" + tc + " -1");
            }
        }
    }
}