package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {

    static int N,blue,white;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cut(int row, int col, int size) {
        if(check(row,col,size)){
            if(map[row][col]==0)
                white++;
            else
                blue++;
            return;
        }
        int cutSize = size / 2;

        cut(row,col,cutSize);
        cut(row,col+cutSize,cutSize);
        cut(row+cutSize,col,cutSize);
        cut(row+cutSize,col+cutSize,cutSize);

    }

    private static boolean check(int row, int col, int size) {
        int color = map[row][col];

        for(int r=row;r<row+size;r++){
            for(int c=col;c<col+size;c++){
                if(map[r][c] != color)
                    return false;
            }
        }
        return true;

    }
}
