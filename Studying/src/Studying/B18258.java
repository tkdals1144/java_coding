package Studying;
import java.util.*;
import java.io.*;

public class B18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				deque.offer(Integer.parseInt(st.nextToken()));
			} else {
				switch(input) {
				case "pop": {
					if (deque.isEmpty()) {
						sb.append("-1").append('\n');
					} else {
						sb.append(deque.poll()).append('\n');
					}
					break;
				}
				case "size": {
					sb.append(deque.size()).append('\n');
					break;
				}
				case "empty": {
					sb.append(deque.isEmpty() ? 1 : 0).append('\n');
					break;
				}
				case "front": {
					if (deque.isEmpty()) {
						sb.append("-1").append('\n');
					} else {
						sb.append(deque.peekFirst()).append('\n');
					}
					break;
				}
					case "back": {
					if (deque.isEmpty()) {
						sb.append("-1").append('\n');
					} else {
						sb.append(deque.peekLast()).append('\n');
					}
					break;
				}
				}
			}
		}
		System.out.println(sb.toString());
	}
}

