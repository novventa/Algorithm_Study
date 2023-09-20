package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P3273 {
    static int N, X, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left=0, right = N-1;
        while(left < right) {
            int sum = arr[left]+arr[right];
            if(sum == X) {    // 같다면 count
                ans++;
                left++;
                right--;
            }else if(sum > X) {    // 더 크다면
                right--;
            }else {    // 더 작다면
                left++;
            }
        }

        System.out.println(ans);
    }
}