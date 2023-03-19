package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// ??? ?? ??? ??? ??? ??? ???? ?
// BFS? ?? 4?????? ???? ???.
// ??? ?? ?? ???? ?? ? ????
// ??? ??? ????.
// ?? ?? ??? ????.


public class P7576 {
    // ??? ?? ?? ?? ??
    static int N, M;
    // ??? ?? 2?? ??
    static int[][] box;
    // ????? ???? ??
    static boolean[][] isVisited;
    // ? ? ? ? ????
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) {
        // ??? ??
        Scanner sc = new Scanner(System.in);
        // ??? ?? ??
        M = sc.nextInt();
        // ??? ?? ??
        N = sc.nextInt();
        // ??? ?? ??
        box = new int[N][M];
        // ????? ???? ?? ?? ??
        isVisited = new boolean[N][M];
        // ?? ?? ?? ??
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
            }
        }

        // BFS ??
        int days = bfs();

        // ?? ??
        if (isRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    // BFS ???
    public static int bfs() {
        // ?? ??? ???? ??
        int days = 0;
        //
        Queue<int[]> q = new LinkedList<>();

        // ?? ????? ?? ??
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
        }

        // BFS ??
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                // ??? ? ?? ???? ?? ??
                for (int j = 0; j < 4; j++) {
                    int nRow = r + dRow[j];
                    int nCol = c + dCol[j];

                    // ?? ??
                    if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                    // ????? ?? ???? 1? ???? ????
                    if (box[nRow][nCol] == 0 && !isVisited[nRow][nCol]) {
                        box[nRow][nCol] = 1;
                        isVisited[nRow][nCol] = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
            // ?? ???? ??? days ???? ??
            if (!q.isEmpty()) days++;
        }

        return days;
    }

    // ???? ?? ???? ???? ??
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