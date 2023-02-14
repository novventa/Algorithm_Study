package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
    public static void main(String[] args) throws IOException {

        // BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 정수로 이루어진 Queue 자료구조 선언
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 정수 N까지 queue에 넣기
        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        // 큐의 사이즈가 2가 될 때 까지 반복
        while(queue.size()>1){
            // 제일 처음 들어온 수를 빼낸다.
            queue.poll();
            // 그 다음 제일 앞에 있는 수를 변수에 저장한다.
            int num = queue.poll();
            // 그 수를 뒤에 새로 추가한다.
            queue.offer(num);
        }
        // 마지막으로 큐에서 남은 숫자를 출력한다.
        System.out.println(queue.poll());

    }
}
