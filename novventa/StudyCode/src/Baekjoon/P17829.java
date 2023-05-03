package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17829 {
    static int N,ans;
    static StringTokenizer st;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맵 크기
        N = Integer.parseInt(br.readLine());
        // 맵 배열 선언
        map = new int[N][N];
        // 맵 입력받기
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 나누기 메서드 실행
        ans = divide(0,0,N);
        // 출력
        System.out.println(ans);

    }

    private static int divide(int row, int col, int size) {
        // 크기가 2가 되면 가장 작은 정사각형 완성
        if(size == 2){
            // 2X2 정사각형 숫자들을 저장할 배열
            int[] square = new int[4];
            int idx = 0;
            // 정사각형 숫자들 구하기
            for(int r=row;r<row+2;r++){
                for(int c=col;c<col+2;c++){
                    square[idx++] = map[r][c];
                }
            }
            // 정렬 후 두번쨰로 큰 숫자 반환
            Arrays.sort(square);
            return square[2];
        } else {
            // 가장 작은 정사각형으로 나누는 과정
            // 정사각형 숫자를 저장할 배열
            int[] square = new int[4];
            // 크키 나누기
            size /= 2;

            // 재귀로 새로운 정사각형 숫자 구하기
            square[0] = divide(row,col,size);
            square[1] = divide(row,col+size,size);
            square[2] = divide(row+size,col,size);
            square[3] = divide(row+size,col+size,size);

            // 정렬 후 두번쨰로 큰 숫자 반환
            Arrays.sort(square);
            return square[2];
        }
    }
}
