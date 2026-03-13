package dijkstra;
import java.util.*;
import java.io.*;
public class B17396 {
	static class Node {
		int to;
		long cost;
		public Node(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	// N : 정점, M : 간선
	static int N, M;
	static ArrayList<Node>[] arr;
	static Long[] dist;
	static void reset() {
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		dist = new Long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
	}
	static void func() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			return Long.compare(a.cost, b.cost);
		});
		pq.offer(new Node(0, 0));
		dist[0] = (long) 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > dist[now.to]) continue;
			for (Node next : arr[now.to]) {
				if (dist[next.to] > now.cost + next.cost) {
					dist[next.to] = now.cost + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		reset();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 1) {
				dist[i] = (long) -1;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[start].add(new Node(end, cost));
			arr[end].add(new Node(start, cost));
		}
		func();
		if (dist[N-1] == Long.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(dist[N-1]);
		}
	}
}
