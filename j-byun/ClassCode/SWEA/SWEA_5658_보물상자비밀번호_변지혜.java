import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;


/**
 * @author jihye.byun
 * SWEA 5658 [모의 SW 역량테스트] 보물상자 비밀번호
 * 
 * 문제
 * 각 변에 16진수 숫자(0~F)가 적혀 있는 보물상자가 있다.
 * 보물 상자의 뚜껑은 시계방향으로 돌릴 수 있고, 한 번 돌릴 때마다 숫자가 시계방향으로 한 칸씩 회전한다.
 * 각 변에는 동일한 개수의 숫자가 있고, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸다.
 * 보물상자에는 자물쇠가 걸려있는데, 이 자물쇠의 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진 수로 만든 수이다.
 * N개의 숫자가 입력으로 주어졌을 때, 보물상자의 비밀 번호를 출력하는 프로그램을 만들어보자.
 * 서로 다른 회전 횟수에서 동일한 수가 중복으로 생성될 수 있다. 크기 순서를 셀 때 같은 수를 중복으로 세지 않도록 주의한다.
 * 
 * 조건
 * N은 4의 배수이고, 8이상 28이하의 정수이다. (8 ≤ N ≤ 28)
 * N개의 숫자는 각각 0이상 F이하로 주어진다. (A~F는 알파벳 대문자로만 주어진다.)
 * K는 생성 가능한 수의 개수보다 크게 주어지지 않는다.
 * 
 * 풀이
 * 1. N개의 숫자를 차례대로 덱에 입력받자.
 * 1-1. 계산을 편하게 하기 위해 덱에 넣을 때 부터 A:10 B:11 C:12 D:13 E:14 F:15로 변환해서 넣자
 * 2. N/4 개의 숫자를 차례대로 덱에서 뽑아서 16진수를 만들자.
 * 2-1. 위 과정을 4번 반복한다.
 * 3. 만들어진 16진수는 10진수로 변환해서 중복을 허용하지 않는 HashSet에 넣자.
 * 3-4. HashSet에서 값을 꺼낼 방법이 없네..?
 * 3-5. 그냥 ArrayList에 넣어서 정렬하면서 중복 값을 제거하자
 * 3-1. 16진수 -> 10진수 변환방법
 * 3-2. 1의 자리에 16^0을 곱하고 + 10의 자리에 16^1을 곱하고 ... 반복
 * 4. 위 과정이 한 번 실행됐으면, 덱의 마지막 숫자를 뽑아서 덱의 제일 앞에 넣고 다시 반복한다.
 * 4-1. 0 <= < N 번만큼 반복실행
 * 5. 반복 실행이 끝난 후, HashSet의 값을 내림차순 정렬해서 k-1번째 값을 출력한다.
 * 5-1. 인덱스는 0번부터 시작하니까
 */

public class SWEA_5658_보물상자비밀번호_변지혜 {
	
	static int numCnt;
	static Deque<Integer> num;
	static int[] password;
	static ArrayList<Integer> pwComb;
	
	private static void makePassword() {
		// 한 변의 숫자 조합으로 10진수 비밀번호를 만드는 method
		
		int size = numCnt / 4; // 한 변의 숫자 개수
		password = new int[size];
		
		for (int pass = 0; pass < 4; pass++) { // 네 변에 대해 반복 확인
			for (int idx = 0; idx < size; idx++) {
				int cur = num.poll(); // 한 변의 idx번째 숫자를 뽑아서 확인하자
				
				password[idx] = cur; // 비밀번호 배열의 idx번째에 값을 저장하고
				num.offer(cur); // 덱의 제일 뒤에 다시 넣어주자
			}
			// 한 변의 숫자 개수만큼 반복했다면
			// password배열이 가득 찼다
			// password배열에 저장된 숫자를 10진수로 바꿔서 만들 수 있는 암호 조합에 추가해주자
			sixteenToTen();
		}
	}
	
	private static void sixteenToTen() {
		// 16진수의 암호를 10진수로 바꿔주는 method
		
		int size = numCnt / 4; // password 배열의 크기
		int pw = 0; // 10진수로 변환한 암호를 저장할 공간
		
		for (int idx = size - 1; idx >= 0; idx--) { // password배열의 크기만큼 (16진수의 자리수만큼) 반복 실행
			pw += password[idx] * (int) Math.pow(16, size - (idx + 1)); // 1의 자리부터 16의 0제곱을 곱해서 pw에 더해 저장
		}
		// 16진수를 10진수로 변환하는 과정이 끝났다면
		// 10진수로 바꾼 암호를 ArrayList에 저장하자
		pwComb.add(pw);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력양식
			
			numCnt = sc.nextInt(); // 숫자의 개수 N 입력받기
			int K = sc.nextInt(); // K번째 큰 수를 찾자
			
			num = new ArrayDeque<Integer>(); // N개의 숫자를 저장할 덱 공간
			
			String line = sc.next(); // 한 줄을 읽어와서
			for (int cnt = 0; cnt < numCnt; cnt++) {
				char cur = line.charAt(cnt); // character 단위로 끊어서 덱에 저장하자
				
				if (Character.isDigit(cur)) // 숫자면 숫자로 변환해서 덱에 저장하고
					num.offer(cur - '0'); // '0' : ascii code 48
				else // 'A'~'F' 면 10~15로 변환해서 덱에 저장하자
					num.offer(cur - 'A' + 10);
			}
			
			// 덱에 int형으로 변환되어 잘 들어갔는지 확인하자
//			for (int cnt = 0; cnt < numCnt; cnt++) {
//				System.out.print(num.poll());
//			}
//			System.out.println();
			// 잘 들어갔다!
			
			pwComb = new ArrayList<>(); // 만들어진 암호 조합을 10진수로 변환해서 저장할 list 공간
			
			for (int cnt = 0; cnt < numCnt; cnt++) {
				makePassword(); // 만들 수 있는 네 개의 비밀번호를 확인하고
				
				num.offerFirst(num.pollLast()); // 시계방향으로 한 번 회전한 후 다시 만들 수 있는 비밀번호를 확인하자
				// 덱의 가장 마지막 값을 뽑아서 덱의 제일 앞에 넣어 준다
			}
			
			// ArrayList를 내림차순 정렬하자
			Collections.sort(pwComb, Collections.reverseOrder());
			
			int result = 0; // K번째 큰 값을 저장할 공간
			int cnt = 0; // 중복되지 않는 암호의 수를 세어줄 변수
			int idx = 0; // pwComb 배열에서 확인할 인덱스를 나타낼 변수
			while (cnt < K) {
				int cur = pwComb.get(idx); // pwComb 배열의 가장 큰 값부터 차례대로 확인하자
				
				// 확인한 값이 이전에 확인한 값과 같으면 중복되는 숫자이니 다음 값을 확인하자
				while (result == cur) {
					idx++;
					cur = pwComb.get(idx);
				}
				result = cur; // 확인한 숫자 저장
				
				idx++; // 다음 while문을 돌 때는 pwComb배열의 다음 값부터 확인하자
				cnt++; // 중복되지 않는 다음 수를 찾았다면 카운트를 증가시키자
				
				// K번째 값을 찾았다면 확인을 종료하자!
			}
			
			// K번째 값을 출력하자
			sb.append(result).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
