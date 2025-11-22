package bfs;
import java.util.*;
import java.io.*;

public class B11403 {
	// 0 -> 1, 1 -> 2, 2 -> 0 => 0 -> 1 -> 2 -> 0
	// 0 -> 3, 1 -> 6, 3 -> 4, 3 -> 5, 4 -> 0, 5 -> 6, 6 -> 2
	// 0 -> 3 -> 4 -> 0, 0 -> 3 -> 5 -> 6 -> 2, 1 -> 6 -> 2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[] graph = new ArrayList[N];
		int[][] road = new int[N][N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					graph[i].add(j);
				}
			}
		}
		for (int i = 0; i < graph.length; i++) {
			// 0 -> 1, 1 -> 2, 2 -> 0 => 0 -> 1 -> 2 -> 0
			// 0 -> 1, 0 -> 2, 0 -> 0
			visited = new boolean[N];
			Queue<Integer> q = new ArrayDeque<>();
			visited[i] = true;
			for (int j : graph[i]) {
				q.offer(j);
				visited[j] = true;
				road[i][j] = 1;
			}
			while (!q.isEmpty()) {
				int num = q.poll();
				for (int k : graph[num]) {
					if (!visited[k]) {
						q.offer(k);
						visited[k] = true;
						road[i][k] = 1;
					}
					if (i == k) road[i][k] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(road[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
