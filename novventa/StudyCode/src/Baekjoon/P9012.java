package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;


public class P9012 {
    public static void main(String[] args) throws IOException {

        // BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력받기
        int tc = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 반복한다.
        for(int i=0; i<tc; i++) {

            // 괄호 문자 하나씩 저장하기 위한 character 스택 선언
            Stack<Character> stack = new Stack<>();

            // 괄호만으로 이루어진 문자열 입력 받기
            String ps = br.readLine();

            // 괄호만으로 이루어진 문자열의 길이만큼 반복한다.
            for (int j = 0; j < ps.length(); j++) {
                // 문자열에서 하나씩 뽑아서
                char c = ps.charAt(j);

                // 만약 '(' 라면 스택에 넣는다.
                if (c == '(') {
                    stack.push(c);
                    // 만약 ')' 라면 스택에서 '(' 하나를 빼낸다.
                    // 괄호 한 쌍이 완성되기 때문에
                    // 하지만 스택이 비어있을 때 EmptyStackException이 발생하므로
                    // try-catch로 예외처리를 한 후
                    // 'E' 문자를 집어넣는다.
                } else if (c == ')') {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        stack.push('E');
                        break;
                    }
                }
            }

            // 스택이 비어있다면 모든 괄호가 짝을 만나서 빠져나간 것이므로
            // YES를 출력
            if(stack.isEmpty())
                System.out.println("YES");
            // 스택이 비어있지 않다면 집어넣은 E가 남아있다는 뜻으로
            // 괄호가 짝이 맞지 않았다는 것이므로 NO 출력
            else
                System.out.println("NO");
        }
    }
}
