package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P19238 {
    static class Taxi {
        int x,y,move;

        Taxi(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    static class Passenger {
        int id, sx, sy, ex, ey;

        Passenger(){
        }
    }

    static int N, M, fuel;
    static int[][] map = new int[21][21];
    static Taxi taxi;
    static Passenger taken = null;
    static Map<Integer, Passenger> passMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int r=1;r<N+1;r++){
            st = new StringTokenizer(br.readLine());

            for(int c=1;c<N+1;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            Passenger p = new Passenger();
            p.id = i+2;
            p.sx = Integer.parseInt(st.nextToken());
            p.sy = Integer.parseInt(st.nextToken());
            p.ex = Integer.parseInt(st.nextToken());
            p.ey = Integer.parseInt(st.nextToken());

            passMap.put(p.id,p);

            map[p.sx][p.sy] = p.id;
        }

        while (!passMap.isEmpty()) {
            int toStartFuel = bfs();
            fuel -= toStartFuel;

            if(fuel<0)
                break;

            int toDestFuel = bfs();
            fuel -= toDestFuel;

            if(fuel<0)
                break;

            fuel += toDestFuel*2;
        }

        System.out.println(fuel < 0 ? -1 : fuel);

    }

    private static int bfs() {
        Queue<Taxi> q = new LinkedList<>();
        Queue<Passenger> candidates = new LinkedList<>();
        boolean[][] visited = new boolean[21][21];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int prevMove = taxi.move;
        visited[taxi.x][taxi.y] = true;
        q.add(taxi);

        while(!q.isEmpty()) {
            Taxi location = q.poll();

            if(fuel - location.move<0){
                return Integer.MAX_VALUE;
            }

            if(prevMove != location.move && !candidates.isEmpty()){
                break;
            }

            prevMove = location.move;

            if(taken == null){
                int id = map[location.x][location.y];

                if(id>1){
                    Passenger p = passMap.get(id);
                    candidates.add(p);
                }
            } else {
                if(location.x==taken.ex && location.y==taken.ey){
                    passMap.remove(taken.id);
                    taken = null;
                    taxi = new Taxi(location.x, location.y, 0);
                    return prevMove;
                }
            }

            for(int i=0;i<4;i++){
                int nr = location.x + dr[i];
                int nc = location.y + dc[i];

                if (0 < nr && nr < N+1 && 0 < nc && nc < N+1) {
                    if(map[nr][nc] != 1 && visited[nr][nc] == false) {
                        q.add(new Taxi(nr,nc, location.move+1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        if(candidates.isEmpty())
            return Integer.MAX_VALUE;

        taken = findNearest(candidates);
        taxi = new Taxi(taken.sx, taken.sy, 0);
        map[taken.sx][taken.sy] = 0;
        return prevMove;

    }

    private static Passenger findNearest(Queue<Passenger> q) {
        Passenger target = q.poll();

        while(!q.isEmpty()){
            Passenger compare = q.poll();

            if(compare.sx < target.sx)
                target = compare;
            else if(compare.sx==target.sx && compare.sy<target.sy)
                target = compare;
        }

        return target;
    }
}
