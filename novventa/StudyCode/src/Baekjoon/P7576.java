package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 토마토 상자 배열을 만들고 토마토 상태를 입력받은 뒤
// BFS를 써서 4방탐색하면서 토마토를 익힌다.
// 나중에 익지 않은 토마토가 있을 수 있으므로
// 하나씩 돌면서 확인한다.
// 모두 익는 날짜를 출력한다.


public class P7576 {
	// 토마토 상자 가로 세로 변수
    static int N, M;
    // 토마토 상자 2차원 배열
    static int[][] box;
    // 방문했는지 확인하는 배열
    static boolean[][] isVisited;
    // 상 하 좌 우 델타배열
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) {
    	// 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 상자의 가로 길이
        M = sc.nextInt(); 
        // 상자의 세로 길이
        N = sc.nextInt();
        // 토마토 상자 생성
        box = new int[N][M];
        // 방문했는지 확인하기 위한 배열 생성
        isVisited = new boolean[N][M];
        // 상자 정보 입력 받기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
            }
        }

        // BFS 수행
        int days = bfs();
        
        // 결과 출력
        if (isRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
    
    // BFS 메서드
    public static int bfs() {
    	// 지난 날짜를 저장하는 변수
        int days = 0;
        // 
        Queue<int[]> q = new LinkedList<>();

        // 익은 토마토들을 큐에 넣기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
        }

        // BFS 수행
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                // 인접한 안 익은 토마토를 큐에 추가
                for (int j = 0; j < 4; j++) {
                    int nRow = r + dRow[j];
                    int nCol = c + dCol[j];

                    // 경계 조건
                    if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                    // 방문했거나 익지 않았으면 1로 바꿔주고 방문처리
                    if (box[nRow][nCol] == 0 && !isVisited[nRow][nCol]) {
                        box[nRow][nCol] = 1;
                        isVisited[nRow][nCol] = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
         // 익은 토마토가 없으면 days 증가하지 않음
            if (!q.isEmpty()) days++; 
        }

        return days;
    }

    // 토마토가 모두 익었는지 확인하는 함수
    public static boolean isRipe() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
