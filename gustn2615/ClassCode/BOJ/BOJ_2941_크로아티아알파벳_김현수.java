package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_2941_크로아티아알파벳_김현수 {
	public static void main(String[] args) throws IOException {
		// bufferReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 단어 문자 배열로 받아오기
		char[] word = br.readLine().toCharArray();
		// 버퍼리더 종료
		br.close();
		// 단어의 길이를 변수로 저장
		int size = word.length;
		// word의 문자를 첫번째부터 가져올 index설정
		int index = 0;
		// 단어의 개수를 세줄 변수 설정
		int count = 0;
		// index가 size와 같아질 때 까지 반복
		while (index < size) {
			// 크로아티아 문자를 확인할 때 index가 size-1 범위를 벗어나면 안되기 때문에 범위를 지정해준다.
			if (index <= size - 2) {
				// 이때 dz=는 문자3개가 하나의 크로아티아 문자이므로
				// index가 (size-3)를 넘어서는 안된다.
				if (index <= size - 3) {
					if (word[index] == 'd' && word[index + 1] == 'z' && word[index + 2] == '=') {
						count++;
						index += 3;
						continue;
					}
				}
				// 나머지 문자들은 전부 문자 2개가 하나의 크로아티아 문자이다.
				if (word[index] == 'c' && word[index + 1] == '=') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 'c' && word[index + 1] == '-') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 'd' && word[index + 1] == '-') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 'l' && word[index + 1] == 'j') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 'n' && word[index + 1] == 'j') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 's' && word[index + 1] == '=') {
					count++;
					index += 2;
					continue;
				} else if (word[index] == 'z' && word[index + 1] == '=') {
					count++;
					index += 2;
					continue;
				} else {
					count++;
					index++;
					continue;
				}
			}
			// 크로아티아 문자가 아니면 count와 index를 증가시키고 다음으로 넘어간다.
			else {
				count++;
				index++;
				continue;
			}
		}
		System.out.println(count);
	}
}
