package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {
    // 미로찾기와 비슷한 문제
    // 맵을 입력받고
    // 너비우선탐색을 사용해
    // 4방탐색을 하며 인접한 집이 있는지 확인한다.
    // 집 갯수를 각 단지마다 세서 출력한다.
    //

    // 상 하 좌 우 델타배열
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    // 지도를 저장할 배열
    static int[][] map;
    // 방문 여부를 저장할 배열
    static boolean[][] isVisited;
    static int N; // 지도의 크기
    static int cnt; // 단지의 수
    static ArrayList<Integer> houses; // 각 단지의 집 수를 저장할 리스트

    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 지도 크기 입력받기
        N = sc.nextInt();
        // 지도를 저장할 배열 선언
        map = new int[N][N];
        // 방문여부를 저장할 배열
        isVisited = new boolean[N][N];
        // 단지의 집 갯수를 저장할 리스트
        houses = new ArrayList<>();

        // 지도 입력 받기
        for (int r = 0; r < N; r++) {
            String str = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        // 모든 좌표에 대해서 DFS 수행
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 집이 있고, 방문하지 않은 경우에만 DFS 수행
                if (map[r][c] == 1 && !isVisited[r][c]) {
                    // 현재 단지 내의 집 수 계산
                    int houseCnt = dfs(r, c);
                    // 해당 단지의 집 수를 리스트에 저장
                    houses.add(houseCnt);
                    cnt++; // 단지 수 증가
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(houses);

        // 결과 출력
        System.out.println(cnt);
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
    }

    // DFS 함수 정의
    public static int dfs(int r, int c) {
        // 현재 좌표 방문 처리
        isVisited[r][c] = true;
        // 현재 단지 내의 집 갯수
        int houseCnt = 1;
        // 4방 탐색하기
        for (int i = 0; i < 4; i++) {
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            // 경계 조건
            if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N)
                continue;
            // 집이 있고, 방문하지 않은 경우에만 DFS 수행
            if (map[nRow][nCol] == 1 && !isVisited[nRow][nCol]) {
                // 인접한 집을 계속해서 탐색하며 집 수 증가
                houseCnt += dfs(nRow, nCol);
            }
        }
        // 현재 단지 내의 집 갯수를 반환
        return houseCnt;
    }
}
