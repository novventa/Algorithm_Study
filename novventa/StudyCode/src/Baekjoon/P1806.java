package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    // 시간제한 때문에 투 포인터를 무조건 써야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 개수
        int N = Integer.parseInt(st.nextToken());
        // 기준 숫자
        int target = Integer.parseInt(st.nextToken());
        // 숫자 배열 선언
        int[] nums = new int[100001];

        st = new StringTokenizer(br.readLine());

        // 숫자들 입력받기
        for(int i=0;i< N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 합이 S이상인 것중 가장 짧은 길이
        int min = Integer.MAX_VALUE;

        boolean notFound = true;
        boolean tmp = true;

        int total = 0;
        int s = 0;

        // i 번째를 마지막으로 한 부분합
        for(int i=0;i< N;i++){
            // 합이 S 이상인 것을 못찾았을때
            if(notFound){
                total = total + nums[i];
                // 처음으로 합이 S 이상인 것을 찾았을때
                if(total >= target){
                    min = i-s+1;
                    notFound = false;
                }
            }
            // 현재 길이가 x인 것을 찾았는데 그 이후로는 길이가 x 이상인 것은 찾을 필요가 없다.
            else{
                total = total - nums[s] + nums[i];
                s = s + 1;
            }
            // 만약 minimum 개씩 합을 확인하다가 타겟보다 커지면
            if(total >= target){
                tmp = true;
                // 가장 왼쪽부터 하나씩 빼면서 최소길이를 구한다.
                while(tmp){
                    if(total - nums[s] >= target){
                        total = total - nums[s];
                        s = s + 1;
                        min = min - 1;
                    }
                    else{
                        tmp = false;
                    }
                }
            }
        }
        // 불가능하면 0 출력
        if(min >= Integer.MAX_VALUE){
            System.out.println(0);
        }
        // 출력
        else{
            System.out.println(min);
        }
    }
}
