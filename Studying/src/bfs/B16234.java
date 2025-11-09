package bfs;
import java.util.*;
import java.io.*;

public class B16234 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] graph;
	static int output = 0;
	static boolean check;
	static int N, L, R;
	
	static void bfs(int y, int x) {
		ArrayList<int[]> arr = new ArrayList<>();
		Deque<int[]> deque = new ArrayDeque<>();
		arr.add(new int[] {y, x});
		visited[y][x] = true;
		int count = 1;
		int sum = graph[y][x];
		deque.offerLast(new int[] {y, x});
		while (!deque.isEmpty()) {
			int[] yx = deque.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + yx[0];
				int nx = dx[i] + yx[1];
				if (0 <= nx && 0 <= ny && nx < N && ny < N && !visited[ny][nx]
						&& L <= Math.abs(graph[ny][nx] - graph[yx[0]][yx[1]])
						&& Math.abs(graph[ny][nx] - graph[yx[0]][yx[1]]) <= R) {
					count++;
					arr.add(new int[] {ny, nx});
					sum += graph[ny][nx];
					deque.offerLast(new int[] {ny, nx});
					visited[ny][nx] = true;
					check = false;
				}
			}
		}
		sum /= count;
		for (int[] yx : arr) {
			graph[yx[0]][yx[1]] = sum;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N : 크기, L <= x <= R
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			visited = new boolean[N][N];
			check = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			if (check) break;
			output++;
		}
		System.out.println(output);
	}
}
