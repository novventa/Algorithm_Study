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
        // 종이 크기
        N = Integer.parseInt(br.readLine());
        // 종이 2차원 배열
        map = new int[N][N];
        // 종이 정보 입력받기
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 자르기
        cut(0,0,N);
        // 흰색 파란색 종이 갯수 출력
        System.out.println(white);
        System.out.println(blue);
    }

    private static void cut(int row, int col, int size) {
        // 자른 색종이가 모두 같은 색인지 체크
        if(check(row,col,size)){
            // 흰색이면 흰 색종이 증가
            if(map[row][col]==0)
                white++;
            // 파란색이면 파란 색종이 증가
            else
                blue++;
            return;
        }
        // 종이 반으로 자르기
        int cutSize = size / 2;

        // 1,2,3,4 분면으로 자르기
        cut(row,col,cutSize);
        cut(row,col+cutSize,cutSize);
        cut(row+cutSize,col,cutSize);
        cut(row+cutSize,col+cutSize,cutSize);

    }

    private static boolean check(int row, int col, int size) {
        // 현재 위치의 색 저장
        int color = map[row][col];

        // 나머지 칸들과 같은 색인지 비교하기
        for(int r=row;r<row+size;r++){
            for(int c=col;c<col+size;c++){
                // 다른 색이 나오면 false 반환
                if(map[r][c] != color)
                    return false;
            }
        }
        // 같으면 true 반환
        return true;

    }
}
