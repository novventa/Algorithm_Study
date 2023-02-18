package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException {

        // 버퍼드리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 입력받기
        int N = Integer.parseInt(br.readLine());

        // 각 사람들의 몸무게, 키를 저장할 배열 생성
        int[] weight = new int[N];
        int[] height = new int[N];

        // 사람들의 등수를 저장할 배열 생성
        int[] grade = new int[N];

        // 키와 몸무게 입력받기
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 버퍼드리더 닫기
        br.close();

        // 한사람씩 비교해서 전부 다 탐색하는 브루트포스
        // 순서대로 사람 뽑기
        for(int i=0;i<N;i++){
            // 임시로 등수를 저장할 변수 생성
            // 뽑힌 본인이 있기 때문에 기본값은 1이다.
            int tmpGrade = 1;
            // 비교할 사람 뽑기
            for(int j=0;j<N;j++){
                // 비교할 사람은 뽑은 사람 뺴고
                if(i != j)
                    // 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면
                    // 뽑은 사람의 덩치보다 비교하는 사람의 덩치가 더 크다면 임시 등수를 1씩 올린다.
                    if(weight[i] < weight[j] && height[i] < height[j])
                        tmpGrade += 1;
            }
            // 뽑은 사람과 나머지 사람의 비교가 끝나면 등수를 저장한다.
            grade[i] = tmpGrade;
            // 반복
        }

        // 등수 출력하기
        for(int i=0; i<N; i++){
            System.out.printf(grade[i] + " ");
        }
    }
}
