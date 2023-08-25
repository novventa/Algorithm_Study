package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18310 {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];

        //집의 위치 정보 저장
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int mid = N/2;	//중간값

        //집의 개수가 짝수일 때
        if(N % 2 == 0){
            //N/2에 안테나 설치시 거리의 총합 구하기
            int sum1 = 0;
            for(int i=0;i<N;i++)
                sum1 += Math.abs(arr[i] - arr[mid]);
            //N/2 - 1에 안테나 설치시 거리의 총합 구하기
            int sum2 = 0;
            mid--;
            for(int i=0;i<N;i++)
                sum2 += Math.abs(arr[i] - arr[mid]);
            //거리의 총합이 더 큰 곳에 안테나 설치
            if(sum1 > sum2)
                mid++;
        }
        bw.write(arr[mid] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
