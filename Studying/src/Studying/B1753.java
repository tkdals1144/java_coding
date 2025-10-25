package Studying;
import java.util.*;
import java.io.*;

public class B1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수 V
		int V = Integer.parseInt(st.nextToken());
		// 간선의 개수 E
		int E = Integer.parseInt(st.nextToken());
		// 시작하는 정점
		int K = Integer.parseInt(br.readLine());
		
		// 양방향 그래프 (가중치) 구현
		ArrayList<HashMap<Integer, Integer>>[] graph = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<HashMap<Integer, Integer>>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add((HashMap<Integer, Integer>)new HashMap<>().put(v, w));
			graph[v].add((HashMap<Integer, Integer>)new HashMap<>().put(u, w));
		}
		
		// bfs를 돌리기 위한 deque 준비.
		// 단 기존의 경로만 저장하는게 아닌 가중치도 저장해야 함.
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Deque<Integer> deque = new ArrayDeque<>();
		// 시작노드 저장
		deque.offerFirst(K);
		
		while (!deque.isEmpty()) {
			
		}
	}
}
