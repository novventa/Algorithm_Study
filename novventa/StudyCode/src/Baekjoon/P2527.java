package Baekjoon;

import java.util.Scanner;

public class P2527 {

// 총 4번의 테스트 케이스 직사각형 2개의 좌하 우상 좌표가 각각 2개씩 주어진다.
// 2개의 직사각형이 겹치는 경우, 변과 변이 맞닿는 경우, 점이 맞닿는 경우 만나지 않는 경우
// 경우가 가장 적은 것부터 하나씩 확인하고
// 가장 많은 경우의 수가 있는 상태는 여사건으로 처리한다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 총 4번 반복해야한다.
        for(int t=1;t<=4;t++){
            // 8개의 변수 입력받기
            // 직사각형 1의 좌하 우상 좌표
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 직사각형 2의 좌하 우상 좌표
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            // 점이 맞닿는 경우
            if((x1==p2 && y2==q1) || (x1==p2 && y1==q2) || (x2==p1 && y1==q2) || (x2==p1 && y2==q1)) {
                System.out.println("c");
            }else if (x1 == p2 || x2 == p1) {
                // x 좌표가 일치하는 경우 (즉, 세로로 겹치는 경우)
                if (!(y2 < q1 || y1 > q2)) {
                    System.out.println("b");
                } else {
                    System.out.println("d");
                }
            } else if (y1 == q2 || y2 == q1) {
                // y 좌표가 일치하는 경우 (즉, 가로로 겹치는 경우)
                if (!(x2 < p1 || x1 > p2)) {
                    System.out.println("b");
                } else {
                    System.out.println("d");
                }
                // 겹치지 않는 경우
            } else if(p1>x2||q1>y2||p2<x1||q2<y1){
                System.out.println("d");
                // 겹치는 부분이 직사각형인 경우
            } else {
                System.out.println("a");
            }
        }
    }
}