package Baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P10866 {
    // 덱 자료구조 사용법
    // addFirst() 맨 앞에 원소 삽입
    // addLast() 마지막에 원소 삽입
    // pollFirst() 맨 앞의 원소 제거 후 해당 원소를 리턴 덱이 비어있는 경우 null 리턴
    // pollLast() 마지막 원소 제거 후 해당 원소를 리턴 덱이 비어있는 경우 null 리턴
    // peekFirst() 맨 앞의 원소를 리턴 덱이 비어있는 경우 null 리턴
    // peekLast() 마지막 원소를 리턴 덱이 비어있는 경우 null 리턴
    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;

                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;

                case "size":
                    bw.write(deque.size() + "\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;

                case "back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}