package Baekjoon;

import java.util.Scanner;

public class P16283 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, n, w, ans = -1;
        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();
        w = scanner.nextInt();

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
