package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P1816 {

    static final int MAX = 1000001;
    static int[] minFactor = new int[MAX];
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        primeNums();

        for(int t=0;t<n;t++){
            long s = Long.parseLong(br.readLine());

            boolean flag = true;

            for (int i = 0; i < prime.size(); i++) {
                if (s % prime.get(i) == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }

    public static void primeNums() {
        Arrays.fill(minFactor, 1);
        minFactor[0] = minFactor[1] = -1;

        for (int i = 2; i < MAX; i++) {
            minFactor[i] = i;
        }

        for (int i = 2; i * i < MAX; i++) {
            if (minFactor[i] == i) {
                for (int j = i * i; j < MAX; j += i) {
                    if (minFactor[j] == j) {
                        minFactor[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i < MAX; i++) {
            if (minFactor[i] == i) {
                prime.add(i);
            }
        }
    }
}
