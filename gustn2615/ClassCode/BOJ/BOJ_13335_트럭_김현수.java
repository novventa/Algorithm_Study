package study_ssafy;

/*
 * 두개의 큐를 사용해서 문제를 푼다.
 * 첫번째 큐에는 트럭의 무게를 넣어준다.
 * 두번째 큐에는 다리를 지나가는 트럭을 넣어준다.
 * => 이때 트럭이 존재하는 공간 외에는 모두 0을 넣어줄 것이다.
 * 
 * 1. 트럭의 무게를 첫번째 큐에 넣는다.
 * 2. 이후 첫번째 큐에서 트럭을 하나씩 꺼내면서 두번째 큐에 집어넣는다.
 * 3. 이때 다리에 하중을 생각하여 하중을 넘기게 된다면 트럭을 넣지않고 빈공간을 넣어준다
 * 4. 이때 두번째 큐의 크기는 다리의 길이를 넘어서는 안된다
 * 5. 반복문을 돌리면서 첫번째 큐의 트럭이 모두 빠져나와 두번째 큐로 들어갔다면 반복문을 빠져나온다
 * 6. 이때 모든 트럭이 다리를 지나가고 있는 것 이므로 반복문을 빠져나와 여태까지 걸린시간을 확인한다
 * 7. 마지막 트럭이 다리에 들어간 이후 트럭이 다리를 빠져나오는 데는 다리의 길이만큼 시간이 걸리므로
 * 8. 여태까지 걸린시간 + 다리길이 가 총걸린 시간이다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_13335_트럭_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 트럭개수 받아오기
		int truckNum = Integer.parseInt(st.nextToken());
		
		// 다리 길이 받아오기
		int bridgeLength = Integer.parseInt(st.nextToken());
		
		// 다리 무게 받아오기
		int bridgeWeight = Integer.parseInt(st.nextToken());
		
		// 트럭 무게를 담을 큐 배열 정의
		Queue<Integer> truck = new ArrayDeque<>();
		
		// 트럭의 무게를 읽어온다
		st = new StringTokenizer(br.readLine());
		
		// 첫번째 큐에 트럭의 무게 담기
		for (int i = 0; i < truckNum; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		// 버퍼리더 종료
		br.close();
		// 다리의 길이만큼 트럭과 빈공간을 담을 두번째 큐 정의
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 다리위에 존재하는 트럭무게를 구할 변수
		int weight = 0;
		
		// 걸린 시간을 확인할 변수
		int time = 0;
		
		// 트럭이 빌때 까지 반복한다
		while (!truck.isEmpty()) {

			// 가장 앞쪽의 트럭 무게를 확인한다
			int tmp = truck.peek();

			// 두번째 queue가 아직 다 안찼을 때
			// 즉, 다리길이보다 작을 때
			if (queue.size() < bridgeLength) {
				
				// 만약 다음 트럭과 기존 트럭들의 무게합이 하중보다 크면
				if (weight + tmp > bridgeWeight) {
					
					// 두번째 큐에 빈공간을 나타내는 0값을 추가한다
					queue.add(0);

				} 
				
				// 만약 무게합이 하중보다 작으면
				else {
					
					// 두번째 큐에 트럭을 추가하고
					queue.add(tmp);
					
					// 첫번째 큐에서 트럭을 빼고
					truck.poll();
					
					// 하중에 트럭 무게를 더한다
					weight += tmp;
				}
			}
			// 두번째 queue가 다리 길이만큼 찼을 때
			else if (queue.size() == bridgeLength) {
				
				// 전체 하중에서 다리 가장 앞쪽의 무게를 뺀다
				weight -= queue.poll();
				
				// 이후 다리 마지막에 들어올 트럭의 무게와 기존무게의 합이 하중보다 크다면
				if (weight + tmp > bridgeWeight) {
					
					// 두번째 큐에 빈공간을 나타내는 0값을 추가한다
					queue.add(0);
				} 
				// 다리 마지막에 들어올 트럭의 무게와 기존 무게의 합이 하중보다 작거나 같다면
				else {
					
					// 두번째 큐에 트럭 무게를 더한다
					queue.add(tmp);
					
					// 첫번째 큐에서 트럭을 빼낸다
					truck.poll();
					
					// 전체 무게에 트럭무게를 더한다.
					weight += tmp;
				}

			}
			
			// 조건문을 거쳤으면 시간이 1초가 지나므로 시간을 늘린다
			time++;
		}
		
		// 반복문을 빠져나왔다는 것은 모든 트럭이 다리에 올라갔다는 뜻이다
		// 즉 다리의 맨 마지막쪽에 트럭이 존재하므로
		// 이 트럭이 다리를 지나가기까지 걸리는 시간은 다리의 길이만큼이다.
		// 따라서 최종적으로 time+(다리의 길이)가 총 걸린 시간이다.
		System.out.println(time+bridgeLength);
	}
}
