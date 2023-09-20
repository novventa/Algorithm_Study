package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P1644 {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    //N < 2이면 N 이하의 소수가 존재하지 않으므로 0 출력하고 종료
        if (N < 2)
    {
        System.out.println(0);
        return;
    }

    //N 이하의 소수에 대한 arraylist
    ArrayList<Integer> prime = new ArrayList<>();
    checkNum(prime, N);

    //정답 구하고 출력
        System.out.println(count(prime, N));
}

    //two pointers 를 이용해서 연속된 소수의 누적합을 오버헤드 없이 갱신
    static int count(ArrayList<Integer> prime, int N) {
        int left, right;
        int cnt;
        int sum;

        left = 0;
        right = 0;
        cnt = 0;
        sum = prime.get(0);

        while (left <= right)
        {
            if (sum == N)
            {
                cnt++;
                if (right + 1 == prime.size())
                    break;
                sum -= prime.get(left++);
                sum += prime.get(++right);
            }
            else if (sum < N)
            {
                if (right + 1 == prime.size())
                    break;
                sum += prime.get(++right);
            }
            else
                sum -= prime.get(left++);
        }

        return cnt;
    }

    //에라토스테네스의 체
    static void checkNum(ArrayList<Integer> num, int N)
    {
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++)
        {
            if (isPrime[i])
                continue;

            num.add(i);

            // 소수의 배수들을 모두 걸러낸다
            for (int j = 1; i * j <= N; j++)
                isPrime[i * j] = true;
        }
    }
}