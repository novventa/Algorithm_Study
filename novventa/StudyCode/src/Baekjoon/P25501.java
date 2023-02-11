package Baekjoon;

import java.io.*;

public class P25501 {

    static int cnt; // 카운터를 전역변수로 선언

    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r)
            return 1;
        else if(s.charAt(l) != s.charAt(r)) {
            return 0;
        }else{
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 횟수 입력받기
        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            cnt = 0;    // 카운터 초기화
            // 재귀함수 실행 및 출력
            System.out.println(isPalindrome(br.readLine()) + " " + cnt);

        }
    }
}
