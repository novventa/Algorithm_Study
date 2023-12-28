package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int x = -1000;
        List<Integer> ans = new ArrayList<>();

        while(x<1001){
            if(((x*x+2*A*x+B)==0) && !ans.contains(x))
                ans.add(x);
            x++;
        }

        for(int num : ans){
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
