import java.math.BigInteger;
import java.util.Scanner;


public class SWEA_1217_거듭제곱_변지혜_BigInteger {
	
	static BigInteger[] memo; 
	
	private static BigInteger pow(BigInteger num, int power) {
		if (power == 0) {
			memo[power] = new BigInteger("1");
		}
		
		if (memo[power] != null) return memo[power];
		
		if (power % 2 == 0)
			memo[power] = pow(num, power / 2).multiply(pow(num, power / 2));
		else
			memo[power] = pow(num, power / 2).multiply(pow(num, power / 2)).multiply(num);
			
		return memo[power];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = 1;
		
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");
			
			BigInteger N = new BigInteger("347293479283472983");
			int M = 210000;
			
			memo = new BigInteger[M + 1];
			
			sb.append(pow(N, M)).append("\n");
		}
		System.out.println(sb);
	}

}
