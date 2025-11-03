package backTracking;
import java.util.*;
import java.io.*;

public class B15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		// 모든 정점이 연결된 그래프 생성
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
			for (int j = 1; j < graph.length; j++) {
				if (i == j) continue;
				graph[i].add(j);
			}
		}
		// {2, 3, 4} {1, 3, 4}, {1, 2, 4}, {1, 2, 3}
		for (int i = 1; i < graph.length; i++) {
			visited = new boolean[N+1];
			Deque<Integer> deque = new ArrayDeque<>();
			deque.offerFirst(i);
			visited[i] = true;
			int count = 1;
			while (!deque.isEmpty() && count < M) {
				int num = deque.pollFirst();
				sb.append(num).append(" ");
				for (int k : graph[i]) {
					count++;
					deque.offerLast(k);
					sb.append(k).append(" ");
				}
			}
		}
	}
}
