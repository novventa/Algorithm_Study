package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14718 {
    static class Unit{
        int str;
        int dex;
        int intel;

        public Unit(int str, int dex, int intel) {
            this.str = str;
            this.dex = dex;
            this.intel = intel;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Unit[] units = new Unit[n];

        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dex = Integer.parseInt(st.nextToken());
            int intel = Integer.parseInt(st.nextToken());
            Unit unit = new Unit(str,dex,intel);
            units[i] = unit;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    int cnt = 0;

                    for (int u = 0; u < n; u++) {
                        if (units[a].str >= units[u].str && units[b].dex >= units[u].dex && units[c].intel >= units[u].intel) {
                            cnt++;
                        }
                    }

                    if (cnt >= k)
                        min = Math.min(min, units[a].str + units[b].dex + units[c].intel);
                }
            }
        }

        System.out.println(min);

    }
}
