import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2527 직사각형
// 실버1

// 문제
// 직사각형좌표 왼쪽아래 x, y 오른쪽위 p, q 순서로 주어짐
// x < p, y < q

// 두 직사각형이 주어졌을 때...
// a 겹치는 부분이 직사각형인 경우
// b 겹치는 부분이 선분인 경우
// c 겹지는 부분이 점인 경우
// d 겹치는 부분이 아예 없는 경우

// 풀이
// 각 경우에 해당하는 케이스를 생각해보자
// 사각형1 : s1, 사각형2 : s2

// a 겹치는 사각형
// b, c, d 경우 빼고 다

// b 선분
// s1 start y == s2 end y && s1 start x != s2 end x
// s2 start y == s1 end y && s2 start x != s1 end x
// s1 start x == s2 end x && s1 start y != s2 end y
// s2 start x == s1 end x && s2 start y != s1 end y

// c 점
// s1 start x == s2 end x && s1 start y == s2 end y
// s2 start x == s1 end x && s2 start y == s1 end y
// s1 start y == s2 end y && s1 end x == s2 start x
// s2 start y == s1 end y && s2 end x == s1 start x

// d 완전 분리
// s1 end x < s2 start x
// s2 end x < s1 start x
// s1 end y < s2 start y
// s2 end y < s1 start y

public class BOJ_2527_직사각형_변지혜 {
	
	static int[] square1 = new int[4]; // x y p q 순서의 좌표값을 가지는 사각형
	static int[] square2 = new int[4];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int tc = 1; tc <= 4; tc++) { // 테케 4개
    		
    		StringTokenizer st = new StringTokenizer(br.readLine()); // 버퍼드리더로 한 줄 읽어와서 띄어쓰기 기준으로 분리
    		
    		for (int idx = 0; idx < 4; idx++) { // 사각형1의 x y p q 입력받기
    			square1[idx] = Integer.parseInt(st.nextToken());
    		}
    		
    		for (int idx = 0; idx < 4; idx++) { // 사각형2의 x y p q 입력받기
    			square2[idx] = Integer.parseInt(st.nextToken());
    		}
    		
    		char result = squareOverlap(); // 두 사각형의 겹치는 모양을 판별할 method 실행하고 반환 char를 result로 저장
    		
    		sb.append(result).append("\n"); // 출력양식
    	}
    	
    	System.out.println(sb); // 출력
    }
    
    private static char squareOverlap() { // 두 사각형의 겹치는 모양을 판별할 method
    	
    	// 사각형 배열 인덱스 [0, 1, 2, 3]
    	// 0 : start x
    	// 1 : start y
    	// 2 : end x
    	// 3 : end y
    	// 배열 인덱스로 표현하면 헷갈리니까 각각의 int로 빼버리자
    	int s1StartX = square1[0];
    	int s1StartY = square1[1];
    	int s1EndX = square1[2];
    	int s1EndY = square1[3];
    	
    	int s2StartX = square2[0];
    	int s2StartY = square2[1];
    	int s2EndX = square2[2];
    	int s2EndY = square2[3];
    	
    	// d 완전 분리
    	if (s1EndX < s2StartX)
    		return 'd';
    	
    	if (s2EndX < s1StartX)
    		return 'd';
    	
    	if (s1EndY < s2StartY)
    		return 'd';
    	
    	if (s2EndY < s1StartY)
    		return 'd';
    	
    	// c 점
    	if (s1StartX == s2EndX && s1StartY == s2EndY)
    		return 'c';
    	
    	if (s2StartX == s1EndX && s2StartY == s1EndY)
    		return 'c';
    	
    	if (s1StartY == s2EndY && s1EndX == s2StartX)
    		return 'c';
    	
    	if (s2StartY == s1EndY && s2EndX == s1StartX)
    		return 'c';

    	// b 선분
    	if (s1StartY == s2EndY && s1StartX != s2EndX)
    		return 'b';
    	
    	if (s2StartY == s1EndY && s2StartX != s1EndX)
    		return 'b';
    	
    	if (s1StartX == s2EndX && s1StartY != s2EndY)
    		return 'b';
    	
    	if (s2StartX == s1EndX && s2StartY != s1EndY)
    		return 'b';

    	// a 겹치는 사각형 => b, c, d 경우 빼고 다
    	return 'a';
    	
    }
    
}


