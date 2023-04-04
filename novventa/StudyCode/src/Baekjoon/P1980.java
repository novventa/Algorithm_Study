package Baekjoon;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        int t = sc.nextInt();

        int maxBurger = 0; // 먹은 햄버거의 개수
        int minTime = t; // 콜라를 마신 시간
        for (int i = 0; n * i <= t; i++) { // 타워버거를 i개 먹을 때부터 검사
            for (int j = 0; m * j <= t; j++) { // 불고기버거를 j개 먹을 때부터 검사
                int time = n * i + m * j; // 햄버거를 먹는 데 걸리는 시간
                if (time <= t) { // 총 시간 내에서 먹을 수 있으면
                    int cokeTime = t - time; // 콜라를 마신 시간 계산
                    int burger = i + j; // 먹은 햄버거의 개수 계산
                    // 먹은 햄버거의 개수가 더 많거나, 같지만 콜라를 마신 시간이 더 적으면 갱신
                    if (burger > maxBurger && cokeTime <= minTime || (burger == maxBurger && cokeTime <= minTime) || (burger < maxBurger && cokeTime < minTime)) {
                        maxBurger = burger;
                        minTime = cokeTime;
                    }
                }
            }
        }
        System.out.println(maxBurger + " " + minTime);
    }
}
