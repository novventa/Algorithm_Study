import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
	// 수학1
	// 2869 달팽이는 올라가고 싶다
	// 브론즈1
	
	// 높이가 v미터인 나무 막대를 올라가는 달팽이
	// 낮에 a미터 올라가고
	// 밤에 b미터 미끄러짐
	// 정상찍으면 더 이상 안미끄러짐
	// => 며칠걸려야 정상 찍는지 구하시오

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		
		// 입력값
		// 낮에 올라가는 a미터
		int a = Integer.parseInt(s[0]);
		// 밤에 미끄러지는 b미터
		int b = Integer.parseInt(s[1]);
		// 나무 막대의 높이 v미터
		int v = Integer.parseInt(s[2]);
		
		br.close();
		
		// 낮 / 밤-낮 / 밤-낮 / 밤-낮 세트로 묶어서 생각하자
		// => 낮에 정상에 도착했다면 밤에 다시 떨어지지 않으니까
		// 첫 날에는 a 미터 만큼 올라가고
		// 둘째날 부터는 a-b미터 만큼 올라간다
		// a + (a - b) * (며칠-1) >= v미터 에서 며칠을 구하자
		
		// Math.ceil함수를 사용해 올림처리
		// 올림처리 하지 않고 임의로 1을 더해버리면 나머지 없이 딱 나누어 떨어질 때 오답 발생
		int days = (int) Math.ceil(((double) (v - a) / (a - b))) + 1;
		
//		System.out.println(Math.ceil(((double) (v - a) / (a - b))));
		
		// 결과값 출력
		System.out.println(days);
		
		
	}
}



