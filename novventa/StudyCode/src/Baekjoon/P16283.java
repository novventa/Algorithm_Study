package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int a, b, n, w, ans = -1;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            if (a * i + b * (n - i) == w) {
                ans = i;
                for (int j = i + 1; j < n; j++) {
                    if (a * j + b * (n - j) == w) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if (ans == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans + " " + (n - ans));
        }
    }
}
