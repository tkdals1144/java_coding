package bfs;
import java.io.*;
import java.util.*;

public class B5014 {
	// 총 F층, 현재 위치 S층, 목표 위치 G층, U업 버튼 U, D다운 버튼 D
	static int F, S, G, U, D;
	static int[] dist;
	static void bfs(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		dist[start] = 0;
		while (!q.isEmpty()) {
			int location = q.poll();
			int upLocation = location + U;
			if (upLocation <= F && dist[upLocation] == -1) {
				q.offer(upLocation);
				dist[upLocation] = dist[location] + 1;
				if (upLocation == end) break;
			}
			int downLocation = location - D;
			if (0 < downLocation && dist[downLocation] == -1) {
				q.offer(downLocation);
				dist[downLocation] = dist[location] + 1;
				if (downLocation == end) break;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dist = new int[F+1];
		Arrays.fill(dist, -1);
		bfs(S, G);
		if (dist[G] == -1) System.out.println("use the stairs");
		else System.out.println(dist[G]);
	}
}
