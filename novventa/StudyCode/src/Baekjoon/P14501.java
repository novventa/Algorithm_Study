package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {
    // DP로는 못풀거 같고..
    // 부분집합으로 풀기
    // 정보 입력받고
    // 부분집합으로 모든 케이스 다 만들어보고
    // 최대값 구해서 출력
    static public int max;
    static public int n;
    static public int[][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 버퍼드리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 며칠동안 상담할지 입력받기
        n = Integer.parseInt(br.readLine());
        // 상담 정보를 저장할 배열 선언
        arr = new int[n][2];
        // 상담 정보 입력받기
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 최대 이익을 저장할 변수
        max = 0;
        // 부분집합 실행
        subSet(0,0);
        // 출력
        System.out.println(max);
    }

    // 부분집합 메서드
    static public void subSet(int day, int sum) {
        //기저조건
        if(n == day) {
            max = Math.max(max, sum);
            return;
        }

        //선택안할 경우 day 체크도 해야한다.
        if(arr[day][0] + day<=n)
            subSet(day+arr[day][0],sum+arr[day][1]);

        //선택할 경우
        subSet(day+1, sum);
    }
}