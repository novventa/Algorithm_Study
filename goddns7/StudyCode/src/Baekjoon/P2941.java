package day0223;

import java.util.Scanner;

public class P2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열을 입력받음
		String line = sc.next();
		// 입력받은 문자열을 문자로 나눠서 배열에 넣음
		char[] arr = line.toCharArray();

		// 크로아티아 알파벳으로 이루어져 있는 단어의 개수
		int count = 0;
		// 크로아티아 단어의 알파벳의 개수
		int length = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 'c') {
				if (arr[i + 1] == '=') {
					count++;
					length += 2;
				} else if (arr[i + 1] == '-') {
					count++;
					length += 2;
				}
			} else if (arr[i] == 'd') {
				if (arr[i + 1] == 'z') {
					if (i + 2 >= arr.length) {
						continue;
					}
					//아래에서 z=의 단어와 겹치므로
					//여기서는 length의 길이에 1(=dz=의 3글자 - dz의 2글자)만 더해준다
					if (arr[i + 2] == '=') {
						
						length += 1;
					}
				} else if (arr[i + 1] == '-') {
					count++;
					length += 2;
				}
			} else if (arr[i] == 'l') {
				if (arr[i + 1] == 'j') {
					count++;
					length += 2;
				}
			} else if (arr[i] == 'n') {
				if (arr[i + 1] == 'j') {
					count++;
					length += 2;
				}
			} else if (arr[i] == 's') {
				if (arr[i + 1] == '=') {
					count++;
					length += 2;
				}
			} else if (arr[i] == 'z') {
				if (arr[i + 1] == '=') {
					count++;
					length += 2;
				}
			}

		}
		// 전체 길이에서 크로아티아 단어의 알파벳의 개수를 빼면 목록에 없는 알파벳이다.
		// count에 추가적으로 더해줘야 함
		count += arr.length - length;
		System.out.println(count);
		sc.close();
	}
}



