package Baekjoon;

import java.util.Scanner;

public class P13300 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int K = sc.nextInt();

        int[][] student = new int[7][2];

        // 성별, 학년별 사람 수를 2차원 배열로 저장
        for(int i=0; i<N; i++) {
            // 성별 먼저 입력받고
            int gender = sc.nextInt();
            // 성별에 따라 학년을 인덱스로 받고 1씩 더한다.
            if(gender==0)
                student[sc.nextInt()][0]++;
            else
                student[sc.nextInt()][1]++;
        }

        // 방 갯수를 저장할 변수
        int cnt = 0;

        // 남학생부터 탐색
        for(int i=1;i<=6;i++){
            // 한 명도 없다면 다음 학년 탐색
            if(student[i][1]==0)
                continue;
            // 최대 명수보다 적다면 방 한개만 필요하다
            else if(student[i][1]<=K)
                cnt++;
            // 최대 명수로 나눴을 때 딱 떨어지면 몫 만큼의 방이 필요하다.
            else if(student[i][1]%K==0)
                cnt += (student[i][1]/K);
            // 최대 명수로 나눴을 때 나머지가 있으면 몫+1 만큼의 방이 필요하다.
            else if(student[i][1]%K != 0)
                cnt += (student[i][1]/K) + 1;
        }

        // 여학생도 탐색
        for(int i=1;i<=6;i++){
            // 한 명도 없다면 다음 학년 탐색
            if(student[i][0]==0)
                continue;
                // 최대 명수보다 적다면 방 한개만 필요하다
            else if(student[i][0]<=K)
                cnt++;
                // 최대 명수로 나눴을 때 딱 떨어지면 몫 만큼의 방이 필요하다.
            else if(student[i][0]%K==0)
                cnt += (student[i][0]/K);
                // 최대 명수로 나눴을 때 나머지가 있으면 몫+1 만큼의 방이 필요하다.
            else if(student[i][0]%K != 0)
                cnt += (student[i][0]/K) + 1;
        }
        // 출력
        System.out.println(cnt);
    }
}
