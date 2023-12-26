package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16955 {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[10][10];

        for (int r = 0; r < 10; r++) {
            String str = br.readLine();
            map[r] = str.toCharArray();
        }

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (map[r][c] != '.')
                    continue;
                if (check(r, c)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);

    }

    private static boolean check(int r, int c) {

        int cnt = 0;
        for (int i = c - 1; i >= 0 && map[r][i] == 'X'; i--)
            cnt++;
        for (int i = c + 1; i < 10 && map[r][i] == 'X'; i++)
            cnt++;
        if (cnt >= 4)
            return true;

        cnt = 0;
        for (int i = r - 1; i >= 0 && map[i][c] == 'X'; i--)
            cnt++;
        for (int i = r + 1; i < 10 && map[i][c] == 'X'; i++)
            cnt++;
        if (cnt >= 4)
            return true;

        cnt = 0;
        for (int i = r + 1, j = c - 1; i < 10 && j >= 0 && map[i][j] == 'X'; i++, j--)
            cnt++;
        for (int i = r - 1, j = c + 1; i >= 0 && j < 10 && map[i][j] == 'X'; i--, j++)
            cnt++;
        if (cnt >= 4)
            return true;

        cnt = 0;
        for (int i = r + 1, j = c + 1; i < 10 && j < 10 && map[i][j] == 'X'; i++, j++)
            cnt++;
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0 && map[i][j] == 'X'; i--, j--)
            cnt++;
        if (cnt >= 4)
            return true;

        return false;
    }
}
