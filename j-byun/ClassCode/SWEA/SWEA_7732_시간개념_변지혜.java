import java.util.Scanner;

// 7732 시간 개념
// D2

// 문제
// 시간 개념 없는 은빈이를 위한 약속까지 남은 시간 알려주는 프로그램 만들기

// 현재 시각보다 약속 시각이 더 빠른 경우 => 약속이 다음 날인 것
// 모든 시간은 00:00:00 ~ 23:59:59 사이로 표현
// XX:XX:XX 형태, 숫자가 2자리가 아닐 경우에는 0으로 채운다

// 풀이
// 스캐너 next로 읽어서 문자열로 읽어온 후
// ":" 기준으로 세 개로 분리해서 [3]크기의 배열에 나눠서 시, 분, 초를 저장
// 시, 분, 초를 비교해서 현재 시간이 더 큰 값인 경우 약속이 다음날이니까 약속시간에 24시 더해주기
// 이제 약속시간 - 현재시간을 계산해주자
// 뺀 값이 음수인 경우 앞 인덱스에서 -1 하고 현재 인덱스에 +60(분or초) 해주기

public class SWEA_7732_시간개념_변지혜 {
	
	static int[] curTime, appTime, remTime;
	
	public static void calcTime() { // 약속시간까지 남은 시간을 계산하는 method
		
		// 약속 시간이 내일인지 판단하기
		int cur = curTime[0] * 10000 + curTime[1] * 100 + curTime[2]; // 현재 시간을 : 없이 나타내고
		int app = appTime[0] * 10000 + appTime[1] * 100 + appTime[2]; // 약속 시간을 : 없이 나타내보자
		
		if (cur > app) // 현재시간의 표현이 약속시간 표현보다 크다면 약속은 내일이다
			appTime[0] += 24; // 약속 시간의 시에 + 24시 해주기
		
		
		// 이제 약속시간 - 현재시간을 계산하자
		remTime[0] = appTime[0] - curTime[0]; // 시 계산
		
		remTime[1] = appTime[1] - curTime[1]; // 분 계산
		
		if (remTime[1] < 0) { // 계산한 분이 음수 값일 경우
			remTime[0]--; // 시 에서 한 시간 	빼서
			remTime[1] += 60; // 분에 60분을 더해준다
		}
		
		remTime[2] = appTime[2] - curTime[2]; // 초 계산
		
		if (remTime[2] < 0) { // 계산한 초가 음수 값일 경우
			remTime[1]--; // 분 에서 1분 빼서
			remTime[2] += 60; // 초에 60초를 더해준다
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			String[] line = sc.next().split(":"); // 시간을 한 줄 읽어와서 : 기준으로 분리하기
			
			curTime = new int[3]; // 시, 분, 초로 나눠서 저장해줄 현재 시간 배열
			
			curTime[0] = Integer.parseInt(line[0]); // 현재 시
			curTime[1] = Integer.parseInt(line[1]); // 현재 분
			curTime[2] = Integer.parseInt(line[2]); // 현재 초
			
			line = sc.next().split(":");
			
			appTime =  new int[3]; // 시, 분, 초로 나눠서 저장해줄 약속 시간 배열
			
			appTime[0] = Integer.parseInt(line[0]);
			appTime[1] = Integer.parseInt(line[1]);
			appTime[2] = Integer.parseInt(line[2]);
			
			
			remTime = new int[3]; // 약속 시간까지 남은 시간을 시, 분, 초로 나눠서 저장해줄 배열
			
			calcTime(); // 시간 계산하기
			
			// 계산이 끝났으니 약속 시간까지 남은 시간을 출력하자
			// 이 때 각 자리수가 10보다 작다면 0을 붙여서 출력해야 한다
			if (remTime[0] < 10)
				sb.append("0");
			sb.append(remTime[0]).append(":");
			
			if (remTime[1] < 10)
				sb.append("0");
			sb.append(remTime[1]).append(":");
			
			if (remTime[2] < 10)
				sb.append("0");
			sb.append(remTime[2]).append("\n");
			
		}
		
		System.out.println(sb); // 출력
	}

}