package dijkstra;
import java.util.*;
import java.io.*;
public class B1504 {
	static final long INF = 1000000000000L;
	static class Node {
		int to;
		long cost;
		public Node(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	// 정점 N, 간선 M
	static int N, M;
	static int u, v;
	static ArrayList<Node>[] arr;
	static long[] dijkstra(int start) {
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			return Long.compare(a.cost, b.cost);
		});
		
		pq.add(new Node(start, 0));
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
	static void func() {
		long[] d1 = dijkstra(1);
		long[] d2 = dijkstra(u);
		long[] d3 = dijkstra(v);
		
		long case1 = d1[u] + d2[v] + d3[N];
		long case2 = d1[v] + d3[u] + d2[N];
		
		long answer = Math.min(case1, case2);
		
		if (answer >= INF) System.out.println(-1);
		else System.out.println(answer);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			arr[start].add(new Node(end, cost));
			arr[end].add(new Node(start, cost));
		}
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		func();
	}
}
