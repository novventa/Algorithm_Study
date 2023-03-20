package SWEA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P5658{
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트케이스 입력받기
        int T = sc.nextInt();
        // 테스트케이스만큼 반복
        for (int tc = 1; tc <= T; tc++) {
            // 문자열 크기 입력받기
            int N = sc.nextInt();
            // 몇번째로 큰 수 출력할지 입력받기
            int K = sc.nextInt();
            // 문자열 입력받기
            String num = sc.next();
            // 16진수들을 저장할 해시셋
            Set<String> set = new HashSet<>();

            // 회전 수
            for (int i = 0; i < N / 4; i++) {
                // 한 변의 길이
                for (int j = 0; j < 4; j++) {
                    // 변마다 길이 구하기
                    // substring으로 잘라서 16진수로 만들기
                    String str = num.substring(j * (N / 4), (j + 1) * (N / 4));
                    // 16진수 저장하기
                    set.add(str);
                }
                // 회전하기
                num = num.charAt(num.length() - 1) + num.substring(0, num.length() - 1);
            }
            // Set에 저장된 16진수들을 10진수로 바꾸고 arr배열에 저장하기
            int[] arr = new int[set.size()];
            int i = 0;
            for (String s : set) {
                arr[i++] = Integer.parseInt(s, 16);
            }
            // 오름차순으로 정렬
            Arrays.sort(arr);
            // 출력
            System.out.println("#" + tc + " " + arr[arr.length - K]);
        }
    }
}
