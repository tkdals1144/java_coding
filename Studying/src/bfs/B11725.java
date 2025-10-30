package bfs;
import java.util.*;
import java.io.*;

public class B11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N+1];
		int[] ar = new int[N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerLast(1);
		visited[1] = true;
		while (!deque.isEmpty()) {
			int num = deque.pollFirst();
			for (int i : graph[num]) {
				if (!visited[i]) {
					ar[i] = num;
					deque.offerLast(i);
					visited[i] = true;
				}
			}
		}
		for (int i = 2; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
}

// 2 -> 4 
// 3 -> 6
// 4 -> 1
// 5 -> 3
// 6 -> 1
// 7 -> 4
//     1
//   4   6
// 2   