package dijkstra;

import java.io.*;
import java.util.*;

public class B13424 {
	static final int INF = Integer.MAX_VALUE;
	static class Node {
		int to;
		int cost;
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	// 정점 N, 간선 M, 시작점 K
	static int N, M, K;
	static ArrayList<Node>[] arr;
	static void reset() {
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
	}
	static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > dist[now.to]) continue;
			for (Node next : arr[now.to]) {
				if (dist[next.to] > now.cost + next.cost) {
					dist[next.to] = now.cost + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			reset();
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				arr[start].add(new Node(end, cost));
				arr[end].add(new Node(start, cost));
			}
			K = Integer.parseInt(br.readLine());
			int[][] start = new int[K][N+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				start[j] = dijkstra(Integer.parseInt(st.nextToken()));
			}
			int min = INF;
			int room = 0;
			// start[0][1] + start[1][1] 와 start[0][2] + start[1][2] 비교
			for (int j = 1; j <= N; j++) {
				int count = 0;
				for (int k = 0; k < K; k++) {
					count += start[k][j];
				}
				if (count < min) {
					min = count;
					room = j;
				}
			}
			sb.append(room).append('\n');
		}
		System.out.println(sb.toString());
	}
}
