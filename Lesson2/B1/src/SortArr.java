import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortArr {
    static int n;

    static int[] a;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(
                "D:\\OneDrive - actvn.edu.vn\\DOCUMENTS\\SIT_Java\\VS Code\\Lesson2\\B1\\src\\input.txt"));

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

        // =================Sap xep mang=====================
        //Selection_Sort(a);
        
        Arrays.sort(a);         //dung thu vien co san
        System.out.println("Mang sap xep");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }

    }

//===============CAC THUAT TOAN SAP XEP MANG===================
    public static void Bubble_sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void Selection_Sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }
    }


}
