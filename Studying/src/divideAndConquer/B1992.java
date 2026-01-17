package divideAndConquer;
import java.util.*;
import java.io.*;
public class B1992 {
	static int N;
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
	static void divide(int x, int y, int size) {
		if (isSame(x, y, size)) {
			sb.append(graph[x][y]);
			return;
		}
		
		int half = size / 2;
		sb.append("(");
		divide(x, y, half);
		divide(x, y + half, half);
		divide(x + half, y, half);
		divide(x + half, y + half, half);
		sb.append(")");
	}
	static boolean isSame(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (graph[x][y] != graph[i][j]) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				graph[i][j] = input[j] - '0';
			}
		}
		divide(0, 0, N);
		System.out.println(sb.toString());
	}
}
