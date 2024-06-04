package LadderGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static int T, N, B, M, ans, x, y, haveAns;
    static int[] countStart, countEnd;
    static int[][] a, start, end;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Array\\src\\LadderGame\\input.txt"));

        Scanner sc = new Scanner(System.in);

        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            
            N = sc.nextInt();
            B = sc.nextInt()-1;
            M = sc.nextInt();

            a = new int[N][N];
            start = new int[N][N];
            end = new int[N][N];

            countStart = new int[N];
            countEnd = new int[N];

            for (int i = 0; i < M; i++) {
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                start[x][countStart[x]++] = y;

                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                end[x][countEnd[x]++] = y;
            }

            haveAns = 0;
            for (int c = 0; c < N; c++) {
                int cc = c, cr = 0;
                while(cr<N) {
                    for (int tmpC = 0; tmpC < countStart[cr]; tmpC++) {
                        if(start[cr][tmpC] == cc){
                            cc = end[cr][tmpC];
                            break;
                        }
                        else if(end[cr][tmpC] == cc){
                            cc = start[cr][tmpC];
                            break;
                        }
                    }
                    cr++;
                    if(cr == N-1 && cc == B){
                        System.out.println("#" + test_case + " " + (c+1));
                        haveAns = 1;
                        break;
                    }
                }
                if(haveAns == 1) break;
            }
        }
    }
}