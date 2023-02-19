import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수학
        // 2775 부녀회장이 될테야
        // 브론즈1

        // 문제
        // 아파트 거주 조건
        // a층의 b호에 살려면...
        // 아래(a - 1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다

        // 아파트에 빈 집 없고
        // 모든 세대가 조건 충족하고 있음

        // 아파트는 0층 1호부터 있으며
        // 0층 i호에는 i명이 산다

        // 풀이
        // k*n크기의 2차원 배열 만들기
        // 0층부터~ k층까지 for문을 돌며
        //   0층에는 n값을 넣고
        //      다음 층 부터는 아래 층의 1호~n호까지의 값을 더해서 넣는다
        // 다 넣고 k,n출력



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 t 입력받기
        int t = Integer.parseInt(br.readLine());

        // 테스트케이스 개수만큼 반복
        for (int testCase = 1; testCase <= t; testCase++) {
            // 층 수 k 를 변수 floor로 입력받기
            int floor = Integer.parseInt(br.readLine());

            // 호 수 n을 변수 unit으로 입력받기
            int unit = Integer.parseInt(br.readLine());

            // k*n 사이즈의 2차원 배열이 필요한데...
            // k는 0층부터 시작하고
            //  n은 1호부터 시작하니까
            //      편의를 위해 n+1 사이즈로 만들어서 column의 인덱스가 곧 호실 번호가 되게 하자
            // k층의 경우
            //  0부터 시작해서 k층까지 값이 있어야 하니까
            //      k+1 사이즈로 만들자
            // 결국 인덱스의 마지막 값은 floor, unit이 된다
            //      => 우리가 원하는 값!
            int[][] apartment = new int[floor + 1][unit + 1];

            // n-1층의 1호부터 k호까지 사람들의 합을 카운트할 sumPeople을 만들어준다
            int sumPeople = 0;

            // 각 층, 호에 사는 사람 수 넣기
            // 층은 0층 부터 시작하니까 0 <= row < floor + 1
            for (int row = 0; row < floor + 1; row++) {
                // 호는 1부터 시작하니까 1 <= col <= unit + 1
                for (int col = 1; col < unit + 1; col++) {
                    // 만약 row가 0 이라면...
                    // apartment[row][col]의 값은 col값 이다
                    if (row == 0) {
                        apartment[row][col] = col;
                    } else {
                        // 만약 row가 0이 아니라면
                        // 한 호실에 대해 시작할 때마다 sumPeople 카운트를 초기화시키고
                        sumPeople = 0;

                        // row-1의 col 1~ 현재 col까지 돌면서 다 더한 값을 배열에 입력한다
                        for (int tmpCol = 1; tmpCol <= col; tmpCol++) {
                            sumPeople += apartment[row - 1][tmpCol];
                        }

                        // 아래층의 1호~col호 까지의 사람들의 합을 현재 호실에 입력해준다
                        apartment[row][col] = sumPeople;
                    }
                }
            }
            // n, k까지 모든 호실의 사람 수가 입력되어 for문이 끝났다면...
            // 우리가 원하는 n호 k실의 사람 수를 출력해준다
            System.out.println(apartment[floor][unit]);

        }

    }
}


