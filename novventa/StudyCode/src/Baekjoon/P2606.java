package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    
    static int[][] Node;
    // 노드에 방문했는지 체크하는 배열
    static boolean[] isVisited; 
    // 이어져 있는 노드의 수를 세기 위한 변수
    static int cnt = 0;
    // 노드의 갯수
    static int com;
    // 간선의 갯수
    static int pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 갯수 입력받기
        com = Integer.parseInt(br.readLine());
        // 간선의 갯수 입력받기
        pair = Integer.parseInt(br.readLine());
        // 노드들을 저장할 배열 생성
        Node = new int[com+1][com+1];
        // 노드에 방문했었는지를 저장할 배열 생성
        isVisited = new boolean[com+1];
        // 간선의 수 만큼 반복하기
        for (int i = 0; i < pair; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             // 노드들의 정보 입력받기
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             // 방향성이 없기때문에 대칭으로 해도 된다
             Node[a][b] = 1;
             Node[b][a] = 1;
             
        }
        // 1번부터 DFS 시작
        dfs(1);
        // 자기 자신을 제외하고
        System.out.println(cnt-1);

    }


    public static void dfs(int root) {
        // 1번 방문(감염)
        isVisited[root] = true;    
        // 방문한 노드 수 증가
        cnt++;    
        // 노드 개수만큼 반복
        for (int i = 0; i <= com; i++) {  
            //node[root][i] == 1 : 1번과 연결된 노드라면     
            //!isVisited[i] : i번 노드에 방문한 적 없으면
            if (Node[root][i] == 1 && !isVisited[i]) {    
                // i번 노드 방문처리
                dfs(i);           
            }
        }
    }

}