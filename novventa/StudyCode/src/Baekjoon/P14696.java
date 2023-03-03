package Baekjoon;

import java.util.Scanner;

public class P14696 {
    public static void main(String[] args) {
        // 딱지의 모양을 숫자로 입력받고 종류와 갯수를 배열에 저장한다.
        // 조건에 따라 승 패 무승부를 가린다.

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 라운드 수 입력받기
        int T = sc.nextInt();
        // 라운드 수만큼 반복
        for(int tc=0;tc<T;tc++){

            // 별 동그라미 네모 세모
            // 4    3    2   1

            // 인덱스를 그대로 사용하기 위해 크기 5로 생성
            int[] A = new int[5];
            int[] B = new int[5];

            // 승자를 일단 A로 가정한다.
            char winner = 'A';

            // A가 낼 딱지의 갯수를 입력받는다.
            int aN = sc.nextInt();
            // 그 수만큼 딱지 종류와 갯수를 배열에 저장한다.
            for(int i=0;i<aN;i++){
                int shape = sc.nextInt();
                A[shape]++;
            }
            // B가 낼 딱지의 갯수를 입력받는다.
            int bN = sc.nextInt();
            // 그 수만큼 딱지 종류와 갯수를 배열에 저장한다.
            for(int i=0;i<bN;i++){
                int shape = sc.nextInt();
                B[shape]++;
            }
            // 게임 승리 조건에 따라 승패를 가린다.
            // 별이 기준일 때
            if(A[4] != B[4]) {
                if (A[4] < B[4]){
                    winner = 'B';
                }
                // 동그라미가 기준일 때
            } else {
                if(A[3] != B[3]){
                    if(A[3]<B[3]){
                        winner = 'B';
                    }
                    // 네모가 기준일 때
                }else{
                    if(A[2] != B[2]){
                        if(A[2] < B[2]){
                            winner = 'B';
                        }
                        // 세모가 기준일 때
                    }else{
                        if(A[1] != B[1]) {
                            if (A[1] < B[1]) {
                                winner = 'B';
                            }
                            // 모두 같다면 무승부
                        } else{
                            winner = 'D';
                        }
                    }
                }
            }
            // 출력
            System.out.println(winner);

        }
    }
}
