package Baekjoon;

import java.util.Scanner;
public class P9012 {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            //테스트 케이스 수의 입력값
            int testCase = sc.nextInt();
            //문자열로 입력받기
            for(int k=0; k<testCase; k++) {

                String input = sc.next();
                char[] arr = new char[input.length()];

                for(int i=0; i<input.length();i++) {
                    arr[i] = input.charAt(i);
                }


                //<조건>
                //1.(의 개수보다 )의 개수가 많아지면 안됨
                //2.(로 시작해야함
                //3.총 (와 )의 개수가 동일해야함

                //1.조건
                if(arr[0] != '(') {
                    System.out.println("NO");
                }else {
                    //(의 개수
                    int count=1;
                    //)의 개수
                    int cnt = 0;

                    for(int i=1; i<input.length();i++) {
                        if(arr[i]=='(') {
                            count++;

                            //2.조건
                            if(count<cnt) {
                                break;
                            }else if(count>cnt) {
                                continue;
                                //같아지면 0부터 다시 세면서 다시 시작
                            }else if(count == cnt) {
                                count=0;
                                cnt =0;
                                continue;
                            }

                        }else {
                            cnt++;

                            //2.조건
                            if(count<cnt) {
                                break;
                            }else if(count>cnt) {
                                continue;
                                //같아지면 0부터 다시 세면서 다시 시작
                            }else if(count == cnt) {
                                count=0;
                                cnt =0;
                                continue;
                            }
                        }

                    }

                    //3.총 (와 )의 개수가 동일해야함(전에 count==cnt가 돼서 0으로 초기화 시킨 건 무시해도 됨)
                    if(count == cnt) {
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }

                }
            }

            sc.close();

        }
    }

