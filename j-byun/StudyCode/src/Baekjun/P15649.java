// 백트래킹
// 15649 N과 M (1)
// 실버3

// 문제
// 자연수 N과 M이 주어짐
// 1부터 N까지의 자연수 중 중복 없이 M개를 고른 수열을 모두 구하시오

// 조건
// 1<= M <= N <= 8

// 풀이
// 백트래킹 :
// 트리 탐색 알고리즘
// 깊이우선탐색 DFS / 너비우선탐색 BFS / 최선우선탐색
// 모든 경우의 수를 고려하는 문제는 DFS
// 최단거리 구하기는 BFS

// DFS
// 트리의 바닥에 도달할 때 까지 한 쪽 방향만 타고 내려갔다가,
// 막다른 길(트리의 바닥)에 다다르면 왔던 길을 돌아가서 다른 방향으로 간다
// ... 목표지점(원하는 해)이 나올 떄 까지 반복
// => 재귀함수 or 스택으로 구현 가능

// 이전에 출력된 숫자인지 확인해 줄 boolean 배열 visit
// 출력할 값을 담을 int 배열 arr
// 트리의 깊이를 나타낼 int depth

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];

        dfs(0);

        System.out.println(sb);

    }

    private static void dfs (int depth) {
        // arr배열의 size가 m이 됐다면 배열 원소들 차례로 출력하고 return
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            // 해당 노드를 방문하지 않았다면...
            if (!visit[i]) {
                visit[i] = true; // 해당 노드를 방문상태로 바꿔주고
                arr[depth] = i + 1; // 현재 깊이를 index로 해서 i+1 저장 (숫자는 1~n, 인덱스는 0~n-1까지라서)
                dfs(depth + 1); // depth 1 증가시키며 재귀호출 -> 다음 자식노드 방문
                visit[i] = false; // 자식노드 방문 끝나고 돌아오면 현재 노드를 방문하지 않은 상태로 변경 (인덱스 ++ 됐을 때 다시 방문하러 와야되니까)

            }
        }
        
    }

}


