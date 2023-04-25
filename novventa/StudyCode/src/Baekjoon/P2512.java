package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {
    // 배열을 정렬한 뒤 이분탐색을 이용하자

    static int N,M,sum,ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수
        N = Integer.parseInt(br.readLine());
        // 예산들을 저장할 배열
        arr = new int[N];
        // 예산들의 합
        sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 예산 입력받기
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 합 구하기
            sum += arr[i];
        }
        // 최대 예산
        M = Integer.parseInt(br.readLine());
        // 정렬
        Arrays.sort(arr);
        // 이분탐색으로 답 구하기
        ans = binarySearch();
        // 출력
        System.out.println(ans);
    }

    private static int binarySearch() {
        // 모든 예산을 줄 수 있으면 종료
        if(sum<=M){
            return arr[N-1];
        }
        // 시작, 끝 정의
        int start = 0;
        int end = M;
        // 시작이 끝과 작거나 같을동안 이분탐색
        while(start<=end){
            int cur = 0;
            int mid = (start+end)/2;

            for(int i=0;i<N;i++) {
                if (arr[i] > mid)
                    cur += mid;
                else
                    cur += arr[i];
            }

            if(cur>M)
                end = mid-1;
            else if(cur<M)
                start = mid+1;
            else
                return mid;
        }
        return end;
    }

}
