package dijkstra;
import java.util.*;
import java.io.*;
public class B1753 {
	// 정점의 개수 V, 간선의 개수 E, 시작 정점 K
	static int V, E, K;
	static class Node {
		public int number;
		public int dist;
		public Node(int number, int dist) {
			super();
			this.number = number;
			this.dist = dist;
		}
	}
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		ArrayList<Node>[] arr = new ArrayList[V+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(a, b) -> a.dist - b.dist
				);
		pq.add(new Node(K, 0));
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Node(v, w));
		}
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			// 가중치가 해당 깊이의 값보다 크다면 이동할 이유가 없음
			if (now.dist > dist[now.number]) continue;
			
			// now가 가리키고 있는 모든 노드를 획득
			for (Node next : arr[now.number]) {
				// 실제 dist를 확인하고 갱신
				if (dist[next.number] > next.dist + now.dist) {
					dist[next.number] = next.dist + now.dist;
					// 추후 노드의 dist도 갱신
					pq.add(new Node(next.number, dist[next.number]));
				}
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
			else sb.append(dist[i]).append('\n');
		}
		System.out.println(sb.toString());
	}
}
