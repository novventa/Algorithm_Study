package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] map = new char[r][c];
            for (int row = 0; row < r; row++) {
                String str = br.readLine();
                map[row] = str.toCharArray();
            }
            int count = 0;

            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c-2; col++) {
                    if (map[row][col] == '>' && map[row][col + 1] == 'o' && map[row][col + 2] == '<') {
                        count++;
                    }

                }
            }
            for (int col = 0; col < c; col++) {
                for (int row = 0; row < r-2; row++) {

                    if (map[row][col] == 'v' && map[row + 1][col] == 'o' && map[row + 2][col] == '^') {
                        count++;
                    }

                }
            }
            System.out.println(count);
        }
    }
}
