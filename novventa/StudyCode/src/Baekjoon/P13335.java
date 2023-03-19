package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13335 {
    public static void main(String[] args) throws IOException {
        // 버퍼드리더, 스트링 토크나이저 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 트럭 갯수 입력받기
        int N = Integer.parseInt(st.nextToken());
        // 다리의 길이 입력받기
        int W = Integer.parseInt(st.nextToken());
        // 다리의 최대하중 입력받기
        int L = Integer.parseInt(st.nextToken());
        // 다리에 트럭 유무를 저장할 큐
        Queue<Integer> bridge = new LinkedList<>();

        // 다리길이만큼 큐에 0 넣는다.
        // 다리 초기화 작업
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        //초기화
        int sum = 0;
        int time = 0;
        // 다음 줄 읽기 위해 다시 선언
        st = new StringTokenizer(br.readLine());
        // 첫번째 트럭 입력받기
        int truck = Integer.parseInt(st.nextToken());

        //더이상 넣을 트럭이 없을때까지 반복
        while(true) {
            // 한번 돌 때마다 시간 1 더하기
            time++;
            // 다리 맨 앞에 있는 트럭 또는 0 빼내기
            sum-=bridge.poll();
            // 새로운 트럭이 다리를 건널 수 있을 때
            if(sum+truck <= L) {
                // 트럭을 큐에 넣고
                bridge.add(truck);
                // 무게 더하기
                sum+=truck;
                // 더이상 새로운 트럭이 없으면 중단
                if(--N == 0) break;
                // 다음 트럭 입력받기
                truck = Integer.parseInt(st.nextToken());

                // 새로운 트럭이 다리를 건널 수 없을 때
            }else {
                // 0을 인자로 넣어 대기시키기
                bridge.add(0);
            }

        }
        // 다리에 남아있는 트럭들 건너는 시간 합하기
        time += bridge.size();
        // 출력
        System.out.println(time);

    }
}
