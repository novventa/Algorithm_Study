package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P14232{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        ArrayList<Long> list = new ArrayList<>();

        for (long i = 2; i <= Math.ceil(Math.sqrt(k)); i++) {
            while (k % i == 0) {
                list.add(i);
                k /= i;
            }
        }

        if (k != 1) {
            list.add(k);
        }

        System.out.println(list.size());
        for (long factor : list) {
            System.out.print(factor + " ");
        }
    }
}
