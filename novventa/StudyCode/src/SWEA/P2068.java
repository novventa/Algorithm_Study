package SWEA;


import java.util.Scanner;

public class P2068 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int T=1; T<tc+1; T++) {
			
			int[] arr = new int[10];
			
			for(int i=0;i<10;i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int j=0; j<arr.length-1;j++) {
				if(arr[j+1]<arr[j]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			int max = arr[9];
			
			System.out.println("#" + T + " " + max);
		}
	}
}
