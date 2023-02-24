import java.util.LinkedList;
import java.util.Scanner;

// 1230 암호문3
// D3

// 문제
// 0 ~ 999999 사이의 수를 나열해서 만든 암호문

// 암호문 처리기 기능
// 1. I(삽입) x, y, s : 앞에서부터 x인덱스에 y개의 숫자 삽입 -> s는 삽입할 숫자들
// 2. D(삭제) x, y : 앞에서부터 x인덱스부터 y개의 숫자 삭제
// 3. A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다 -> s는 덧붙일 숫자들

// 암호문 수정하고 수정된 결과의 처음 10개 숫자를 출력하시오

// 조건 
// 2000 <= 원본 암호문의 길이 N <= 4000
// 250 <= 명령어의 개수 <= 500

public class SWEA_1230_암호문3_변지혜 {
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Integer> password;

	public static void insert() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		for (int idx = 0; idx < y; idx++) { // y개의 숫자 삽입하기
			password.add(x + idx, sc.nextInt());
		}
	}

	public static void delete() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		for (int idx = 0; idx < y; idx++) { // y개의 숫자 삭제하기
			password.remove(x);
		}
	}

	public static void add() {
		int y = sc.nextInt();
		
		for (int idx = 0; idx < y; idx++) { // 암호문의 맨 뒤에 y개의 숫자 추가하기
			password.addLast(sc.nextInt());
		}
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개만큼 반복
			sb.append("#").append(tc).append(" "); // 출력 양식

			password = new LinkedList<>(); // 암호를 저장할 연결 리스트 초기화

			int length = sc.nextInt(); // 원본 암호문의 길이 N 입력받기

			for (int idx = 0; idx < length; idx++) { // N개의 원본 암호문 입력받기
				password.addLast(sc.nextInt());
			}

			int commandSize = sc.nextInt(); // 명령어의 개수 입력받기

			for (int cnt = 0; cnt < commandSize; cnt++) { // 명령어 입력받고 실행하기

				String command = sc.next();
				
				switch (command) {
				case "I":
					insert();
					break;

				case "D":
					delete();
					break;

				case "A":
					add();
					break;

				}
			}

			
			for (int idx = 0; idx < 10; idx++) { // 처음 10개 숫자 출력하기
				sb.append(password.pollFirst() + " ");
			}
			
			sb.append("\n"); // 출력 양식 : 개행

		}

		System.out.println(sb); // 출력
	}

}
