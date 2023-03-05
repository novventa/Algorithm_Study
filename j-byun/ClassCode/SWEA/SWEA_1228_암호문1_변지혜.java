import java.util.LinkedList;
import java.util.Scanner;

// 1228 암호문1
// D3

// 문제
// 0~999999 사이의 수를 나열하여 만든 암호문

// 암호문을 수정하려면 다음 과정을 통해서만 수정 가능
// I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다
// 					ex) I 3 2 123152 487651

// 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라

// 조건
// 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
// 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)

// 풀이
// 암호문을 linkedlist에 저장하기
// 	특정 인덱스의 뒤에 값을 넣을 수 있고
//	배열보다 효율적으로 값을 추가할 수 있기 때문에
// I가 들어오면...
// 0 <= < y번 만큼 반복하면서
// 큐의 x + y 인덱스에 값을 받아서 집어넣는다

public class SWEA_1228_암호문1_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int size = sc.nextInt(); // 원본 암호문의 길이 입력받기
			LinkedList<Integer> password = new LinkedList<Integer>(); // 암호문을 저장할 linkedList 공간 만들기
			
			for (int idx = 0; idx < size; idx++) { // 암호문의 길이만큼 암호문 입력받기
				password.addLast(sc.nextInt());
			}
			
			int commandCnt = sc.nextInt(); // 명령어의 개수 입력받기
			
			for (int cnt = 0; cnt < commandCnt; cnt++) { // 명령어 개수만큼 명령어 입력받기
				String command = sc.next(); // 명령어 I (단일 명령어라 입력받아서 쓸 데는 없다)
				int x = sc.nextInt(); // 숫자를 삽입할 위치 입력받기
				int y = sc.nextInt(); // 삽입할 숫자의 개수 입력받기
				
				for (int pass = 0; pass < y; pass++) { // 삽입할 숫자 개수만큼 반복하기
					password.add(x + pass, sc.nextInt());
				}
			}
			
			for (int cnt = 0; cnt < 10; cnt++) { // 명령어 입력이 끝났으면 앞에서부터 10개의 암호 뽑아내기
				sb.append(password.pollFirst() + " ");
			}
			
			sb.append("\n"); // 테케 하나 끝날 때 마다 개행
		}
		
		sc.close(); // 입력 다 받았으면 스캐너 닫기
		System.out.println(sb); // 출력
	}

}
