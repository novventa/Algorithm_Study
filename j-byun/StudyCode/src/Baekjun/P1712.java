import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 기본 수학 1
	// 1712 손익분기점
	// 브론즈2

	// 고정비용 A만원 : 판매 대수와 상관없음
	// 가변비용 B만원 : 한 대의 노트북을 생산하는데에 추가로 드는 비용
	
	// A=100, B=7, 10대 생산하면
	// => 100 + 7*10 = 170만원 / 10대
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		br.close();
		
		// 입력값 a, b, c
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		
		
		// 고정비용 a를 빼고 생각했을 때
		// 한 대 당 발생하는 수익 - 한 대 당 발생하는 생산비용이 양수가 아니면
		// 아무리 팔아도 이익이 날 수가 없음
		// 이 경우 -1 출력
		if (c - b <= 0) {
			System.out.println("-1");
		} else {
			// 이익날 수 있는 구조면
			// 고정비용 / 한 대 팔아서 남는 순수익 => 순수익 0원이 되는 지점이니까
			// 여기에 +1 해준다
			System.out.println(a / (c - b) + 1);
		}

	}
}



