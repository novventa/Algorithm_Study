package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        int N = Integer.parseInt(st.nextToken());

        int kim = Integer.parseInt(st.nextToken());

        int lim = Integer.parseInt(st.nextToken());

        int cnt = 0;

        // 라운드 계산
        while (kim != lim) {
            cnt++;
            kim = (kim + 1) / 2;
            lim = (lim + 1) / 2;
        }

        System.out.println(cnt);

    }
}
