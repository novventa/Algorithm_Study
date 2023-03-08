package study_ssafy;

/*
 * 2차원 배열을 만들어서 index를 학년이라고 생각 한다.
 * 이후 2차원 배열에 성별에 따른 학생 수를 넣은 후
 * 이를 방마다 넣을 수 있는 최대 인원으로 나누어 그 값을 올림처리하여 방의 개수를 센다
 * 이때 주의할 점은 int형으로 계산할 시 자동으로 버림 처리가 되므로
 * float형을 사용해 준다.
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_13300_방배정_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더와 tokenizer사용해서 입력값 받아오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int studentNum = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		// 성별에 따른 학생수를 넣을 이차원 배열 정의
		int[][] studentGenderGrade = new int[2][7];
		
		// 학생 수 만큼 돌면서 각학년별 여학생과 남학생 수 입력
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			++studentGenderGrade[gender][grade];
		}
		br.close();
		
		// 학생 수가 잘 입력되었는지 확인
//		for (int i = 0; i < 2; i++) {
//			for (int j = 1; j <= 6; j++) {
//				System.out.print(studentGenderGrade[i][j]);
//			}
//			System.out.println();
//		}
		
		
		// 방의 개수를 세어줄 변수
		int cnt = 0;
		
		// 전체 학년을 돌면서
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				// 각학년의 학생수에서 각 방에 들어갈 수 있는 최대인원을 나누어 그 값을 올림한다
				// 이는 방의 개수가 되므로 이를 모두 더하면 된다.
				cnt += Math.ceil((float) studentGenderGrade[i][j] / maxNum);
			}
		}
		
		//출력한다.
		System.out.println(cnt);
	}
}
