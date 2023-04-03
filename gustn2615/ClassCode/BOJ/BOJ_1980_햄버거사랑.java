package study_ssafy;

/*
 * -콜라를 먹는 시간이 최소가 되야한다.
 * -콜라를 먹는 시간은 타워버거나 불고기 버거를 먹는 시간보다는 작아야한다.
 * -콜라를 먹는 시간을 0초부터 1초 2초 늘려가면서 버거를 다먹을 수 있는 경우를 구하면 된다.
 *
 * 1. 햄버거를 먹는 시간을 min값과 max값으로 저장해 놓는다.
 * 2. 콜라를 먹는 시간은 min값보다는 작아야 하므로 0, 1, ..., min-1값까지 올려가면서 시간안에 버거를 먹을 수 있는지 구한다.
 * 3. 이때 버거를 최대한 많이 먹어야하므로 주어진 시간을 min값으로 먼저 나눈다.
 * 4. min값으로 나누어 떨어지지 않는다면, max값을 가지는 버거의 시간을 한번씩 빼가면서 min값으로 나누어 떨어질때를 구한다.
 *   ex) min=3 max=5 일때 주어진 시간이 8 이라면
 *   	 콜라를 먹는시간을 0이라고 할때
 *   	 8은 3으로 나누어 떨어지지 않으므로,
 *   	 8에서 5를 뺀다. 이때 8-5=3은 3으로 나누어 떨어지므로
 *   	 최대로 먹을수있는 버거는 2개이고 콜라를 먹는시간은 0초라는 것을 구할 수 있다.
 * 
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_1980_햄버거사랑 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더를 사용해서 입력값을 입력받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int towerBuger = Integer.parseInt(st.nextToken());
		int bulgogiBuger = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		// 두개의 버거를 먹는데 걸리는 시간 중 작은값을 min 큰값을 max에 저장
		int min = Math.min(towerBuger, bulgogiBuger);
		int max = Math.max(towerBuger, bulgogiBuger);
		
		// 콜라를 먹는시간을 저장할 변수
		int colaTime = 0;
		
		// 최대 햄버거 개수를 저장할 변수
		int maxburger = 0;
		
		// 최대 햄버거 값을 찾으면 true로 바꿔줄 논리형
		boolean flag = false;
		
		// 콜라를 먹는시간은 0 , 1, ..., min-1 초까지 가능하므로 
		// for문을 통해 콜라를 먹는 시간을 늘려간다
		for (int i = 0; i < min; i++) {
			
			// 만약 최대 햄버거의 개수를 찾았다면 더이상 반복문을 진행하지 않는다.
			if (flag) {
				break;
			}
			
			// 총 주어진 시간에서 콜라를 먹는시간을 뺀값을 전체 주어진 시간으로 가정한다
			int tmpTime = time - i;
			
			// 햄버거를 먹은 개수를 세어줄 변수
			int count = 0;
			
			// 반복문을 반복한다
			while (true) {
				
				// 만약 총 주어진 시간이 음수가 되면 이는 주어진 시간안에 햄버거를 먹을 수 없다는 얘기이므로
				// 반복문을 종료한다
				if (tmpTime < 0) {
					break;
				} 
				
				// 만약 주어진 시간이 min값으로 나누어 떨어지면 햄버거를 다 먹을 수 있으므로
				else if (tmpTime % min == 0) {
					
					// 햄버거를 카운트 해주고
					count += tmpTime / min;

					// 그때의 콜라를 먹는 시간과 총햄버거 개수를 저장한다
					colaTime = i;
					maxburger = count;
					
					// 최대 햄버거 개수를 찾았다고 바꾸어준다.
					flag = true;
					
					// 반복문을 종료한다
					break;
				}

				// 조건문에 들어가지 않았다면
				// max시간이 걸리는 햄버거를 하나 먹고 반복문을 계속 진행한다
				tmpTime -= max;
				count++;
			}
		}
		
		// 결과를 출력한다.
		System.out.printf("%d %d", maxburger, colaTime);
	}
}
