package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2851 {
    // 숫자를 처음부터 더해가면서 100에 제일 가깝게 만들어야 한다.
    // 더하기를 중단하면 더 이상 더하지 못하므로 숫자를 더할때마다 확인한다.

    public static void main(String[] args) throws IOException {
        // 버퍼드리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 점수들을 저장할 배열 생성
        int[] nums = new int[10];
        // 점수 입력받기
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        // 합을 저장할 변수와 답을 저장할 변수 생성
        int sum = 0;
        int ans = 0;
        // 하나씩 더해가면서 비교한다.
        for(int i=0;i<nums.length;i++) {
            // 합이 100보다 작으면 일단 더한다.
            if (sum < 100) {
                sum += nums[i];
                // 만약 이전의 100과의 차이가 더한 후의 100과의 차이보다 크다면
                if (Math.abs(ans - 100) > Math.abs(sum - 100)) {
                    // 답을 현재 합으로 바꾼다.
                    ans = sum;
                    // 같은 경우에는 더 큰 값을 출력해야 하므로
                } else if (Math.abs(ans - 100) == Math.abs(sum - 100)) {
                    // 삼항 연산자로 비교하여 답을 저장한다.
                    ans = (ans > sum) ? ans : sum;
                }
            }
        }
        // 출력
        System.out.println(ans);
    }
}
