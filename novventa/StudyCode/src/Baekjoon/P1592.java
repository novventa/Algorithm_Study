package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1592 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, L 입력받기
        // N : 사람 수
        // M : 게임이 끝나기 위한 공 받는 횟수
        // L : 홀수번 공을 받은 사람이 시계방향으로 몇번째 사람에게 던져야 하는지
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 사람의 위치와 몇 번 공을 받았는지 저장할 배열 선언
        int[] times = new int[N + 1];

        // 1번한테는 처음에 공을 준다.
        times[0] = 1;

        // 사람의 인덱스를 나타내는 변수
        int idx = 0;
        // 공 받은 횟수를 세는 변수
        int cnt = 0;
        // 사람들 중 cnt가 M이 될 때 까지 반복한다.
        while (true) {
            // 한 사람이 공을 받은 횟수가 M이 되면 break;
            if (times[idx] == M) {
                break;
            }
            // 공 받은 횟수가 홀수면
            if (times[idx] % 2 == 1) {
                // 인덱스를 다시 계산한다.
                idx = (idx + L) % N;
                // 그 위치에 있는 사람의 공 받은 횟수 더하기
                times[idx]++;
                // 공 받은 횟수도 더한다.
                cnt++;
            }
            // 공 받은 횟수가 짝수라면
            else if (times[idx] % 2 == 0) {
                // 인덱스를 다시 계산하고
                idx = ((idx - L) + N) % N;
                // 그 위치에 있는 사람의 공 받은 횟수 더하기
                times[idx]++;
                // 공 받은 횟수도 더한다.
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
    }
}
