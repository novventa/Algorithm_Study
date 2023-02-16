import java.util.Scanner;

public class P2798 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 카드의 갯수(cardCnt)와
		// 카드의 합(blackJack)을 입력 받는다.
		int cardCnt = sc.nextInt();
		int blackJack = sc.nextInt();

		// 카드 숫자를 저장할 배열을 만든다.
		int[] cardList = new int[cardCnt];

		// 카드의 갯수만큼 카드의 숫자를 배열에 저장한다.
		for (int idx = 0; idx < cardCnt; idx++) {
			cardList[idx] = sc.nextInt();
		}

		// 최댓값을 저장할 변수를 만든다.
		int max = 0;

		// 3개의 카드의 합을 고르는 경우이기 때문에
		// 3중 for문을 사용해 배열의 전체를 탐색한다
		// 카드의 중복은 허용하지 않고, 카드 순서는 의미가 없기 때문에
		// 최소한 반복을 하는 for문을 작성한다.
		// 예를 들어 카드 배열에 [1,2,3,4,5]가 있다면,
		// [1,2,3]과 [2,1,3]은 순서는 다르지만 합은 같기 때문에
		// 다시 배열의 처음부터 탐색할 필요가 없다.

		// 첫번째 카드는 0부터 카드의 갯수-2 까지 탐색한다
		for (int firstCard = 0; firstCard < cardCnt - 2; firstCard++) {
			// 두번째 카드는 firstcard+1부터 카드의 갯수-1 까지 탐색한다.
			for (int secondCard = firstCard + 1; secondCard < cardCnt - 1; secondCard++) {
				// 세번째 카드는 secondCard+1부터 카드의 갯수까지 탐색한다.
				for (int thirdCard = secondCard + 1; thirdCard < cardCnt; thirdCard++) {

					// result에 첫번째, 두번째, 세번째 카드의 합을 저장하고,
					int result = cardList[firstCard] + cardList[secondCard] + cardList[thirdCard];

					// 3장의 카드의 합이 blackJack보다 크면 안되므로 조건을 설정한다.
					if (result <= blackJack) {

						// 3장의 카드의 합이 최댓값보다 크다면, 최댓값을 갱신한다.
						if (result > max)
							max = result;

					}

				}

			}

		}
		// 최댓값을 출력한다.
		System.out.println(max);

	}
}
