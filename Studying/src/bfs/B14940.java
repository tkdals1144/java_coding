package bfs;
import java.util.*;
import java.io.*;

public class B14940 {
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] graph;
	static int[][] dist;
	static void bfs(int y, int x) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerLast(new int[] {y, x});
		dist[y][x] = 0;
		while (!deque.isEmpty()) {
			int[] yx = deque.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + yx[0];
				int nx = dx[i] + yx[1];
				if (0 <= nx && nx < m && 0 <= ny && ny < n && dist[ny][nx] == -1 && graph[ny][nx] == 1) {
					deque.offerLast(new int[] {ny, nx});
					dist[ny][nx] = dist[yx[0]][yx[1]] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int x = 0, y = 0;
		graph = new int[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					y = i;
					x = j;
				}
				graph[i][j] = num;
			}
		}
		bfs(y, x);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
