package VuotChuongNgaiVat;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, N, cPosX, cPosY, soBuoc, idxMin, idxHigher;
    static boolean  flag;
    static int[] higherX, higherY;
    static int[][] a;

    static int[] rs = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] cs = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Array/src/VuotChuongNgaiVat/input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            cPosX = sc.nextInt();   //Vị trí hàng hiện tại
            cPosY = sc.nextInt();   //Vị trí cột hiện tại

            a = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            soBuoc = 0;
            do {
                // Mỗi lần lặp lại là cầm khởi tạo lại dòng ở dưới để reset lại giá trị, tránh bị so sánh với giá trị cũ.
                idxHigher = 0;          
                higherX = new int[10];  // lưu vị trí hàng có giá trị lớn hơn điểm đang đứng
                higherY = new int[10];  // lưu vị trí cột có giá trị lớn hơn điểm đang đứng

                int cr, cc;
                for (int i = 0; i < 8; i++) {
                    cr = cPosX + rs[i];
                    cc = cPosY + cs[i];

                    if (cr >= 0 && cr < N && cc >= 0 && cc < N && a[cr][cc] > a[cPosX][cPosY]) {    // check biên và giá trị có lớn hơn điểm xét hay không 
                        higherX[idxHigher] = cr;    // gán vị trí hàng vào mảng 
                        higherY[idxHigher] = cc;    // gán vị trí cột vào mảng
                        idxHigher++;                // tăng idx lên
                    }   
                }

                if(idxHigher > 0){  // tức là có điểm có giá trị cao hơn điểm đang đứng
                    // giờ là sẽ đi tìm từ 0 -> idxHigher xem idx nào có vị trí higherX, higherY đem lại giá trị nhỏ nhất trong mảng
                    idxMin = 0;     // tạm khởi đầu cho là idx = 0
                    int currentMin, value; 

                    for (int j = 1; j < idxHigher; j++) { // vì idxMin khởi tại bằng 0 rồi nên sẽ xét các idx từ 1 -> idxHigher
                        currentMin = a[higherX[idxMin]][higherY[idxMin]];   // giá trị min hiện tại nhỏ nhất
                        value = a[higherX[j]][higherY[j]];                  // giá trị được so sánh

                        if(value < currentMin){ // nếu giá trị so sánh nhỏ hơn 
                            idxMin = j;         // thì gán lại idxMin 
                        }
                    }

                    // đến đây là sau khi đã duyệt hết và có idxMin rồi thì gán lại toạ độ hàng cột vào cPosX, cPosY và cộng 1 bước
                    cPosX = higherX[idxMin];
                    cPosY = higherY[idxMin];
                    soBuoc++;
                }
            } while (idxHigher > 0); // nếu quét hết 8 hướng mà không có giá trị nào lớn hơn điểm xét thì idxHigher = 0 và thoát khỏi while

            System.out.println("#" + tc + " " + soBuoc);
        }

    }
}
