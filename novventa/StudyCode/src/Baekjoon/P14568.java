package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int s = 0;
        for (int i = 2; i < n - 1; i += 2) {
            s += (n - i - 2) / 2;
        }
        System.out.println(s);

    }
}

