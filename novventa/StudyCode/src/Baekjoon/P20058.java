package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P20058 {

    static int N, Q;
    static int[][] map;
    static int[] cast;
    static int length;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int sum, count;
    public static class Node {
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        length = (int)Math.pow(2, N);//2^n
        map = new int[length][length];
        for(int i = 0; i< length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cast = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< Q; i++){
            //마법사 상어가 시전한 단계
            cast[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< Q; i++){
            //격자를 나누고 시계 방향 90도 회전시킨다
            map = divide(cast[i]);
            //얼음이 있는 칸 3개 이상과 인접해있지 않은 칸은 얼음양이 1 줄어든다
            map = melt();
        }

        //남아있는 얼음의 합, 가장 큰 덩어리가 차지하는 칸의 개수
        for(int i = 0; i< length; i++){
            for(int j = 0; j< length; j++){
                if(map[i][j]==0) continue;
                sum += map[i][j];
            }
        }

        visited = new boolean[length][length];
        for(int i = 0; i< length; i++){
            for(int j = 0; j< length; j++){
                if(!visited[i][j] && map[i][j]!=0) {
                    count = Math.max(count, bfs(i, j));

                }
            }
        }

        System.out.println(sum);
        System.out.println(count);

    }

    public static int bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;

        int cnt = 1; //칸의 개수

        while(!q.isEmpty()){
            Node p = q.poll();

            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr<0 || nc<0 || nr>= length || nc>= length || visited[nr][nc] || map[nr][nc]==0) continue;

                visited[nr][nc] = true;
                cnt++;
                q.add(new Node(nr, nc));
            }
        }

        return cnt;
    }

    public static int[][] divide(int l){
        int[][] temp = new int[length][length];

        l = (int)Math.pow(2, l);

        //배열 시계 방향 90도 회전
        for(int i = 0; i< length; i+=l){
            for(int j = 0; j< length; j+=l){
                rotate(i, j, l, temp);
            }
        }

        return temp;
    }

    public static void rotate(int r, int c, int w, int[][] temp){
        for (int i=0; i<w; i++) {
            for (int j=0; j<w; j++) {
                temp[r+i][c+j] = map[r+w-1-j][c+i];
            }
        }
    }

    //얼음은 동시에 녹음
    public static int[][] melt(){

        int[][] temp = new int[length][length];
        for (int i = 0; i< length; i++)
            temp[i] = Arrays.copyOf(map[i], length); //얼음이 녹은 걸 반영해줄 배열

        for(int i = 0; i< length; i++){
            for(int j = 0; j< length; j++){

                if(map[i][j]==0) continue;

                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr<0 || nc<0 || nr>= length || nc>= length || map[nr][nc]==0) continue;

                    cnt++;
                }

                if(cnt<=2){
                    //얼음이 녹음
                    temp[i][j]--;
                }
            }
        }
        return temp;
    }
}