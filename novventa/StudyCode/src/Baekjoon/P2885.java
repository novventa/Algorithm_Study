package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2885 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        // 변수들 초기화
        // 크기, 자른 횟수, 임시 크기
        int size = 1;
        int cnt = 0;
        int tmpSize = 0;
        // 크기가 K보다 작을 동안
        // 2씩 곱해서 가장 작은 크기를 구하고
        while(size < K){
            size = size*2;
            tmpSize = size;
        }
        // 가장 작은 크기가 K보다 크면
        // K가 0보다 클 동안
        // 크기를 2로 나누면서 cnt를 1씩 증가시킨다

        while(K > 0){
            if(K>=size)
                K -= size;
            else {
                size /= 2;
                cnt++;
            }
        }

        System.out.println(tmpSize + " " + cnt);
    }

}
