package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P5545 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 토핑 갯수, 도우 가격, 토핑 가격, 도우 열량, 토핑 열량 입력받기
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        // 토핑 열량 오름차순 정렬
        Arrays.sort(d);
        // 최대 열량
        int maxCalories = c;
        // 피자의 가격
        int price = a;
        // 1원당 열량
        int caloriesPerWon = c / a;

        // 토핑 선택 개수를 0부터 n까지 변경해가며 최대 열량 계산
        for (int i = n - 1; i >= 0; i--) {
            int toppingCalories = d[i];
            int newCalories = maxCalories + toppingCalories;
            int newPrice = price + b;
            int newCaloriesPerWon = newCalories / newPrice;

            // 새로운 토핑 추가 시 1원당 열량이 더 높아지면 업데이트
            if (newCaloriesPerWon >= caloriesPerWon) {
                maxCalories = newCalories;
                price = newPrice;
                caloriesPerWon = newCaloriesPerWon;
            } else {
                // 더 이상 토핑 추가해도 1원당 열량이 떨어지면 종료
                break;
            }
        }

        // 출력
        System.out.println(caloriesPerWon);
    }
}