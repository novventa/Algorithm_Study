package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long ans = pro(B) - pro(A-1);

        System.out.println(ans);

    }

    private static long pro(long x) {
        long sum = 0;
        long y;
        long i = 1;

        while(x>0){
            if(x%2==0)
                y=x/2;
            else
                y= x/2+1;

            sum += y*i;
            x -= y;
            i *= 2;
        }

        return sum;
    }
}
