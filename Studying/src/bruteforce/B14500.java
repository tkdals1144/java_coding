package bruteforce;
import java.util.*;
import java.io.*;
public class B14500 {
	static int N, M;
	static int[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static void dfs(int y, int x, int value, int count) {
		value += graph[y][x];
		visited[y][x] = true;
		if (count == 4) {
			max = Math.max(max, value);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (check(ny, nx)) {
				dfs(ny, nx, value, count+1);
				visited[ny][nx] = false;
			}
		}
		visited[y][x] = false;
	}
	// 어차피 한번만 이동하기에 방문처리 불필요
	static void func(int y, int x) {
		int value = 0;
		// 처음에 5개를 탐색한다고 가정
		int count = 5;
		int min = Integer.MAX_VALUE;
		value += graph[y][x];
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (check(ny, nx)) {
				value += graph[ny][nx];
				min = Math.min(min, graph[ny][nx]);
			} else {
				// 탐색 불가능시 1개 감소
				count--;
			}
		}
		if (count == 5) {
			max = Math.max(max, value - min);
		} else if (count == 4) {
			max = Math.max(max, value);
		}
	}
	static boolean check(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M && !visited[y][x];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 1);
				func(i, j);
			}
		}
		System.out.println(max);
	}
}
