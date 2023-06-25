package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2992 {

    static int N, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        num = Integer.parseInt(s);
        N = s.split("").length; // 자릿수 개수.
        arr = new int[N];
        list = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.split("")[i]);
        }
        permutation(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
    public static void permutation(int depth) {
        if (depth == N) {
            String s = "";
            for (int i: list) { // 배열 -> 문자열 -> 정수로 변환.
                s += i;
            }
            int n = Integer.parseInt(s);
            if (num < n) { // 입력값보다 큰 수중에 최솟값 찾기.
                min = Math.min(min, n);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
