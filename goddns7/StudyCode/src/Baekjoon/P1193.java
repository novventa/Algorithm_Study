package Baekjoon;

import java.util.Scanner;

public class P1193 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //n번째 분수 구하기
        int n = sc.nextInt();

        System.out.println(ResultX(n, Method1(n), Method2(Method1(n))) + "/" + ResultY(n, Method1(n), Method2(Method1(n))));

        sc.close();
    }

    //배열의 그림에서 대각선 원소끼리 묶었을 때 n은 a번째에 속한다
    public static int Method1(int n) {
        //1, 2, 3,---순서로 분수의 개수가 증가해, 그 분수가 해당하는 그룹의 순서를 찾기 위함
        int a = 0;
        for(int k=1; k<5000; k++) {
            //그룹의 원소를 누적으로 더했을 때 n이 속해있는 그룹의  순서를 찾는다
            if(k*(k+1)/2>=n && n>=(k-1)*k/2) {
                a = k;
                break;
            }
        }
        return a;
    }

    //k번째의 원소들 중 n번째의 분수는 대각선 원소끼리 중에서 n-sum번째이다.
    public static int Method2(int a) {
        int sum =0;
        //0. 1. 3. 6. 10 ---의 규칙으로 증가한다.
        for(int i = 0; i<a;i++) {
            sum+=i;
        }
        return sum;
    }

    //전제: 분모와 분자의 값을 합하면 a+1이다
    public static int ResultX(int n, int a, int sum) {
        //분모를 x로 지정
        int x =0;
        //a가 짝수의 경우 분모는 증가
        if(a%2==0) {
            //n-sum번째의 경우 n-sum의 값이다
            x = n - sum;
            //a가 홀수의 경우 분모는 감소
        }else {
            //n-sum번째의 경우 (a+1)-(n-sum)의 값이다.
            x = a - n + sum +1;
        }

        return x;
    }
    //전제: 분모와 분자의 값을 합하면 a+1이다
    public static int ResultY(int n, int a, int sum) {
        //분모를 y로 지정
        int y=0;
        //a가 짝수의 경우 분자는 감소
        if(a%2==0) {
            //n-sum번째의 경우 (a+1)-(n-sum)의 값이다.
            y = a - n + sum +1;
            //a가 홀수의 경우 분자는 증가
        }else{
            //n-sum번째의 경우 n-sum의 값이다
            y = n - sum;
        }

        return y;
    }

}
