package day0216;
import java.util.Arrays;
import java.util.Scanner;

public class P11399 {
	public static void main(String[] args) {
		
		//누적, 반복하여 필요한 시간이 구해지기 때문에
		//여러 번 더해지는 값들이 작을수록 최솟값을 얻을 수 있다
		//그래서 사람들이 필요한 시간을 오름차순으로 정렬하여 최솟값을 구하고자 한다
		
		Scanner sc = new Scanner(System.in);

		// 사람의 수
		int num = sc.nextInt();

		// 각 사람이 돈을 인출하는데 필요한 시간을 원소로 갖는 배열
		int[] time = new int[num];

		for (int i = 0; i < num; i++) {
			time[i] = sc.nextInt();
		}
		
		//최소값은 시간을 나타내는 배열이 오름차순으로 정렬될 때이다
		Arrays.sort(time);

		//한 사람이 돈을 인출하는데 필요한 시간
		int sum = 0;
		//각 사람이 돈을 인출하는데 필요한 시간의 합
		int total = 0;

		for (int i = 0; i < num; i++) {
			//한 사람이 돈을 인출하는데 필요한 시간(누적이기 때문에 하나씩 더해줌)
			sum += time[i];

			//해당 사람까지 모든 사람들이 돈을 인출하는데 필요한 시간의 합
			total += sum;
		}

		System.out.println(total);

		sc.close();
	}


}
