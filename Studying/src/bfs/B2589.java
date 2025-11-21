package bfs;
import java.io.*;
import java.util.*;

public class B2589 {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] graph;
	static int[][] dist;
	static int bfs(int y, int x) {
		int max = 0;
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], -1);
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		dist[y][x] = 0;
		while(!q.isEmpty()) {
			int[] yx = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = yx[0] + dy[i];
				int nx = yx[1] + dx[i];
				if (check(ny, nx) && dist[ny][nx] == -1) {
					q.offer(new int[] {ny, nx});
					dist[ny][nx] = dist[yx[0]][yx[1]] + 1;
					if (max < dist[ny][nx]) max = dist[ny][nx];
				}
			}
		}
		
		return max;
	}
	static boolean check(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M && graph[y][x] == 'L';
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				graph[i][j] = input[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 'L') {
					int num = bfs(i,j);
					if (max < num) max = num;
				}
			}
		}
		System.out.println(max);
	}
}
