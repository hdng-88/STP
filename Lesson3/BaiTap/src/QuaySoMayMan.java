import java.io.FileInputStream;
import java.util.Scanner;

public class QuaySoMayMan {
    static int T, maxScore;
    static int[][] a, temp1, temp2;

    static int[] pull = { -2, -1, 1, 2 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input7.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            a = new int[7][3];
            temp1 = new int[3][3];
            temp2 = new int[3][3];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            for (int c = 0; c < 3; c++) {
                for (int r = 2; r <= 4; r++) {
                    temp1[r - 2][c] = a[r][c];
                    temp2[r - 2][c] = a[r][c];
                }
            }

            maxScore = 0;

            int c = 0;
            while (c < 3) {
                int beginR = 0;
                while (beginR <= 4) {
                    for (int r = 0; r < 3; r++) {
                        temp2[r][c] = a[r + beginR][c];
                    }

                    int score = calc(temp2);
                    if (score > maxScore) {
                        maxScore = score;
                    }
                    beginR++;
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        temp2[i][j] = temp1[i][j];
                    }
                }
                c++;
            }

            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    public static int calc(int[][] temp) {
        int score = 0;
        for (int r = 0; r < 3; r++) {
            if (temp[r][0] == temp[r][1] && temp[r][1] == temp[r][2] && temp[r][2] == 7) {
                score += 100;
            } else if (temp[r][0] == temp[r][1] && temp[r][1] == temp[r][2] && temp[r][2] != 7) {
                score += (10 * temp[r][0]);
            } else {
                score += (temp[r][0] + temp[r][1] + temp[r][2]);
            }
        }
        return score;
    }

}
