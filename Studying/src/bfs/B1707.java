package bfs;
import java.util.*;
import java.io.*;

// { 2 }, { 1, 3, 4 }, { 2, 4 }, { 2 }
// 음... 너비 우선 탐색을 하게 되면 헤드부터 시작했을때 바로 알 수 있긴 한데...
// 헤드부터 탐색할 방법이 있을까?
// 헤드부터 탐색하지 않는것을 기본으로 둔다면...
// 결국 2번 보지 않는이상 문제가 없겠네??

public class B1707 {
	static ArrayList<Integer>[] graph;
	static int onoff[];
	static boolean bfs() {
		// 바로 이전에 어떤값이 들어왔는지 기억할 필요가 있음
		Deque<Integer> deque = new ArrayDeque<>();
		// 첫번째는 다음위치 두번째는 직전위치
		for (int k = 1; k < graph.length; k++) {
			if (onoff[k] != 0) continue;
			deque.offerLast(k);
			onoff[k] = -1;
			while (!deque.isEmpty()) {
				int num = deque.pollFirst();
				for (int i : graph[num]) {
					// 아직 탐색하지 않았다면
					if (onoff[i] == 0) {
						deque.offerLast(i);
						if (onoff[num] == -1) onoff[i] = 1;
						else onoff[i] = -1;
					}
					// 탐색했다면
					else {
						if (onoff[i] == onoff[num]) return false;
					}
				}
			}
		}

		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 정점 1 ~ V
			int V = Integer.parseInt(st.nextToken());
			// 간선 E
			int E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V+1];
			onoff = new int[V+1];
			for (int j = 0; j < graph.length; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			if (bfs()) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
