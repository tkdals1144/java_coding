package Studying;

import java.util.*;
import java.io.*;

public class Bfs {
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
	
	static class Point {
		int x;
		int y;
		int dist;
		
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static int Bfs(int N, int startX, int startY, int endX, int endY) {
		
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(startX, startY, 0));
		visited[startX][startY] = true;
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			
			if (point.x == endX && point.y == endY) {
				return point.dist;
			}
			
			for (int i = 0; i < 8; i++) {
				int moveX = point.x + dx[i];
				int moveY = point.y + dy[i];
				
				if (moveX > 0 && moveY > 0 && moveX < N && moveY < N && !visited[moveX][moveY]) {
					visited[moveX][moveY] = true;
					q.add(new Point(moveX, moveY, point.dist+1));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		int firstX = Integer.parseInt(st.nextToken());
		int firstY = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < M; i++){
			st = new StringTokenizer(bf.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(Bfs(N+1, firstX, firstY, x, y)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
