package QueueRookie_Easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N;
    static int[] height, count, ans;
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Array/src/QueueRookie_Easy/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            height = new int[N];            //chiều cao các thằng
            count = new int[N];             //số lượng các thằng cao hơn đứng trước tương ứng
            ans = new int[N];               //mảng in ra kết quả

            for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                count[i] = sc.nextInt();
            }

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(count[i] > count[j]){
                        int tmp = count[i];
                        count[i] = count[j];
                        count[j] = tmp;
                        
                        tmp = height[i];
                        height[i] = height[j];
                        height[j] = tmp;
                    }
                }
            }

            duyetViTri();

            for (int i = 0; i < N; i++) {
                System.out.print(ans[i] + " ");
            }

            System.out.println();
        }
    }

    public static void duyetViTri(){
        int lastPos = 0;                        // vị trí nhỏ nhất mà chưa được xếp chỗ
        
        for (int i = 0; i < N; i++) {
            int dem = 0;                        // đếm xem có bao nhiêu thằng cao hơn đứng trước rồi
            int cVal = height[i];               // chiều cao thằng đang xét
            int cnt = count[i];                 // số thằng cao hơn đứng trước thằng này

            for (int j = 0; j < lastPos; j++) { // xét từ thằng đầu tiên đến lastPos
                if(ans[j] > cVal){              //nếu thằng tại vị trí j của mảng ans cao hơn thằng đang xét
                    dem++;                      //thì dem+1
                }
                if(dem>cnt){                    //nếu số thằng cao hơn đứng trước vượt quá yêu cầu, tức là 
                                                //thằng đang xét phải đứng trước cái thằng cao hơn ở vị trí j này
                    insert(cVal, j);            //cho thằng đang xét đứng vào vị trí j và đẩy thằng cao hơn xuống vị trí j+1
                    lastPos++;                  //vị trí còn trống nhỏ nhất tăng thêm 1
                    break;                      //ra khỏi vòng for và xét thằng tiếp theo
                }
            }

            if(dem<=cnt){                       //nếu sau khi duyệt hết mà số thằng lớn hơn đứng trước chưa đạt yêu cầu hoặc bằng với yêu cầu
                ans[lastPos++] = cVal;          //thì xếp thằng đang xét vào vị trí cuối cùng nhỏ nhất còn trống và tăng vị trí đó lên 1
            }

        }
    }

    public static void insert(int val, int pos){// val : giá trị cần chèn, pos : vị trí cần chèn
        for (int i = N-1; i > pos; i--) {       // chạy từ cuối đến vị trí sau vị trí cần chèn
            ans[i] = ans[i-1];                  // gán giá trị idx sau bằng giá trị idx trước 
        }

        ans[pos] = val;                         // rồi điền giá trị vào ô cần chèn thôi
    }
}