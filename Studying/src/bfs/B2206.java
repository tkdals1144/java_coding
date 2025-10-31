package bfs;
import java.util.*;
import java.io.*;

public class B2206 {
	static int N;
	static int M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] dx2 = {-1, -1, 1, 1, -2, 2, 0, 0};
	static int[] dy2 = {-1, 1, -1, 1, 0, 0, -2, 2};
	// 이동횟수 저장 그래프
	static int[][] graphStart;
	static int[][] graphEnd;
	// 벽 유무
	static char[][] graph2;
	static void bfs1() {
		graphStart[0][0] = 1;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerLast(new int[] {0, 0});
		while (!deque.isEmpty()) {
			int[] xy = deque.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				if (0 <= nx && 0 <= ny && nx < N && ny < M && graphStart[nx][ny] == 0 && graph2[nx][ny] == '0') {
					graphStart[nx][ny] = graphStart[xy[0]][xy[1]] + 1;
					deque.offerLast(new int[] {nx, ny});
				}
			}
		}
	}
	static void bfs2() {
		graphEnd[N-1][M-1] = 1;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerLast(new int[] {N-1, M-1});
		while (!deque.isEmpty()) {
			int[] xy = deque.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				if (0 <= nx && 0 <= ny && nx < N && ny < M && graphEnd[nx][ny] == 0 && graph2[nx][ny] == '0') {
					graphEnd[nx][ny] = graphEnd[xy[0]][xy[1]] + 1;
					deque.offerLast(new int[] {nx, ny});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graphStart = new int[N][M];
		graphEnd = new int[N][M];
		graph2 = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				graph2[i][j] = input[j];
			}
		}
		bfs1();
		bfs2();
		int value = graphStart[N-1][M-1];
		if (value == 0) value = 100000000;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 8; k++) {
					int nx = i + dx2[k];
					int ny = j + dy2[k];
					if (0 <= nx && 0 <= ny && nx < N && ny < M) {
						if (graphStart[i][j] != 0 && graphEnd[nx][ny] != 0) {
							int count = graphStart[i][j] + graphEnd[nx][ny] + 1;
							if (count < value) value = count;
						} else if (graphStart[nx][ny] != 0 && graphEnd[i][j] != 0) {
							int count = graphStart[nx][ny] + graphEnd[i][j] + 1;
							if (count < value) value = count;
						}
					}
				}
			}
		}
		if (value == 100000000) System.out.println(-1);
		else {
			System.out.println(value);
		}
	}
}
