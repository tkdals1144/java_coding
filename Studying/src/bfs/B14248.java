package bfs;
import java.io.*;
import java.util.*;
public class B14248 {
	static int n;
	static int[] graph;
	static boolean[] visited;
	static int count = 0;
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		count++;
		while (!q.isEmpty()) {
			int loc = q.poll();
			int jump = graph[loc];
			if (1 <= loc-jump && !visited[loc-jump]) {
				q.offer(loc-jump);
				visited[loc-jump] = true;
				count++;
			}
			if (loc+jump <= n && !visited[loc+jump]) {
				q.offer(loc+jump);
				visited[loc+jump] = true;
				count++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n+1];
		visited = new boolean[n+1];
		visited[0] = true;
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		int start = Integer.parseInt(br.readLine());
		bfs(start);
		System.out.println(count);
	}
}
