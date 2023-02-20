package Baekjoon;

import java.util.Scanner;

public class P2292 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어지므로 long 변수 선언
        long num = sc.nextLong();

        // 집 개수를 세는 최소값 변수
        int cnt = 1;
        // 몇번째 겹인지에 대한 변수
        int fold = 1;
        // 한겹에서 마지막 방의 번호
        int lastNum = 1;

        // N이 1이면 1 출력
        if(num==1)
            System.out.println(1);
        // 1이 아니면
        else{
            // 입력받은 번호가 마지막 방의 번호보다 작을 동안 반복
            while(true){
                if(num<=lastNum){
                    System.out.println(fold);
                    break;
                }
                // 겹이 늘어나면 방 갯수가 6개씩 늘어난다.
                cnt = fold*6;
                fold++;
                // 마지막 방의 번호는 이전 마지막 방 번호에 이전 겹의 방 개수를 더한 번호이다.
                lastNum += cnt;
            }
        }
    }
}
