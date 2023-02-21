import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 브루트포스
        // 2798 블랙잭
        // 브론즈2
        
        // 문제
        // 새로운 블랙잭 규칙
        // 양의 정수가 쓰여 있는 N장의 카드 중
        // 3장을 골라서 그 합이 <= M 인데 M에 제일 가까운 합을 출력

        // 풀이
        // 3중 for문 돌려서 3개를 값으로 받는 순열 다 구하고
        // 그 합이 <= M이고, 지금까지의 최대값 보다 크면 최대값으로 업데이트
        //      if 그 합이 M이면 거기서 바로 for문 다 break하고 sysout

        Scanner sc = new Scanner(System.in);

        // 카드의 개수 n을 cardSize로 입력받자
        int cardSize = sc.nextInt();

        // 세 카드의 합 <= M 조건의 M을 maxCondition 으로 입력받기
        int maxCondition = sc.nextInt();

        // cardSize 개수의 카드 번호를 입력 받을 배열 cards 만들기
        int[] cards = new int[cardSize];

        // cards배열에 카드 번호 입력받기
        for (int idx = 0; idx < cardSize; idx++) {
            cards[idx] = sc.nextInt();
        }
        
        // 뽑아낸 세 값의 합 중 최대값을 저장할 maxSum 만들기
        int maxSum = 0;

        // 뽑아낸 세 값의 합을 저장할 sum 만들기
        int sum = 0;
        
        // 3중 for문 돌려서 3개의 값을 뽑아내는 완전탐색 실행
        outer : for (int idx1 = 0; idx1 < cardSize; idx1++) {
            for (int idx2 = 0; idx2 < cardSize; idx2++) {
                // idx1 != idx2 여야 하고,
                if (idx1 != idx2) {
                    for (int idx3 = 0; idx3 < cardSize; idx3++) {
                        // idx1 != idx2 != idx3 여야 한다
                        if (idx1 != idx3 && idx2 != idx3) {
                            // 조건을 만족하면 세 값의 합을 sum에 저장
                            sum = cards[idx1] + cards[idx2] + cards[idx3];
                            
                            // sum이 주어진 최대조건값보다 작거나 같고 현재까지의 maxSum보다 크다면
                            if (sum <= maxCondition && sum > maxSum) {
                                // maxSum값의 sum으로 업데이트
                                maxSum = sum;

                                // maxSum == 최대조건값이라면
                                // 이게 이미 나올 수 있는 최대값이기 때문에 더 탐색하는 것이 무의미하다
                                if (maxSum == maxCondition) break outer;
                            }
                        }
                    }
                }
            }
        }

        // 3중 for문을 다 돌았다는 뜻은
        // maxCondition과 일치하는 maxSum이 나왔거나
        // maxCondition >= 조건을 만족하는 값 중 가장 큰 maxSum이 나왔다는 뜻이니
        // maxSum 출력
        System.out.println(maxSum);

    }
}


