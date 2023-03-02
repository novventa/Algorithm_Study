package Baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P11399 {
    // 인출 시간을 저장한 배열을 오름차순으로 정렬한 뒤
    // 한 사람씩 이전까지의 기다리는 시간과 인출하는데 걸리는 시간을 더하고
    // 그 합을 누적합에 더하면 최소시간이다.

    public static void main(String[] args) throws IOException {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 사람 수 입력받기
        int N = sc.nextInt();
        // 각 개인의 인출하는데 걸리는 시간을 저장할 배열
        int[] personalTime = new int[N];
        // 인출 시간 입력받기
        for(int i=0; i<N; i++){
            personalTime[i] = sc.nextInt();
        }
        // 오름차순으로 정렬
        Arrays.sort(personalTime);
        // 총 시간을 저장할 변수
        int totalTime = 0;
        // 기다리는데 걸리는 시간을 저장할 변수
        int waitingTime = 0;
        // 오름차순으로 정렬했기 때문에
        for(int i=0; i<N; i++){
            // 기다리는데 걸리는 시간에 인출 시간을 각각 더하고
            waitingTime += personalTime[i];
            // 총 시간에 다시 더해주면 걸리는 시간이 최소가 된다
            totalTime += waitingTime;
        }
        // 출력
        System.out.println(totalTime);
    }
}
