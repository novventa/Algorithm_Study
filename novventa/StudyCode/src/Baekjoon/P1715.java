package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    // 우선순위 큐 사용
    // 더한 값을 바로 다음 값과 더해주어야 하기 때문에
    // 또한 오름차순으로 정렬된 상태에서 계산해야
    // 시간을 줄일 수 있다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 개수 입력받기
        int N = Integer.parseInt(br.readLine());
        // 우선순위 큐 선언
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        // 카드 갯수들 입력받기
        for(int i=0;i<N;i++){
            cards.add(Integer.parseInt(br.readLine()));
        }
        // 비교 횟수
        int sum = 0;
        // 카드 묶음 2개부터 비교 가능하므로
        while(cards.size() > 1){
            // 첫번째 카드 갯수와 두번째 카드 갯수를 꺼내서
            int card1 = cards.poll();
            int card2 = cards.poll();
            // 더해주고
            sum += card1 + card2;
            // 다시 우선순위 큐에 넣는다.
            cards.add(card1+card2);
        }
        // 출력
        System.out.println(sum);

    }
}
