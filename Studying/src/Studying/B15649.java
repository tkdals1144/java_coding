package Studying;
import java.util.*;
import java.io.*;

public class B15649 {
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	static boolean[] visited;

	// [1 -> 2 -> 3 -> 4]
	// 결국 dfs와 같이 파고들면서 들어간다
	// 단 중복된 연결값이 있다면 그것을 사용하지 아니한다
	static void dfs(int N, int M) {
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.offerFirst(i);
			visited[i] = true;
			while (deque.size() != M) {
				for (int j = 0; j < graph[i-1].length; j++) {
					deque.offerFirst(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N-1];
		for (int i = 1; i <= graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i == j+1) continue;
				graph[i][j] = i;
			}
		}
		
	}
}
