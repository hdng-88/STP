import java.io.FileInputStream;
import java.util.Scanner;

public class MTXoanOc {
    static int T, n, m, count, cD, maxR, minR, maxC, minC;
    static int[][] a;

    static int[] dirctR = { 0, 1, 0, -1 };
    static int[] dirctC = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input2.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            a = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = 0;
                }
            }

            a[0][0] = 1;
            count = 1;
            cD = 0;
            minR = minC = 0;
            maxR = n - 1;
            maxC = m - 1;

            dienSo(0, 0, cD);
            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void dienSo(int r, int c, int cD) {

        while (count < n * m) {
            int cr = r + dirctR[cD];
            int cc = c + dirctC[cD];
            switch (cD) {
                case 0: // sang phai
                    if(cc < maxC){
                        a[cr][cc] = ++count;
                    }
                    else{
                        a[cr][cc] =  ++count;
                        cD = 1;
                        minR++;
                    }
                    break;

                case 1: // di xuong
                    if(cr < maxR){
                        a[cr][cc] =  ++count;
                    }
                    else{
                        a[cr][cc] =  ++count;
                        cD = 2;
                        maxC--;
                    }
                    break;

                case 2: // sang trai
                    if(cc > minC){
                        a[cr][cc] = ++count;
                    }
                    else{
                        a[cr][cc] =  ++count;
                        cD = 3;
                        maxR--;
                    }
                    break;

                case 3: // di len
                    if(cr > minR){
                        a[cr][cc] = ++count;
                    }
                    else{
                        a[cr][cc] =  ++count;
                        cD = 0;
                        minC++;
                    }
                    break;

                default:
                    break;
            }

            r = cr;
            c = cc;
        }
    }
}
