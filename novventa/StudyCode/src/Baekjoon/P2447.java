package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0,0,N,false);

        StringBuilder sb = new StringBuilder();

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                sb.append(arr[r][c]);
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static void star(int r, int c, int N, boolean space) {
        if(space){
            for(int row=r;row<r+N;row++){
                for(int col=c;col<c+N;col++){
                    arr[row][col] = ' ';
                }
            }
            return;
        }

        if(N==1){
            arr[r][c] = '*';
            return;
        }

        int size = N/3;
        int cnt = 0;
        for(int row=r;row<r+N;row+=size){
            for(int col=c;col<c+N;col+=size){
                cnt++;
                if(cnt==5)
                    star(row,col,size,true);
                else
                    star(row,col,size,false);
            }
        }
    }
}
