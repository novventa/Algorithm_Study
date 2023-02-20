package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5356 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 횟수 입력받기
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		for (int tc = 1; tc < T + 1; tc++) {
			
			// 테스트 케이스 한번 반복할 때마다 5개의 문자열을 입력하므로
			// 문자열마다 한 글자씩 저장할 큐 5개 생성.
			Queue<Character> str1 = new LinkedList<>();
			Queue<Character> str2 = new LinkedList<>();
			Queue<Character> str3 = new LinkedList<>();
			Queue<Character> str4 = new LinkedList<>();
			Queue<Character> str5 = new LinkedList<>();
			
			// 정답 출력을 위한 큐 생성
			Queue<Character> ansQueue = new LinkedList<>();
			
			// 첫번째 문자열 입력받기
			String string1 = sc.next();
			// 한 글자씩 큐에 저장
			for (int i = 0; i < string1.length(); i++) {
				str1.offer(string1.charAt(i));
			}
			// 두번째 문자열 입력받기
			String string2 = sc.next();
			// 한 글자씩 큐에 저장
			for (int i = 0; i < string2.length(); i++) {
				str2.offer(string2.charAt(i));
			}
			// 세번째 문자열 입력받기
			String string3 = sc.next();
			// 한 글자씩 큐에 저장
			for (int i = 0; i < string3.length(); i++) {
				str3.offer(string3.charAt(i));
			}
			// 네번째 문자열 입력받기
			String string4 = sc.next();
			// 한 글자씩 큐에 저장
			for (int i = 0; i < string4.length(); i++) {
				str4.offer(string4.charAt(i));
			}
			// 다섯번째 문자열 입력받기
			String string5 = sc.next();
			// 한 글자씩 큐에 저장
			for (int i = 0; i < string5.length(); i++) {
				str5.offer(string5.charAt(i));
			}
			
			// 출력을 위한 전체 문자열 길이 변수
			int ansLen = string1.length() + string2.length() + string3.length() + string4.length() + string5.length();
			
			// 정답 큐에 순서대로 저장한다.
			for (int i = 0; i < ansLen; i++) {
				// 첫번째 문자열 큐가 비어있지 않다면
				if (!str1.isEmpty()) {
					ansQueue.offer(str1.poll());
				}
				// 두번째 문자열 큐가 비어있지 않다면
				if (!str2.isEmpty()) {
					ansQueue.offer(str2.poll());
				}
				// 세번째 문자열 큐가 비어있지 않다면
				if (!str3.isEmpty()) {
					ansQueue.offer(str3.poll());
				}
				// 네번째 문자열 큐가 비어있지 않다면
				if (!str4.isEmpty()) {
					ansQueue.offer(str4.poll());
				}
				// 다섯번째 문자열 큐가 비어있지 않다면
				if (!str5.isEmpty()) {
					ansQueue.offer(str5.poll());
				}

			}
			
			// 양식에 맞게 출력하기
			System.out.print("#" + tc + " ");
			for (int i = 0; i < ansLen; i++) {
				System.out.print(ansQueue.poll());
			}
			System.out.println();
		}
	}
}
