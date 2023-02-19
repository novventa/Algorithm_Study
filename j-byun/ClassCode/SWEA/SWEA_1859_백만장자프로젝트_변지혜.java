import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // SWEA
        // 1859 백만 장자 프로젝트
        // D2

        // 문제
        // 미래를 보는 원재
        // 사재기할거임
        // 근데 당국의 감시가 심해 한 번에 많은 양 사재기 불가
        // 사재기 조건 하에서 최대한의 이득을 얻자

        // 사재기 조건
        // 원재는 연속된 n일 동안의 물건의 매매가를 예측하여 알고 있다
        // 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다
        // 판매는 얼마든지 가능

        // 풀이
        // 현재 날짜 기준으로
        // 내 다음 날짜에 지금보다 비싼 날이 존재하면
        // 그 중 제일 비싼 날 max를 찾아서
        // 현재 날짜~max값 전 날까지 가격에 대해
        // max - 그 날 가격 을 이익에 더해주고
        // max+1 인덱스로 넘어가서 반복 실행한다

        // 내 다음 날짜에 지금보다 비싼 날이 없으면
        // 내 다음 날짜 기준으로 다시 탐색 시작
        // ... 진행하다가 index범위가 n-1되는 순간 탐색 끝

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 테스트케이스의 수 t 입력받기
        int t = sc.nextInt();

        // 테스트케이스 개수만큼 반복
        for (int testCase = 1; testCase <= t; testCase++) {

            // 자연수 n 입력받기
            // 연속된 n일동안의 매매가를 알고있다
            int n = sc.nextInt();

            // n일 동안의 가격을 알고있으니까
            // n의 크기를 갖는 price 배열을 만들어준다
            int[] price = new int[n];

            // n일 동안의 가격 입력받기
            for (int idx = 0; idx < n; idx++) {
                price[idx] = sc.nextInt();
            }

            // 총 이익을 저장할 profit을 만들어준다
            long profit = 0;

            // 현재 값 기준 내 오른쪽 (미래) 값 중 최대값을 저장할 maxPrice를 만들어준다
            int maxPrice = 0;

            // 그 때의 인덱스 값을 저장할 maxPriceIdx를 만들어준다
            int maxPriceIdx = 0;

            // 현재의 인덱스 값을 저장할 idx를 만들어준다
            int idx = 0;

            // 가격이 저장된 price배열의 모든 값을 확인하면서
            // 현재값 기준 오른쪽 값 중 가장 큰 값 max를 찾는다

            // idx + 1부터 확인할거니까
            // 최대 idx는 n - 2 까지만 가야된다
            //      어차피 n-1번 인덱스는 사봤자 다음날이 없으니 못판다
            while (idx < n - 1) {
                // 현재 값이 바뀔 때 마다 maxPrice를 0으로 초기화해준다
                maxPrice = 0;
                maxPriceIdx = idx;

                // 현재 값 기준 오른쪽(미래)값을 다 확인하면서
                for (int tmpIdx = idx + 1; tmpIdx < n; tmpIdx++) {
                    // 현재까지의 최대값보다 큰 값이 있으면 값과 인덱스를 업데이트 해준다
                    if (price[tmpIdx] > maxPrice) {
                        maxPrice = price[tmpIdx];
                        maxPriceIdx = tmpIdx;
                    }
                } // for문이 끝났으면 현재 기준 오른쪽 값 중 가장 큰 값과 그 인덱스가 저장됐다

                // 현재 기준 오른쪽 값 중 가장 큰 값이
                // 현재의 값보다 같거나 크다면
                if (maxPrice >= price[idx]) {
                    // 현재 값 부터 최대값 바로 전 값까지의 모든 값에 대해
                    // 최대 금액 - 현재금액을 이익에 더해준다
                    for (int tmpIdx = idx; tmpIdx < maxPriceIdx; tmpIdx++) {
                        profit += maxPrice - price[tmpIdx];
                    }

                    // 이익 계산이 끝났으면
                    // 다음 while문 확인은 최대값의 인덱스 + 1에서 시작한다
                    idx = maxPriceIdx + 1;
                } else {
                    // 만약 최대값이라고 찾은 금액이 현재값보다 작다면
                    // 다음 idx기준으로 다시 while문 최대값 탐색을 시작한다
                    idx++;
                }

            }
            // while문을 다 돌았으면 profit에 최대이익 저장 완료!

            // 출력 양식
            sb.append("#").append(testCase).append(" ").append(profit).append("\n");
        }

        // 출력
        System.out.println(sb);

    }
}


