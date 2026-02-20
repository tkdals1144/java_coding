package priorityQueue;
import java.io.*;
import java.util.*;
public class B11286 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {
				return Integer.compare(a, b);
			} else {
				return Integer.compare(Math.abs(a), Math.abs(b));
			}
		});
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input != 0) {
				pq.add(input);
			} else {
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}
			}
		}
		System.out.println(sb.toString());
	}
}
