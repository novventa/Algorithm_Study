package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10866 {
	public static void main(String[] args) throws IOException {
		// 시간초과로 인해 buffer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 처음 명령받을 명령 개수를 받아온다.
		int N = Integer.parseInt(br.readLine());

		// 명령을 N개 받기 때문에 배열을 통해 덱을 나타내고자 한다면
		// 배열의 원소가 가장 많아야 N개일 것이다.
		// 하지만 덱의경우 앞뒤로 원소가 들어갈 수 있으므로
		// 넉넉하게 2*N 사이즈로 두고 앞쪽 배열과 뒤쪽 배열로 구분지어 놓는다.
		int[] deque = new int[2 * N];

		// 앞쪽 배열 즉 앞쪽에 값을 추가할 때 사용할 index
		// 즉 앞쪽에 원소를 집어넣으면 N-1부터 앞부분으로 채워나간다.
		int frontIndex = N - 1;

		// 뒤쪽 배열 즉 뒤쪽에 값을 추가할 때 사용할 index
		// 뒤쪽에 원소를 집어넣으면 N부터 뒷부분으로 채워나간다.
		int backIndex = N;

		// 전체 배열의 사이즈를 나타내는 변수
		// 앞쪽이던 뒤쪽이던 원소가 추가되면 size를 늘려줄 것이다.
		int size = 0;

		// N번의 명령동안 반복
		for (int i = 0; i < N; i++) {
			// 버퍼리더로 읽어온 한줄을 공백을 기준으로 나누어서 문자열로 담아준다.
			// 아래에서는 StringTokenizer(br.readLine(), " "); <=여기서 " " 가 기본값이여서 생략되어있다.
			// 다른 값을 기준으로 나누고 싶다면 두번째 원소를 원하는것으로 지정해주면된다.
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 먼저 명령어를 받아온다.
			String command = st.nextToken();

			// 명령어가 각각의 명령과 일치할 때 해줄 일들을 지정해준다.

			// push front
			if (command.equals("push_front")) {
				// 우선 넣어줄원소를 받아온다.
				int num = Integer.parseInt(st.nextToken());
				// 앞쪽에 넣어주는 것이므로 위에서 저장한 frontIndex에 원소값을 넣어주고
				// 후위 연산자를 사용해 앞쪽으로 한칸 이동한다.
				// 이는 다음원소를 추가하기 위함이다.
				deque[frontIndex--] = num;
				// 원소가 추가되었으므로 size를 증가시키고 다음명령을 실행한다.
				size++;
				continue;
			}

			// push back
			if (command.equals("push_back")) {
				// 우선 넣어줄원소를 받아온다.
				int num = Integer.parseInt(st.nextToken());
				// 뒤쪽에 넣어주는 것이므로 위에서 저장한 backIndex에 원소값을 넣어주고
				// 후위 연산자를 사용해 뒤쪽으로 한칸 이동한다.
				// 이는 다음원소를 추가하기 위함이다.
				deque[backIndex++] = num;
				// 원소가 추가되었으므로 size를 증가시키고 다음명령을 실행한다.
				size++;
				continue;
			}

			// pop front 앞쪽원소를 빼낸다
			if (command.equals("pop_front")) {
				// size가 0일때는 -1을 출력한다.
				if (size == 0) {
					System.out.println(-1);
					// 다음 명령을 실행한다.
					continue;
				}

				// 지금 index값들은 비어있는 값들을 가리키고 있으므로
				// 맨앞쪽 원소를 뽑아내기 위해서는 전위연산자를 통해
				// 뒤쪽으로 한칸더 이동해야한다.
				System.out.println(deque[++frontIndex]);
				// 원소를 뽑아 냈으면 이를 초기값으로 만들어준다.
				deque[frontIndex] = 0;
				// 이후 원소가 빠져나갔으므로 사이즈를 하나 줄이고
				// 다음 명령을 실행한다.
				size--;
				continue;
			}

			/*
			 * pop 메소드에서 가장 헷갈렷던것은 frontIndex와 backIndex를 사용하기 때문에 두개가 겹치면 어떻게 될까 고민을 많이했다.
			 * 
			 * 하지만 size라는 변수를 통해 배열에 들어있는 원소의 개수를 확인하고 있으므로 front와 back index가 겹치기전에 size값이
			 * 0이 되기 때문에 따로 두개의 변수값이 겹치는 일은 걱정하지 않아도 되었다.
			 * 
			 */

			// pop back 뒤쪽 원소를 빼낸다
			if (command.equals("pop_back")) {
				// size가 0일때는 -1을 출력한다.
				if (size == 0) {
					System.out.println(-1);
					// 다음 명령을 실행한다.
					continue;
				}

				// 지금 index값들은 비어있는 값들을 가리키고 있으므로
				// 맨뒤쪽 원소를 뽑아내기 위해서는 전위연산자를 통해
				// 앞쪽으로 한칸더 이동해야한다.
				System.out.println(deque[--backIndex]);
				// 원소를 뽑아 냈으면 이를 초기값으로 만들어준다.
				deque[backIndex] = 0;
				// 이후 원소가 빠져나갔으므로 사이즈를 하나 줄이고
				// 다음 명령을 실행한다.
				size--;
				continue;
			}

			// size값 출력
			if (command.equals("size")) {
				System.out.println(size);
				continue;
			}

			// empty 배열이 비었는지 확인
			if (command.equals("empty")) {
				// 배열 size가 0이면 1출력
				if (size == 0) {
					System.out.println(1);
				}
				// 배열 size가 0이 아니면 0출력
				else {
					System.out.println(0);
				}
				continue;
			}

			// front 앞쪽원소가 무엇인지만 확인
			if (command.equals("front")) {
				// 마찬가지로 size가 0이면 -1출력
				if (size == 0) {
					System.out.println(-1);
					continue;
				}

				// 앞의 pop과 마찬가지로 현재 index값은 비어있으므로
				// 전위연산자를 통해서 한칸 뒤쪽으로 가서 값을 가져온다.
				System.out.println(deque[++frontIndex]);
				// 값을 가져온 이후 빼내는 것이 아니기 때문에
				// 다시 원래 자리로 돌아간다. 이때 전위/후위연산자는 어떤것이던 상관없다.
				frontIndex--;
				continue;
			}

			// 뒤쪽 원소가 무엇인지만 확인
			if (command.equals("back")) {
				if (size == 0) {
					System.out.println(-1);
					continue;
				}

				// 앞의 pop과 마찬가지로 현재 index값은 비어있으므로
				// 전위연산자를 통해서 한칸 앞쪽으로 가서 값을 가져온다.
				System.out.println(deque[--backIndex]);
				// 값을 가져온 이후 빼내는 것이 아니기 때문에
				// 다시 원래 자리로 돌아간다. 이때 전위/후위연산자는 어떤것이던 상관없다.
				backIndex++;
				continue;
			}
		}
		// 사용한 bufferedreader를 종료시킨다.
		br.close();
	}
}
