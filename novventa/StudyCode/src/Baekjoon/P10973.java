package Baekjoon;

import java.util.Scanner;

public class P10973 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        if (perm(arr)){
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean perm(int[] arr) {
        int i = arr.length-1;
        while(i > 0 && arr[i] > arr[i-1]) {
            i--;
        }

        if(i == 0) //마지막 순열인 경우
            return false;

        int j = arr.length-1;
        while(arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr, i-1, j);

        j = arr.length-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
