package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class P9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++) {

            Stack<Character> stack = new Stack<>();

            String ps = br.readLine();

            for (int j = 0; j < ps.length(); j++) {
                char c = ps.charAt(i);

                if (c == '(') {
                    stack.push(c);
                }else if (stack.isEmpty()) {
                    System.out.println("NO");
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
