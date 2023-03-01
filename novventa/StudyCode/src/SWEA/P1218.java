package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class P1218 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 10번 만큼 반복
        for(int tc=1;tc<11;tc++){
            // 괄호를 확인할 스택 선언
            Stack<Character> stack = new Stack<>();
            // 괄호 갯수 입력받기
            int len = sc.nextInt();
            // 괄호 문자열 입력받기
            String str = sc.next();
            // 괄호 갯수만큼 반복
            for(int i=0;i<len;i++){
                // 괄호 한 개씩 떼 오기
                char pr = str.charAt(i);
                // 만약 여는 괄호라면 스택에 집어넣는다.
                if(pr=='{'||pr=='['||pr=='<'||pr=='(')
                    stack.push(pr);
                // 닫는 괄호면 peek로 확인하고 짝이 맞으면 pop 한다.
                else if(pr=='}' && stack.peek()=='{')
                    stack.pop();
                else if (pr==']' && stack.peek()=='[')
                    stack.pop();
                else if (pr=='>' && stack.peek()=='<')
                    stack.pop();
                else if (pr==')' && stack.peek()=='(')
                    stack.pop();
                else
                    break;
            }
            // 스택이 비어있다면 모든 짝이 맞는 것
            if(stack.isEmpty())
                System.out.println("#" + tc + " 1");
            // 아니면 짝이 맞지 않는다.
            else
                System.out.println("#" + tc + " 0");
        }
    }
}
