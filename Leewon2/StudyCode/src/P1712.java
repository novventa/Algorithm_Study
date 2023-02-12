import java.util.Scanner;

public class P1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		
		// B가 C보다 크거나 같으면 몇개를 팔아도 손해 이므로 -1 출력
		if(B>=C) {
			System.out.println(-1);
		}else {
			System.out.println(A/(C-B) +1);
		}
	}

}