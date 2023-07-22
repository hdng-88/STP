package ToAndFro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static int T, col, row, begin;
    static String s;
    static String[][] encryptStr;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("String/src/ToAndFro/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        col = sc.nextInt();
        while (col != 0) {
            sc.nextLine();
            s = sc.nextLine();
            row = s.length() / col;

            encryptStr = new String[row][col];
            for (int r = 0; r < row; r++) {
                if (r % 2 == 0) {
                    begin = r * col;
                    for (int c = 0; c < col; c++) {
                        encryptStr[r][c] = Character.toString(s.charAt(begin + c));
                    }
                } else {
                    begin = r * col;
                    for (int c = 0; c < col; c++) {
                        encryptStr[r][c] = Character.toString(s.charAt(begin + col - 1 - c));

                    }
                }
            }

            for (int c = 0; c < col; c++) {
                for (int r = 0; r < row; r++) {
                    System.out.print(encryptStr[r][c]);
                }
            }
            System.out.println();
            col = sc.nextInt();
        }
    }
}