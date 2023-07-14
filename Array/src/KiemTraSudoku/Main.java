package KiemTraSudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, check;
    static int[] a;
    static String[] s;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("/workspaces/STP/Array/src/KiemTraSudoku/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            s = new String[9];
            a = new int[10];

            check = 1;
            for (int i = 0; i < 9; i++) {
                s[i] = sc.nextLine();
            }

            for (int r = 0; r < 9; r++) {
                for (int i = 0; i < 10; i++) {
                    a[i] = 0;
                }
                for (int c = 0; c < 9; c++) {
                    if(s[r].charAt(c) >= '1' && s[r].charAt(c) <= '9'){
                        a[s[r].charAt(c)-'0']++;
                        if(a[s[r].charAt(c) - '0'] == 2){
                            check = 0;
                            break;
                        }
                    }
                }
            }

            for (int c = 0; c < 9; c++) {
                for (int i = 0; i < 10; i++) {
                    a[i] = 0;
                }
                for (int r = 0; r < 9; r++) {
                    if(s[r].charAt(c) >= '1' && s[r].charAt(c) <= '9'){
                        a[s[r].charAt(c)-'0']++;
                        if(a[s[r].charAt(c) - '0'] == 2){
                            check = 0;
                            break;
                        }
                    }
                }
            }

            for (int r = 0; r < 9; r+=3) {
                for (int c = 0; c < 9; c+=3) {
                    for (int i = 0; i < 10; i++) {
                        a[i] = 0;
                    }
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if(s[r+i].charAt(c+j) >= '0' && s[r+i].charAt(c+j) <= '9'){
                                a[s[r+i].charAt(c+j) - '0']++;
                                if(a[s[r+i].charAt(c+j) - '0'] == 2){
                                    check = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + check);
        }
    }
}