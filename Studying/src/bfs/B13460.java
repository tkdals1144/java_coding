package bfs;
import java.io.*;
import java.util.*;

// 기울이면 한방향으로 모든 구슬이 나아간다
// 기존의 방향벡터를 이용해 정해진 가중치만큼 나아간 문제와는 결이 다르게 보인다
// 결국 막히는 구간까지 이동하는거니 방향벡터를 이용해 방향을 잡고 막힐때까지 나아가도록 하면 문제를 풀 수 있지 않을까?
public class B13460 {
	// 세로길이 N, 가로길이 M
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] locationR, locationB;
	// 이동횟수 count
	static int count = 10;
	// 빈 공간 = 0, R 지나온 공간 = 1, B 지나온 공간 = 2 ..
	// 으로 하려고 했는데 과연 B가 지나온 공간이 중요할까?
	// 결국 R 이 중점이고 중요하니 B가 지나온 공간은 중요치 않을듯 하다
	// 그러니 다만 B가 구멍에 빠지지 않도록만 유의하면 될 듯 하다
	// 빈 공간 = 0, 지나온 공간 = 1, 벽 = 2, R의 위치 = 3, B의 위치 = 4, 구멍 = 5
	// 다시 생각해보니 같이 움직여도 되겠네...???
	static int[][] graph;
	static int[][] dist;
	static void bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		Deque<int[]> deque2 = new ArrayDeque<>();
		deque.offerLast(locationR);
		deque2.offerLast(locationB);
		while (!deque.isEmpty()) {
			int[] yx = deque.pollFirst();
			int[] yx2 = deque2.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nyR = yx[0] + dy[i];
				int nxR = yx[1] + dx[i];
				int nyB = yx2[0] + dy[i];
				int nxB = yx2[1] + dx[i];
				// 일단 한번을 움직일수 있냐 없냐가 중요포인트! (누적 계수가 증가하기에!)
				boolean point = true;
				// 뭐가 먼저 움직일지 결정할것!
				if (0 <= nxR && 0 <= nyR && nxR < M && nyR < N && graph[nyR][nxR] == 4) point = false;
				if (point) {
					if (0 <= nxR && 0 <= nyR && nxR < M && nyR < N && graph[nyR][nxR] == 0 || graph[nyR][nxR] == 5) {
						// 이동하면서 값을 증가시키고 기존 위치를 1로 업데이트
						dist[nyR][nxR] = dist[yx[0]][yx[1]] + 1;
						locationR = new int[] {nyR, nxR};
						if (graph[nyR][nxR] == 5) {
							boolean check = true;
							while (0 <= nxB && 0 <= nyB && nxB < M && nyB < N) {
								if (graph[nyB][nxB] == 0 || graph[nyB][nxB] == 1) {
									nyB += dy[i];
									nxB += dx[i];
								} else if (graph[nyB][nxB] == 2) break;
								else if (graph[nyB][nxB] == 5) count = -1;
							}
							if (check) count = dist[nyR][nxR];
						}
						graph[yx[0]][yx[1]] = 1;
						nyR += dy[i];
						nxR += dx[i];
						if (0 <= nxB && 0 <= nyB && nxB < M && nyB < N && graph[nyB][nxB] == 0 || graph[nyB][nxB] == 5) {
							if (graph[nyB][nxB] == 0) {
								graph[yx2[0]][yx2[1]] = 0;
								locationB = new int[] {nyB, nxB};
								graph[nyB][nxB] = 4;
							} else // 구멍에 빠지면 큰일남!
								continue;
						}
						nyB += dy[i];
						nxB += dx[i];
						// 이제 한번 이동했으니 더 이상 count를 늘리지 않음
						// 더 이동이 불가하다면 현재 위치를 3으로 업데이트
						while (0 <= nxR && 0 <= nyR && nxR < M && nyR < N) {
							if (graph[nyR][nxR] == 0) {
								dist[nyR][nxR] = dist[nyR][nxR];
								graph[nyR][nxR] = 1;
								graph[nyR][nxR] = 1;
								nyR += nyR;
								nxR += nxR;
							} else if (graph[nyR][nxR] == 5) {
								dist[nyR][nxR] = dist[nyR][nxR];
								count = dist[nyR][nxR];
								graph[locationR[0]][locationR[1]] = 0;
							}
							locationR = new int[] {nyR, nxR};
						}
						graph[locationR[0]][locationR[1]] = 3;
					}
				} else {
					
				}

				
			}
		}
	}
	
	// 근데 또 문제가 있다. 두개의 구슬이 겹치는 경로에 있다면 꼬이지 않을까?
	// 예를들어 R이 움직인 후에 B를 움직이도록 코드를 짠다면 B에 부딪혀 움직이지 않고 B는 끝으로 가서 잘못된 그래프가 입력될것이다.
	// 그러니 두개의 구슬이 부딪힌다면 한번더 R을 움직이도록 코드를 짜면 될까?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				switch(input[j]) {
				case '.':
					graph[i][j] = 0;
					break;
				case '#':
					graph[i][j] = 2;
					break;
				case 'R':
					graph[i][j] = 3;
					locationR = new int[] {i, j};
					break;
				case 'B':
					graph[i][j] = 4;
					locationB = new int[] {i, j};
					break;
				case 'O':
					graph[i][j] = 5;
					break;
				}
			}
		}
		bfs();
		System.out.println(count);
	}

}