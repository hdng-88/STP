import java.io.FileInputStream;
import java.util.Scanner;

public class SoDep {

    static int T, n, m, x, y;
    static int[] soDep;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\BaiTap\\lib\\input2.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();   //so luong so dep
            m = sc.nextInt();   //so luong cac so dep yeu cau trong ma sp 

            soDep = new int[n]; //cac so dep
            for (int i = 0; i < soDep.length; i++) {
                soDep[i] = sc.nextInt();
            }

           //x <= ma sp <= y
            x = sc.nextInt();
            y = sc.nextInt();
            
            int ans = 0;
            for (int i = x; i <= y; i++) {
                if(checkSoDep(i, m)){
                    ans++;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }


    public static boolean checkSoDep(int n, int sl) {
        int idx = 0;
        int[] a = new int[100];

        while (n>0) {
            a[idx++] = n%10;
            n /= 10;         
        }

        int count = 0;
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < soDep.length; j++) {
                if(a[i] == soDep[j]){
                    count++;
                }
            }
        }

        if(count >= sl){
            return true;
        }else{
            return false;
        }
    }
}
