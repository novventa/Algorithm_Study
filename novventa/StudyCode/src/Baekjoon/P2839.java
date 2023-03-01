package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
    // 3킬로와 5킬로의 설탕 봉지가 있다.
    // 배달해야하는 무게가 주어지면
    // 봉지의 갯수를 최소로 할 때 몇 봉지를 가져가야 하는지 구한다.

    public static void main(String[] args) throws IOException {
        // 버퍼드 리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배달해야 하는 무게 입력받기
        int weight = Integer.parseInt(br.readLine());

        // 그리디 알고리즘 사용
        // 무게가 5로 나누어 떨어지면 바로 출력
        if (weight % 5 == 0) {
            System.out.println(weight / 5);
            // 아니라면
        } else {
            // 일단 5킬로 봉지를 최대한 사용하고
            int cnt = weight / 5;
            // 나머지 무게를 계산한다.
            // 5킬로 봉지가 0 이상일때 까지 반복
            while (cnt >= 0) {
                // 남은 무게를 저장하는 변수
                int remain = weight - (cnt * 5);
                // 남은 무게가 3으로 나누어 떨어지면 둘을 더해서 출력한다.
                if (remain % 3 == 0) {
                    System.out.println(cnt + (remain / 3));
                    return;
                }
                // 5킬로 봉지를 줄여가면서 3과 나누어 떨어지는지 알아본다.
                cnt--;
            }
            // while문을 탈출했다는 것은
            // 5킬로 봉지와 3킬로 봉지로 배달할 수 없는 무게이므로
            // -1 출력
            System.out.println(-1);
        }
    }
}
