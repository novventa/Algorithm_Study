package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2485 {
    // 각각의 간격이 다른 숫자 N개를 입력받고
    // 간격을 모두 같게 하려면 최소 몇 개의 수를 추가해야하는지 구하는 문제
    // 모든 숫자의 간격을 구한 뒤 그 간격들의 최대공약수를 구해 가장 작은 간격을 구한다.
    // 가장 앞에 있는 가로수와 가장 뒤에 있는 가로수의 간격을 최대공약수로 나누고
    // 1을 빼면 추가로 심어야 할 가로수의 갯수이다.

    // 메인 메서드
    public static void main(String[] args) throws IOException {
        // 버퍼드리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가로수의 갯수 입력받기
        int N = Integer.parseInt(br.readLine());
        // 가로수들의 위치를 저장할 배열 생성
        int[] trees = new int[N];
        // 가로수들의 위치 입력받기
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        // 가로수 위치를 오름차순으로 정렬
        Arrays.sort(trees);

        // 가로수들의 간격들을 저장할 리스트 생성
        List<Integer> gaps = new ArrayList<>();
        // 간격들 저장하기
        for (int i = 1; i < N; i++) {
            gaps.add(trees[i] - trees[i-1]);
        }

        // 최대공약수를 저장할 변수, 초기값은 첫번째 간격으로 한다.
        int GCD = gaps.get(0);
        // 간격들을 하나씩 돌면서 간격들의 최대공약수 구하기
        for (int i = 1; i < gaps.size(); i++) {
            // 최대공약수 구하기
            GCD = gcd(GCD, gaps.get(i));
        }

        // 심어야 하는 최소 가로수 갯수 구하기
        // 가장 앞에 있는 가로수와 가장 뒤에 있는 가로수의 간격을 최대공약수로 나누고
        // 1을 빼면 추가로 심어야 할 가로수의 갯수이다.
        int cnt = (trees[N-1] - trees[0]) / GCD - (N-1);
        // 출력
        System.out.println(cnt);
    }

    // 최대공약수 구하는 메서드
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
