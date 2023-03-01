import java.util.Scanner;

// 2941 크로아티아 알파벳
// 실버5

// 문제
// 크로아티아 알파벳 : 대체문자
// č : c=
// ć : c-
// dž : dz=
// đ : d-
// lj : lj <= 왼쪽애는 하나로 침
// nj : nj <= 얘도
// š : s=
// ž : z=

// 풀이
// 중복 사용도 + 1 하니까
// 문자열 비교해서 맞을 때 마다 ++
// 해당하는 case 없을 때 default로 ++
// out of bounds 경우 잘 고려하기

public class BOJ_2941_크로아티아알파벳_변지혜 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 딱 한 줄만 읽을거라 스캐너도 시간 많이 안잡아먹음
		
		String line = sc.next(); // 한 줄 읽어오기
		
		int usedAlphabetCnt = 0; // 사용된 알파벳 개수 저장할 공간
		int idx = 0; // 읽어온 문자열에서 확인할 인덱스 표시
		
		while (idx < line.length()) { // 읽어온 문자열 길이만큼만 확인
			char cur = line.charAt(idx++); // 현재 인덱스의 문자 cur로 가져와서 확인하고 인덱스++
			char next; // 다음 확인할 문자
			
			if (idx == line.length()) { // 얘가 이 문자열 마지막 문자면 더 이상 확인 불가
				usedAlphabetCnt++;
				break;
			}
			
			switch(cur) { // 얘가 마지막 문자가 아니면 확인하러가기
			case 'c' :
				next = line.charAt(idx++);  // 다음 확인할 문자도 가져오고 인덱스++
				
				if (next == '=') {
					usedAlphabetCnt++;
					
				} else if (next == '-') {
					usedAlphabetCnt++;
					
				} else { // 크로아티아 알파벳 표에 있는 애가 아니면 그냥 'c'니까 카운트++하고 인덱스는 다시--해서 재확인
					usedAlphabetCnt++;
					idx--;
				}
				
				break;
				
			case 'd' :
				next = line.charAt(idx++);
				
				if (next == 'z') {
					if (idx == line.length()) { // dz에서 문자열 끝나면 두개 카운트해주고 끝내기 (outofbounds에러로 다음 if문 진입 불가)
						usedAlphabetCnt += 2;
						break;
					}
					
					if (line.charAt(idx++) == '=') { // 얘만 세문자로 구성돼있어서 새로운 char 안만들고 바로 비교해보고 버리기
						usedAlphabetCnt++;
						
					} else {
						usedAlphabetCnt++; // 세번째가 '='이 아니면 'd'만 카운트하고 다시 d 다음꺼 확인하러 가기
						idx -= 2;
					}
					
				} else if (next == '-') {
					usedAlphabetCnt++;
					
				} else {
					usedAlphabetCnt++;
					idx--;
				}
				
				break;
				
			case 'l' :
				next = line.charAt(idx++);
				
				if (next == 'j') {
					usedAlphabetCnt++;
					
				} else {
					usedAlphabetCnt++;
					idx--;
				}
				break;
				
			case 'n' :
				next = line.charAt(idx++);
				
				if (next == 'j') {
					usedAlphabetCnt++;
					
				} else {
					usedAlphabetCnt++;
					idx--;
				}
				break;
				
			case 's' :
				next = line.charAt(idx++);
				
				if (next == '=') {
					usedAlphabetCnt++;
					
				} else {
					usedAlphabetCnt++;
					idx--;
				}
				break;
				
			case 'z' :
				next = line.charAt(idx++);
				
				if (next == '=') {
					usedAlphabetCnt++;
					
				} else {
					usedAlphabetCnt++;
					idx--;
				}
				break;
				
			default : // 크로아티아 알파벳 표에 있는 애가 아니면 걍 알파벳이니까 문자 하나짜리로 카운트 ++
				usedAlphabetCnt++;
			}
		}
		
		System.out.println(usedAlphabetCnt);
		
	}
	
}
