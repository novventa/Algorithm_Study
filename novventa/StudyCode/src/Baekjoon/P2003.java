package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(arr, M));
    }

    static int twoPointer(int[] arr, int M) {
        int cnt = 0;
        int left = 0, right = 0;
        int len = arr.length;
        int sum = 0;

        while (true) {
            // M 보다 sum이 크면 값을 줄여서 M을 맞춰야 하므로 현재 startIndex의 값을 빼고 한 칸 앞으로 이동해야 한다.
            if (sum >= M) {
                sum -= arr[left++];

            } else if (right >= len) {
                break;
            } else { // M 보다 sum이 작으면 값을 늘려서 M을 맞춰야 하므로 현재 endIndex를 한 칸 앞으로 이동시키고 그인덱스의 원소 값을 더해줘야 한다.
                sum += arr[right++];
            }

            if (sum == M) {
                cnt++;
            }
        }

        return cnt;
    }
}