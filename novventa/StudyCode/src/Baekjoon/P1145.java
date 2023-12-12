package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[5];

        int ans = 0;

        for(int i=0;i<5;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while(true){
            ans++;
            for(int i=0;i<5;i++){
                if(ans>=nums[i]&& ans%nums[i]==0)
                    cnt++;
            }

            if(cnt>2)
                break;

            cnt = 0;
        }

        System.out.println(ans);
    }
}
