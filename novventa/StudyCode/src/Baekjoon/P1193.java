package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {
    public static void main(String[] args) throws IOException {
        // 분수 찾기
        // 분수의 순서는 다음과 같다.
        // 1  2  6  7   15  16  28  29     1/1  1/2  1/3  1/4  1/5  1/6
        // 3  5  8  14  17  27  30         2/1  2/2  2/3  2/4  2/5
        // 4  9  13 18  26  31         ->  3/1  3/2  3/3  3/4
        // 10 12 19 25  32                 4/1  4/2  4/3
        // 11 20 24 33                     5/1  5/2
        // 21 23 34                        6/1
        // 22 35
        // 36

        // x번째 분수를 찾기 위해서는
        // x가 몇행 몇열에 있는지 찾으면 된다.
        // 대각선을 기준으로 분모 분자의 합이 모두 같고
        // 모양을 돌려서 피라미드처럼 만든 후 위에서부터 인덱스가 1이라고 하면
        // 인덱스가 짝수이면 숫자가 왼쪽 방향으로 증가
        // 홀수이면 오른쪽 방향으로 증가한다.
        // X가 몇번째 인덱스에 있는지 구하고
        // 해당 인덱스에서 몇번째에 있는지 구하면 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X를 입력받는다.
        int X = Integer.parseInt(br.readLine());

        int idx = 1;        // 인덱스 번호
        int preIdxSum = 0;  // 이전 대각선까지의 합

        // X가 몇번 인덱스에 있는지 구하기
        while(true){
            if(preIdxSum + idx >= X){
                break;
            }
            preIdxSum += idx;
            idx++;
        }

        // 해당 인덱스에서 몇번쨰에 있는지 구하기
        int location = X - preIdxSum;

        // 인덱스가 홀수 일 경우 분모가 1부터 시작. 짝수일 경우 분자가 1부터 시작.
        if(idx % 2 == 1){
            System.out.println((idx - location + 1) + "/" + location);
        } else {
            System.out.println(location + "/" + (idx - location + 1));
        }
    }
}
