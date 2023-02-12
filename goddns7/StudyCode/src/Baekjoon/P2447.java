package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2447 {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //N을 입력받음
        int n = Integer.parseInt(bf.readLine());

        //재귀함수
        Method1(n);


    }

    public static String[][] Method1(int n) {

        //별을 찍는 전체를 배열로 만듬
        String[][] arr = new String[n][n];

        //모든 원소에 별을 찍음
        for(int j=0; j<n;j++) {
            for(int i=0;i<n;i++) {
                arr[j][i] = "*";
            }
        }

        //해당 조건을 만족하는 원소 부분만 공백으로 바꾸기 위함
        int q=1;
        for(int s=1; q<=n ;s++) {

            //n*n의 경우 가로와 세로 모두 n/3부터 2*(n/n) 이전까지 공백으로 채워진다
            //또, x*x 의 공백은 +x씩 간격으로 공백이 똑같이 추가 된다.

            for(int e=0; e<=(3*q-1)/3; e++) {
                for(int j=n/(3*q)+(n/q*e); j<2*n/(3*q)+(n/q*e); j++) {


                    for(int r=0; r<=(3*q-1)/3; r++) {
                        for(int i= n/(3*q)+(n/q*r); i<2*n/(3*q)+(n/q*r) ;i++) {
                            arr[j][i] = " ";
                        }
                    }
                }
            }
            q= q*3;
        }

        //줄바꿈을 위해 n번째 원소가 나올 때 줄바꾸는 것을 대입
        for(int j=0; j<n;j++) {
            for(int i=0;i<n;i++) {
                System.out.print(arr[j][i]);
                if(i==n-1) {
                    System.out.println();
                }
            }
        }

        return arr;
    }

}