package Baekjoon;

import java.util.Scanner;

public class P1244 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 스위치 개수 입력받기
        int switches = sc.nextInt();
        // 스위치 상태를 입력받을 배열 선언
        int[] switchArr = new int[switches];

        // 스위치 초기 상태 입력받기
        for (int i = 0; i < switches; i++) {
            switchArr[i] = sc.nextInt();
        }

        // 학생 수 입력받기
        int students = sc.nextInt();

        // 학생의 성별 및 받은 수 입력받기
        for (int j = 0; j < students; j++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();

            // 학생의 성별에 따라 스위치 바꾸기
            // 성별이 남자라면
            if (gender == 1) {
                // 남학생이 받은 수를 num에 저장한다.
                for (int idx = 1; idx < switches + 1; idx++) {
                    // 스위치의 번호가 받은 수의 배수이면
                    if (idx % num == 0) {
                        // 스위치 상태가 0이면 1로, 1이면 0으로
                        if (switchArr[idx - 1] == 0)
                            switchArr[idx - 1] = 1;
                        else
                            switchArr[idx - 1] = 0;
                    }
                }
                // 성별이 여자라면
            } else {
                // 일단 받은 번호의 스위치를 바꾼다.
                if (switchArr[num - 1] == 1)
                    switchArr[num - 1] = 0;
                else
                    switchArr[num - 1] = 1;

                for (int x = 1; x < switches + 1; x++) {
                    // 종료조건 : 인덱스의 범위를 벗어나는 경우 반복문을 빠져나온다.
                    if (num - 1 - x < 0 || num - 1 + x >= switches) {
                        break;
                    }

                    // 양 옆이 대칭인지 확인한다
                    if (switchArr[num - 1 - x] == switchArr[num - 1 + x]) {
                        // 대칭이라면, 스위치를 바꾼다.
                        if (switchArr[num - 1 - x] == 0) {
                            switchArr[num - 1 - x] = 1;
                            switchArr[num - 1 + x] = 1;
                        } else {
                            switchArr[num - 1 - x] = 0;
                            switchArr[num - 1 + x] = 0;
                        }
                    }
                    // 대칭이 아니라면 반복문을 빠져나온다.
                    else {
                        break;
                    }
                }
            }
        }

        // 출력
        for (int p = 0; p < switches; p++) {
            if (p % 20 == 19)
                System.out.println(switchArr[p]);
            else
                System.out.print(switchArr[p] + " ");
        }
    }
}

