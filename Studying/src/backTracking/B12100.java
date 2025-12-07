package backTracking;
import java.util.*;
import java.io.*;

public class B12100 {
	static int N;
	static int[][] firstgraph;
	static int[][] dfsgraph;
	static boolean[] visited;
	static int max = 0;
	static void dfs(int depth, int[][] graph) {
		if (depth == 5) {
			return;
		}
//		for (int i = 0; i < 4; i++) {
//			dfsgraph = move_graph(graph, i);
//			dfs(depth+1, dfsgraph);
//		}
	}
//	static int[][] move_graph(int[][] graph, int num) {
//		switch (num) {
//		// 왼쪽으로 이동
//		case 0:
//			for (int k = 0; k < N; k++) {
//				// graph[k][i] : 이동시킬 위치, graph[k][j] : 이동전 위치
//				for (int i = 0; i < N; i++) {
//					visited = new boolean[N];
//					for (int j = i+1; j < N; j++) {
//						// 0이면 이동시킬 가치가 없음
//						if (graph[k][j] == 0) continue;
//						// 한 위치에서는 한번만 결합이 일어나니
//						if (graph[k][i] == graph[k][j] && !visited[i]) {
//							graph[k][i] += graph[k][j];
//							graph[k][j] = 0;
//							visited[i] = true;
//						}
//						// 이동시킬 위치가 0이라면 바로 이동
//						if (graph[k][i] == 0) {
//							graph[k][i] = graph[k][j];
//							graph[k][j] = 0;
//						} else {
//							// 이동시킬 위치가 0이 아니며 막힌다면... 바로 다음 위치로 옮기고 break시켜야 함
//							if (j == i+1) break;
//							else {
//								graph[k][i+1] = graph[k][j];
//								graph[k][j] = 0;
//								break;
//							}
//						}
//					}
//				}
//			}
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		firstgraph = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				firstgraph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
