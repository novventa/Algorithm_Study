package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P14891 {
    static Deque<Integer> wheel1;
    static Deque<Integer> wheel2;
    static Deque<Integer> wheel3;
    static Deque<Integer> wheel4;
    static int K;
    static int[] rotate;
    static int[] direction;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        wheel1 = new ArrayDeque<>();
        wheel2 = new ArrayDeque<>();
        wheel3 = new ArrayDeque<>();
        wheel4 = new ArrayDeque<>();

        wheelInput(br, wheel1);
        wheelInput(br, wheel2);
        wheelInput(br, wheel3);
        wheelInput(br, wheel4);

        K = Integer.parseInt(br.readLine());

        rotate = new int[K];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            rotate[i] = Integer.parseInt(st.nextToken());
            direction[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<K;i++){
//            if(direction[i]==1)
        }







    }

    private static void wheelInput(BufferedReader br, Deque<Integer> wheel) throws IOException {

        String str = br.readLine();
        for(int j=0;j<8;j++){
            wheel.add(str.charAt(j)-'0');
        }
    }
}
