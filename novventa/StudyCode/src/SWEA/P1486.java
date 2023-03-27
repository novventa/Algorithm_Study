package SWEA;

import java.util.Scanner;

public class P1486 {

    static int n, b, minHeight;
    static int[] arr;
    static boolean[] used;

    static void powerset(int n, int k) {
        if(n == k) {
            int tmpHeight = 0;

            for(int i=0; i<n; i++) {
                if(used[i])
                    tmpHeight += arr[i];
            }

            if(tmpHeight >= b && minHeight > tmpHeight)
                minHeight = tmpHeight;

            return;
        }

        used[k] = true;
        powerset(n, k+1);
        used[k] = false;
        powerset(n, k+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++) {
            n = sc.nextInt();
            b = sc.nextInt();
            minHeight = Integer.MAX_VALUE;
            used = new boolean[n];
            arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();

            powerset(n, 0);

            System.out.println("#"+tc+" "+(minHeight-b));
        }
    }
}