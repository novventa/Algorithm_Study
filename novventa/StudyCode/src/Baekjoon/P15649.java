package Baekjoon;

import java.util.Scanner;

public class P15649 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] isUsed;
    static int[] sel;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        arr = new int[10];

        isUsed = new boolean[10];

        sel = new int[N];

        permu(new int[M], 0);

    }

    private static void permu(int[] sel, int idx) {
        if(idx==M){

            for(int i=0;i<M;i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();

            return;
        }

        for(int i=1;i<=N;i++){
            if(!isUsed[i]){
                sel[idx] = i;
                isUsed[i] = true;
                permu(sel,idx+1);
                isUsed[i] = false;
            }

        }
    }
}

