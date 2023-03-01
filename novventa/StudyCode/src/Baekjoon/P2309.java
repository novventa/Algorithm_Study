package Baekjoon;

import java.util.*;

public class P2309{	
	public static void main(String[] arg) {
		
        Scanner sc  = new Scanner(System.in);
		// 난쟁이 수
		int N = 9;
        // 난쟁이들의 키를 담을 배열 생성
		int[] arr = new int[N];
        // 키의 총 합
		int sum=0;
        // 키의 합이 100인지 확인할 변수
		boolean check =false;
		
        // 키 입력받고 총 합 구하기
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
        
        // 브루트포스로 찾는다
		for(int i=0;i<N;i++) {
            // 총 합이 100이 아니라면 break
			if(check)break;
			for(int j=0;j<N;j++) {
                // j는 i 빼고
				if(i==j)continue;
                // 만약 총 합에서 고른 2명의 키를 빼면 100이라면
				if(sum-arr[j]-arr[i]==100) {
                    // 그 둘의 키를 0으로 만들고 break
					arr[i]=0;
					arr[j]=0;
					check=true;
					break;
				}
			}
		}
        // 정렬하고 0으로 만든 2명을 제외하고 출력
		Arrays.sort(arr);
		for(int i =2;i<9;i++) {
			System.out.println(arr[i]);
		}
	}
}