package bfs;
import java.util.*;
import java.io.*;

public class B1926 {
	// 세로길이 n, 가로길이 m
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] graph;
	static boolean[][] visited;
	
	static int count = 0;
	static int max = 0;
	static void bfs(int i, int j) {
		count++;
		int size = 1;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerLast(new int[] {i, j});
		visited[i][j] = true;
		while (!deque.isEmpty()) {
			int[] yx = deque.pollFirst();
			for (int k = 0; k < 4; k++) {
				int ny = yx[0] + dy[k];
				int nx = yx[1] + dx[k];
				if (0 <= nx && 0 <= ny && nx < m && ny < n && !visited[ny][nx] && graph[ny][nx] == 1) {
					deque.offerLast(new int[] {ny, nx});
					visited[ny][nx] = true;
					size++;
				}
			}
		}
		if (size > max) max = size;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && graph[i][j] == 1) bfs(i, j);
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}
}
