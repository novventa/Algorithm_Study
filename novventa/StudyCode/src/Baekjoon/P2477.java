package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2477 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 면적 당 참외의 개수 입력받기
        int fruit = Integer.parseInt(st.nextToken());
        // 가로 최대값
        int widthMax = 0;
        // 세로 최대값
        int heightMax = 0;
        // 가로 최대값의 인덱스
        int widthMaxIdx = 0;
        // 세로 최대값의 인덱스
        int heightMaxIdx = 0;
        // 각 방향을 저장하는 배열
        int[] direction = new int[6];
        // 변의 길이를 저장하는 배열
        int[] length = new int[6];
        // 방향 및 길이 입력받기
        // 만약 입력받은 값이 최대값이면
        // 가로 및 세로의 최대값과 인덱스 저장
        for(int i=0;i<6;i++){
            // st 다시 선언
            st = new StringTokenizer(br.readLine());
            // 입력받기
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            // 동쪽 또는 서쪽이면
            if(direction[i]==1 || direction[i]==2){
                // 최대값과 비교하고 더 크면 값과 인덱스 저장
                if(heightMax<length[i]){
                    heightMax = length[i];
                    heightMaxIdx = i;
                }
                // 남쪽 또는 북쪽이면
            }else{
                if(widthMax<length[i]){
                    widthMax = length[i];
                    widthMaxIdx = i;
                }
            }
        }
        // 큰 사각형의 넓이를 저장하는 변수
        int bigSquare = heightMax*widthMax;
        // 각 최대값의 인덱스에 3을 더한 인덱스가 빈 사각형의 변이다.
        // 그냥 더하면 인덱스를 벗어날 수 있으므로 더한 뒤 6으로 나눈 나머지의 값으로 한다.
        int smallSquare = length[(widthMaxIdx+3)%6] * length[(heightMaxIdx+3)%6];

        // 계산한 값을 출력
        System.out.println((bigSquare-smallSquare)*fruit);
    }
}
