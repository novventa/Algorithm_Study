package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> nums = new ArrayList<>();

        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (b != a) {
                    for (int c = 1; c < 10; c++) {
                        if (c != b && c != a) {
                            nums.add(a * 100 + b * 10 + c);
                        }
                    }
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pred = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball =Integer.parseInt(st.nextToken());

            nums.removeIf(num -> !isPossible(num, pred, strike, ball));
        }

        System.out.println(nums.size());
    }

    public static boolean isPossible(int num, int pred, int strike, int ball){
        int strikeCnt = 0;
        int ballCnt = 0;

        String numStr = String.valueOf(num);
        String predStr = String.valueOf(pred);

        for (int i = 0; i < 3; i++) {
            if (numStr.charAt(i) == predStr.charAt(i)) {
                strikeCnt++;
            } else if (numStr.contains(String.valueOf(predStr.charAt(i)))) {
                ballCnt++;
            }
        }

        return strikeCnt == strike && ballCnt == ball;
    }
}
