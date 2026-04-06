package greedy;
import java.io.*;
import java.util.*;
public class B1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int me = 0;
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				me = Integer.parseInt(br.readLine());
			} else {
				pq.offer(Integer.parseInt(br.readLine()));
			}
		}
		if (pq.isEmpty()) System.out.println(0);
		else {
			while (true) {
				int pollNum = pq.poll();
				if (pollNum < me) break;
				me++;
				count++;
				pollNum--;
				pq.offer(pollNum);
			}
			System.out.println(count);
		}
	}
}
