import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class FindElmArr {
    static int n;
    static int[] a;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\B1\\src\\input.txt"));

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Mang da nhap:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();

        // =================Tim kiem mang=====================
        
        

    }

//=================CAC THUAT TOAN TIM KIEM=======================
    public static int find_linear(int[] a, int x) {

        for (int i = 0; i < a.length; i++) {
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }
}
