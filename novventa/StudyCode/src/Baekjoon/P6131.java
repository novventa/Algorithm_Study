package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6131 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i < 501; i++) {
            for (int j = i; j < 501; j++) {
                if (Math.pow(j, 2) - Math.pow(i, 2) == n){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
