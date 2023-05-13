package Baekjoon;

import java.util.Scanner;

public class P9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 문자열과 폭발 문자열 입력받기
        String str = sc.next();
        String bomb = sc.next();

        //  문자열에서 하나씩 뗴서 처리하기
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            sb.append(tmp);
            // 일단 스트링빌더에 문자열을 더한다
            if(sb.length()>=bomb.length()){
                boolean same = true;
                // 폭발 문자열과 문자열에서 한 글자씩 떼서 비교
                for(int j=0;j<bomb.length();j++){
                    char str1 = sb.charAt(sb.length()-bomb.length()+j);
                    char bomb1 = bomb.charAt(j);
                    // 다르면 넘어간다
                    if(str1 != bomb1){
                        same = false;
                        break;
                    }
                }
                // 같으면 스트링빌더에 저장했던 문자를 삭제한다
                if(same)
                    sb.delete(sb.length()-bomb.length(),sb.length());
            }
        }
        // 스트링빌더에 저장된 문자가 없으면 FRULA 출력
        if(sb.length()==0)
            System.out.println("FRULA");
        // 있으면 스트링빌더에 있는 문자열 출력
        else
            System.out.println(sb.toString());

    }
}
