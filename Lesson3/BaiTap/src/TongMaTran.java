import java.io.FileInputStream;
import java.util.Scanner;

public class TongMaTran {
    static int T, N, tongHang, tongCot, tongDc, tongMax;
    static int[][] a;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson3\\BaiTap\\lib\\input1.txt"));

        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            a = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            tongHang = tongCot = tongDc = tongMax = 0;
            //tongHang
            for (int r = 0; r < a.length; r++) {
                for (int c = 0; c < a.length; c++) {
                    tongHang += a[r][c];
                }
                if(tongHang > tongMax){
                    tongMax = tongHang;
                }
                tongHang = 0;
            }

            //tongCot
            for (int c = 0; c < a.length; c++) {
                for (int r = 0; r < a.length; r++) {
                    tongCot += a[r][c];
                }
                if(tongCot > tongMax){
                    tongMax = tongCot;
                }
                tongCot = 0;
            }

            //tongCheo
            for (int r = 0; r < a.length; r++) {
                tongDc += a[r][r];
                
            }

            if(tongDc > tongMax){
                tongMax = tongDc;
            }

            tongDc = 0;
            for (int r = N-1; r >=0; r--) {
                tongDc += a[r][N-1-r];
            }

            if(tongDc > tongMax){
                tongMax = tongDc;
            }

            //In ket qua
            System.out.println("#" + test_case + " " + tongMax);
        }
    }
}
