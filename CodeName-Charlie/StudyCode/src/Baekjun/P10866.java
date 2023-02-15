
// 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
// 명령은 총 여덟 가지이다.
// push_front X: 정수 X를 덱의 앞에 넣는다.
// push_back X: 정수 X를 덱의 뒤에 넣는다.
// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 덱에 들어있는 정수의 개수를 출력한다.
// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P10866 {

	public static void main(String[] args) throws IOException {
		Deque<Integer> deque = new ArrayDeque<>(); // 덱의 메서드를 사용하기 위해 덱을 생성한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 시간복잡도를 줄이기 위해 BufferedReader를 사용하자.
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수를 나타내는 변수 N을 입력받는다. 
		// 버퍼는 문자열 타입의 데이터를 입력받기 때문에, 최초 readLine 메서드를 통해 문자열을 입력받고, 그 값을 Integer.parseInt 메서드를 통해 정수로 변환시킨다.

		for (int i = 0; i < N; i++) { // 입력받은 명령의 수(N)만큼 명령을 실행하기 위해, for문을 사용한다.
			String[] input = br.readLine().split(" "); // 명령은 모두 입력의 형태로 이루어지고, 
			// readLine을 단독으로 사용하면, 공백을 구분할 수 없기 때문에, split을 통해 배열의 형태로 명령을 입력 받도록 한다. 

			switch (input[0]) { // 입력받은 명령문에 대해서, switch-case문으로 각각의 경우에 대해 문장을 수행한다.

			case "push_front": { // push front는 추가로 입력받은 정수를 앞에 넣는 메서드이다.
				int X = Integer.parseInt(input[1]); // 변수 X를 입력받고, (input[0]에는 push_front가 들어가 있기에, input[1]에 입력 받는다.)
				deque.addFirst(X); // 값을 맨 앞에 저장하는 add.First 메서드를 사용해 변수 X를 맨 앞에 저장한다.
				break; // 브레이크를 다는 것을 잊지 말자.(이후에는 설명 생략)
			}
			case "push_back": { // push back은 추가로 입력받은 정수를 뒤에 넣는 메서드이다.
				int X = Integer.parseInt(input[1]); // 변수 X를 입력받고, (input[0]에는 push_front가 들어가 있기에, input[1]에 입력 받는다.)
				deque.addLast(X); // 값을 맨 뒤에 저장하는 add.Last 메서드를 사용해 변수 X를 맨 뒤에 저장한다.
				break;
			}
			case "pop_front": { // pop front 메서드는 조건을 두개의 경우로 나눈다.
				if (deque.size() != 0) { // 덱의 크기가 0이 아니라면,
					System.out.println(deque.removeFirst()); // 맨 앞의 값을 삭제하고 반환하는 removeFirst 메서드를 사용하고, 그 값을 출력한다.
					break;
				} else { // 덱의 크기가 0인 경우에는
					System.out.println(-1); // -1을 출력하도록 한다.
					break;
				}
			}
			case "pop_back": { // pop back 메서드도 조건을 두개의 경우로 나눈다.
				if (deque.size() != 0) { // 덱의 크기가 0이 아니라면,
					System.out.println(deque.removeLast()); // 맨 뒤의 값을 삭제하고 반환하는 removeLast 메서드를 사용하고, 그 값을 출력한다.
					break;
				} else { // 덱의 크기가 0이면,
					System.out.println(-1); // -1을 출력한다.
					break;
				}
			}
			case "size": { // size 메서드는 덱에 들어있는 정수의 개수(덱의 크기)를 출력하는 메서드이다.
				System.out.println(deque.size()); // size 메서드로 덱의 크기를 반환하고, 그 값을 출력한다.
				break;
			}
			case "empty": { // empty 메서드는 덱이 비어있으면 1을 아니면 0을 출력한다.
				if (deque.size() != 0) { // size 메서드를 사용해 반환한 덱의 크기가 0이 아니라면(덱이 비어있지 않다면,) 
					System.out.println(0); // 0을 출력한다.
					break;
				} else { // 덱이 비어있는 경우는
					System.out.println(1); // 1을 출력한다. 
					break;
				}
			}
			case "front": { // front 메서드는 덱의 가장 앞에 있는 정수를 출력한다.
				if (deque.size() != 0) { // 덱의 크기가 0이 아닌 경우(비어있지 않은 경우)
					System.out.println(deque.peekFirst()); // peekFirst 메서드를 통해 가장 앞에 있는 값을 확인하고, 이를 출력한다.
					break;
				} else { // 비어있는 경우에는
					System.out.println(-1); // -1을 출력한다.
					break;
				}
			}
			case "back": { // 마지막으로, back 메서드는 덱의 가장 뒤에 있는 정수를 출력한다.
				if (deque.size() != 0) { // 덱의 크기가 0이 아닌 경우(비어있지 않은 경우)
					System.out.println(deque.peekLast()); // peekLast 메서드를 통해 가장 뒤에 있는 값을 확인하고, 출력한다.
					break;
				} else { // 비어있는 경우에는
					System.out.println(-1); // -1을 출력한다.
					break;
				}
			}
			default : // 위의 case에 해당되는 경우가 아니라면
				break; // break. 
			}

		}

	}
}
