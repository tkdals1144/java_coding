package Studying;
import java.util.*;
import java.io.*;

public class B28278 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer("");
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			if (input1 == 1) {
				int input2 = Integer.parseInt(st.nextToken());
				stack.add(input2);
			} else {
				switch (input1) {
				case 2:
					if (stack.empty()) {
						sb.append("-1").append('\n');
					} else {
						sb.append(stack.pop()).append('\n');
					}
					break;
				case 3:
					sb.append(stack.size()).append('\n');
					break;
				case 4:
					if (stack.empty()) {
						sb.append('1').append('\n');
					} else {
						sb.append('0').append('\n');
					}
					break;
				case 5:
					if (stack.empty()) {
						sb.append("-1").append('\n');
					} else {
						sb.append(stack.peek()).append('\n');
					}
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
