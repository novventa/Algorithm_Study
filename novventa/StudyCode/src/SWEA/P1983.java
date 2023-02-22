package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class P1983 {
    public static void main(String[] args) {

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++){
            // 학생 수 입력받기
            int N = sc.nextInt();
            // 점수를 알고 싶은 학생 번호 입력받기
            int K = sc.nextInt();
            // K번 학생의 점수를 저장할 변수
            double kScore = 0;
            // K번 학생의 등수를 저장할 변수
            int kRank = 0;
            // K번 학생의 등급를 저장할 변수
            String kGrade = "";
            // 점수를 저장할 배열 선언
            double [] scores = new double[N];
            // 학생들의 점수 입력받기
            for(int i=0;i<N;i++){
                // 중간 점수
                int middle = sc.nextInt();
                // 기말 점수
                int finale = sc.nextInt();
                // 과제 점수
                int question = sc.nextInt();
                // 비율대로 계산해서 배열에 저장
                scores[i] = middle*0.35 + finale*0.45 + question*0.2;
                // K번째 학생의 점수는 따로 저장
                if(i==(K-1))
                    kScore = scores[i];
            }
            // 오름차순으로 정렬
            Arrays.sort(scores);
            // K번 학생의 등수 찾기
            for(int i=0;i<N;i++){
                if(kScore==scores[i])
                    kRank = N-i;
            }
            // K번 학생의 등급 매기기
            if(N/10>=kRank)
                kGrade = "A+";
            else if ((N/10)*2>=kRank)
                kGrade = "A0";
            else if ((N/10)*3>=kRank)
                kGrade = "A-";
            else if ((N/10)*4>=kRank)
                kGrade = "B+";
            else if ((N/10)*5>=kRank)
                kGrade = "B0";
            else if ((N/10)*6>=kRank)
                kGrade = "B-";
            else if ((N/10)*7>=kRank)
                kGrade = "C+";
            else if ((N/10)*8>=kRank)
                kGrade = "C0";
            else if ((N/10)*9>=kRank)
                kGrade = "C-";
            else if ((N/10)*10>=kRank)
                kGrade = "D0";

            // 출력
            System.out.println("#"+tc+" "+kGrade);

        }
    }
}
