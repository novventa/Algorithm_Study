package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13335_X {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 다리를 건너는 트럭의 수
		int truckNum = sc.nextInt();
		// 다리의 길이
		int bridgeLength = sc.nextInt();
		// 다리의 최대하중
		int maxWeight = sc.nextInt();

		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		// 모든 트럭이 다리를 건너는 최단시간
		int time = 0;

		// 트럭의 무게를 입력받는다
		for (int i = 0; i < truckNum; i++) {
			truck.add(sc.nextInt());
		}
		// 다리길이만큼 다리Queue에 무게0을 넣어준다(아무것도 없으므로)
		for (int i = 0; i < bridgeLength; i++) {
			bridge.add(0);
		}

		// 다리의 무게
		int bridgeWeight = 0;

		//다리위에 아무것도 없을 때까지 반복
		while (!bridge.isEmpty()) {
			//아래의 반복문을 한 번 실행할 때마다 time++
			time++;
			//다리의 무게는 다리위에 있는 무게를 하나씩 빼고 그만큼 빼주는 것이다.
			bridgeWeight -= bridge.poll();

			//트럭이 남아있다면
			if (!truck.isEmpty()) {
				//트럭 제일 앞의 원소를 확인하고 그것과 다리의 무게를 더했을 때 최대하중보다 작거나 같으면
				if (truck.peek() + bridgeWeight <= maxWeight) {
					//해당 트럭의 무게만큼 다리의 무게에 더해주고
					bridgeWeight += truck.peek();
					//해당 트럭을 뽑아서 다리 위에 올려둔다
					bridge.add(truck.poll());
					//트럭 제일 앞의 원소를 확인하고 그것과 다리의 무게를 더했을 때 최대하중보다 크면
				} else {
					//다리 위에 올릴 수 없어서 0으로 올린다(아무것도 올리지 않아 무게가 0이라는 의미)
					bridge.add(0);
				}
			}

		}

		System.out.println(time);
	}
}





