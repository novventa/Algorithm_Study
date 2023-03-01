package SWEA;

import java.util.Scanner;

public class P1961 {
    // 90도 회전을 3번 해야 하므로
    // 메소드를 따로 만드는 것이 좋다.
    static int[][] Rotate90(int[][] arr){
        // 회전했을 때의 배열을 저장할 변수 생성
        int[][] newArr = new int[arr.length][arr.length];

        // 회전하기
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr.length;c++){
                newArr[r][c] = arr[arr.length-1-c][r];
            }
        }
        return newArr;
    }


    public static void main(String[] args) {

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++){
            // 2차원 배열 크기 입력받기
            int N = sc.nextInt();
            // 크기가 N인 2차원 배열 선언
            int[][] arr = new int[N][N];
            // 2차원 배열 채우기
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    arr[r][c] = sc.nextInt();
                }
            }

            // 90도 회전한 배열
            int[][] arr90 = Rotate90(arr);
            // 180도 회전한 배열
            int[][] arr180 = Rotate90(arr90);
            // 270도 회전한 배열
            int[][] arr270 = Rotate90(arr180);

            // 형식에 맞게 출력하기
            System.out.println("#"+ tc);
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    System.out.print(arr90[r][c]);
                }
                System.out.print(" ");

                for(int c=0;c<N;c++){
                    System.out.print(arr180[r][c]);
                }
                System.out.print(" ");

                for(int c=0;c<N;c++){
                    System.out.print(arr270[r][c]);
                }
                System.out.println();
            }
        }
    }
}

//                    0,0  0,1  0,2  0,3
//
//                    1,0  1,1  1,2  1,3
//
//                    2,0  2,1  2,2  2,3
//
//                    3,0  3,1  3,2  3,3
