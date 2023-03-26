package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    static int N;
    static int[][] map;
    static int[] sel;
    static int[] nonSel;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        // 버퍼드 리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스트링토크나이저 선언
        StringTokenizer st;
        // 사람 수 입력받기
        N = Integer.parseInt(br.readLine());
        // 사람들의 정보, 선택됐는지 확인하는 배열, 선택된 사람들을 저장하는 배열
        // 선택되지 않은 사람들을 저장하는 배열, 최소값 선언
        map = new int[N][N];
        visited = new boolean[N];
        sel = new int[N/2];
        nonSel = new int[N/2];
        min = Integer.MAX_VALUE;

        // 사람들의 정보 입력받기
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 조합 메서드 실행
        combi(0,0);
        // 출력
        System.out.println(min);

    }

    // 조합 메서드
    public static void combi(int startIdx, int depth) {
        // 기저조건
        if(depth==N/2){
            int start = 0;
            int link = 0;

            // 선택된 사람들로 start 팀 능력치 계산
            start = getAbility(start, sel);

            // sel 배열의 사람들은 조합으로 구성했으므로
            // nonSel 배열에 사람 채우기
            int idx = 0;
            for(int i=0; i<N; i++){
                if(!visited[i]){
                    nonSel[idx++] = i;
                }
            }
            // 선택되지 않은 사람들로 link 팀 능력치 계산
            link = getAbility(link, nonSel);

            // 능력치 차이 구하기
            min = Math.min(min, Math.abs(start-link));
            return;
        }

        // 재귀조건
        for(int i=startIdx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = i;
                combi(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    // 팀의 능력치를 구하는 메서드
    private static int getAbility(int link, int[] team) {
        for(int r=0; r<N/2; r++){
            int a = team[r];
            for(int c=r+1; c<N/2; c++){
                int b = team[c];
                link += map[a][b] + map[b][a];
            }
        }
        return link;
    }
}
