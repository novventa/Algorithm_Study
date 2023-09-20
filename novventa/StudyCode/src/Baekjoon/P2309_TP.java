package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2309_TP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int searchNum = Arrays.stream(arr).sum() - 100;
        int left = 0;
        int right = arr.length - 1;
        int delLeft = 0, delRight = 0;

        while (left <= right) {
            if (searchNum > arr[left] + arr[right]) {
                left++;
            } else if (searchNum < arr[left] + arr[right]) {
                right--;
            } else {
                delLeft = left;
                delRight = right;
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != delLeft && i != delRight) {
                System.out.println(arr[i]);
            }
        }
    }
}
