package Studying;

import java.util.*;
import java.io.*;

public class Study06 {
	
	// 가로길이
	static int M;
	// 세로길이
	static int N;
	// 배추의 개수
	static int K;
	
	// 방향벡터
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] dist;
	
	static void check(int x, int y) {
		dist[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int ddx = x + dx[i];
			int ddy = y + dy[i];
			if (ddx >= 0 && ddy >= 0 && ddx < M && ddy < N) {
				if (dist[ddx][ddy] == 1) {
					check(ddx, ddy);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();
		
		// testCase 수
		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			dist = new int[M][N];
			int answer = 0;
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				dist[x][y] = 1;
			}
			// 끽해야 50x50 이니 그냥 한번더 검사하자.
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (dist[j][k] == 1) {
						check(j, k);
						answer++;
					}
				}
			}
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
