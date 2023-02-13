package Baekjoon;

import java.util.Scanner;

public class P1712 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //입력값
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //손익분기점
        int result = 0;
        //총 수입과 총 비용이 같아지는 지점
        int x =0;

        if(c<=b) {
            //손익분기점이 존재하지 않을 때
            result = -1;
        }else {
            //손익 분기점은 x가 지나야 하므로 x에 1을 더해야 한다.
            result=a/(c-b)+1;
        }

        System.out.println(result);
        sc.close();

    }
}