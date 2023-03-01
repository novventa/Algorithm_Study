package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3499 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 수 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++){
            // 카드 갯수 입력받기
            int N = sc.nextInt();
            // 카드를 반으로 나눴을 때 윗부분과 아랫부분을 저장할 큐 생성
            Queue<String> upper = new LinkedList<>();
            Queue<String> lower = new LinkedList<>();
            // 일단 모든 카드를 아랫부분 큐에 저장한다.
            for(int i=0;i<N;i++){
                lower.offer(sc.next().trim());
            }
            // 카드 갯수가 짝수인지 홀수인지에 따라서
            // 짝수이면
            if(N%2==0){
                // 갯수의 반만큼 아랫부분에서 윗부분으로 옮긴다
                for(int i=0;i<N/2;i++){
                    upper.offer(lower.poll());
                }
                // 홀수이면
            }else {
                // 반 + 1개만큼 아랫부분에서 윗부분으로 옮긴다
                for (int i=0;i<N/2+1;i++){
                    upper.offer(lower.poll());
                }
            }
            // 출력
            System.out.print("#"+ tc + " ");
            while(true) {
                // 윗부분과 아랫부분에서 하나씩 뽑아서
                String up = "";
                String down = "";
                // 윗 부분 하나 아랫부분 하나 번갈아가며 poll 한다.
                if(!upper.isEmpty())
                    up = upper.poll();
                if(!lower.isEmpty())
                    down = lower.poll();
                System.out.print(up + " " + down + " ");
                // 만약 윗 부분 아랫부분 모두 poll 했다면 break
                if(upper.isEmpty() && lower.isEmpty())
                    break;
            }
            System.out.println();
        }
    }
}
