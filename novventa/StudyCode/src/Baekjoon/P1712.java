package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1712 {
    public static void main(String[] args) throws IOException {
        // 1712번 손익분기점 브론즈2


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = 0;  // A : 고정비용
        int B = 0;  // B : 가변비용
        int C = 0;  // C : 제품가격

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if(C <= B)
            System.out.println("-1");       // 제품가격이 가변비용보다 작으면 무조건 손익분기점을 넘지 못한다.
        else
            System.out.println(A/(C-B)+1);  // 손익분기점 계산을 간단히 하고 이 수식은 같아지는 지점이니
                                            // 이익이 나려면 1을 더해야 한다.
    }
}
