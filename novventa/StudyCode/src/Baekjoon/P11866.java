package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수와 몇 번째 사람을 제거할 것인지 결정하는 K 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1부터 N까지 사람을 넣을 큐 생성
        Queue<Integer> people = new LinkedList<>();
        // 제거된 사람들을 넣을 큐 생성
        Queue<Integer> exitPeople = new LinkedList<>();

        // 먼저 1부터 순서대로 큐에 사람을 넣는다.
        for(int i=1;i<N+1;i++){
            people.offer(i);
        }

        // people 큐에서 모든 사람이 제거될 떄 까지 반복한다.
        while(!(people.isEmpty())) {
            // K번째 사람 전까지 빼내고 다시 큐에 넣는다.
            for (int i = 0; i < K - 1; i++) {
                int num = people.poll();
                people.offer(num);
            }

            // K번쨰 사람을 빼내고 제거된 사람을 넣는 큐에 넣는다.
            int delPeople = people.poll();
            exitPeople.offer(delPeople);
        }

        // 출력을 위해 exitPeople 큐를 배열로 바꾼다.
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = exitPeople.poll();
        }

        // < 와 > 사이에 제거된 사람 순서대로 번호를 출력한다.
        System.out.print('<');
        for(int i=0; i<N-1; i++){
            System.out.print(answer[i] + "," + " ");
        }
        System.out.print(answer[N-1]);
        System.out.print('>');

    }
}
