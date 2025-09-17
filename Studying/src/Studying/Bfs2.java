package Studying;

import java.io.*;
import java.util.*;

public class Bfs2 {
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static int[][] Bfs(int N, int startX, int startY) {
		
		int[][] dist = new int[N+1][N+1];
		for (int arr[] : dist) Arrays.fill(arr, -1);
		Queue<int[]> q = new LinkedList<>();
		
		dist[startX][startY] = 0;
		q.add(new int[] {startX, startY, dist[startX][startY]});
		
		while (!q.isEmpty()) {
			int[] point = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int moveX = point[0] + dx[i];
				int moveY = point[1] + dy[i];
				
				if (moveX > 0 && moveY > 0 && moveX <= N && moveY <= N) {
					if (dist[moveX][moveY] == -1) {
						dist[moveX][moveY] = point[2] + 1;
						q.add(new int[] {moveX, moveY, dist[moveX][moveY]});
					}
				}
			}
		}
		
		return dist;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		
		int[][] dist = Bfs(N, startX, startY);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(dist[x][y]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
