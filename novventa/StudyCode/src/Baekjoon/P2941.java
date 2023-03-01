package Baekjoon;

import java.util.Scanner;

public class P2941 {
    public static void main(String[] args) {
// 크로아티아 알파벳이 문자열에 몇 개 포함되어 있는지 출력
// 간단하게 크로아티아 알파벳들을 문자열 배열에 저장하고
// 입력받은 문자열에 크로아티아 알파벳들을 한 글자 문자로 바꾸고 길이를 출력하면 된다.

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 크로아티아 알파벳들을 배열에 저장한다.
        String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        // 문자열 입력받기
        String str = sc.next();
        // 크로아티아 알파벳들을 저장한 배열에서 하나씩 가져와서
        for(int i=0; i<croatian.length; i++){
            // 입력받은 문자열에 해당 크로아티아 알파벳이 있다면
            if(str.contains(croatian[i]))
                // 모두 @로 바꾼다.
                str = str.replace(croatian[i],"@");
        }
        // 바뀐 문자열의 길이를 출력한다.
        System.out.println(str.length());

    }
}
