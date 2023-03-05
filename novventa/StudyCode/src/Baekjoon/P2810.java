package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2810 {

    // 컵홀더는 좌석의 맨 끝 2군데에는 무조건 설치되어 있고, 커플석 사이에는 없다.
    // 컵홀더의 갯수가 아닌 컵홀더에 음료를 넣을 수 있는 사람 수를 출력
    // 좌석 구성을 입력받고 한 자리씩 떼어 탐색한다.

    public static void main(String[] args) throws IOException {
        // 버퍼드리더
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 좌석 수 입력받기
        int N = Integer.parseInt(br.readLine());
        // 좌석 구성 입력받기
        String seat = br.readLine();
        // 컵홀더는 무조건 1개는 있어야 한다
        int cnt = 1;
        // 한 좌석씩 떼서 탐색
        for(int i=0; i<N; i++){
            char tmp = seat.charAt(i);
            // 일반좌석이라면
            if(tmp=='S')
                // 컵홀더 갯수 1 증가
                cnt++;
            // 커플석이라면
            else if (tmp=='L') {
                // 가운데를 건너 뛰고
                i++;
                // 컵홀더 갯수 증가
                cnt++;
            }
        }
        // 사람 수를 출력해야하므로
        // 컵홀더 수가 사람 수 보다 많으면 사람 수를 출력해야 한다.
        if(cnt>N)
            System.out.println(N);
        // 이 외엔 컵홀더의 갯수를 출력한다.
        else
            System.out.println(cnt);
    }
}
