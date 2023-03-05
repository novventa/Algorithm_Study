package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10163 {
    public static void main(String[] args) throws IOException {
        // 먼저 가로세로 1001칸의 2차원 배열을 생성하고
        // 색종이가 놓이는 위치가 입력으로 주어지므로
        // 색종이가 놓이는 모든 2차원 배열 요소를 갱신하면 된다.
        // 버퍼드 리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 색종이의 갯수 입력받기
        int N = Integer.parseInt(br.readLine());
        // 색종이를 겹쳐놓을 평면 이차원배열 생성
        int[][] map = new int[1001][1001];
        // 색종이의 갯수만큼 각 색종이의 정보를 입력받기 평면에 놓기
        for(int paperNum=1; paperNum<=N; paperNum++){
            // 스트링토크나이저 선언
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 색종이의 x,y좌표 입력받기
            // 색종이가 놓인 가장 왼쪽 아래 칸의 번호와 높이 너비를 입력받는다.
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 색종이의 너비와 높이 입력받기
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            // 색종이 한 장씩 좌표와 너비 높이를 고려해 평면에 내려놓는다.
            // 겹치는 부분은 색종이 번호가 갱신된다.
            for(int r=x;r<x+width;r++){
                for(int c=y;c<y+height;c++){
                    map[r][c] = paperNum;
                }
            }
        }

        // 각 색종이가 보이는 부분의 면적을 계산하는 법은
        // 색종이 번호 하나씩 평면을 돌면서 탐색한다.
        for(int paperNum=1;paperNum<=N;paperNum++){
            // 카운팅 변수
            int cnt = 0;
            // 좌표 하나씩 탐색
            for(int r=0;r<1001;r++){
                for(int c=0;c<1001;c++){
                    if(map[r][c]==paperNum)
                        cnt++;
                }
            }
            // 출력
            System.out.println(cnt);
        }
    }
}
