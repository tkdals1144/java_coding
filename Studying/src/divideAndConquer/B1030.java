package divideAndConquer;
import java.util.*;
import java.io.*;
public class B1030 {
	static int s; // time
	static int N, K; // N blanks && K squares
	static int R1, R2; // R1 row && R2 column
	static int C1, C2; // C1 row && C2 Column
//	static int[][] graph;
//	static void divide(int i, int j, int size) {
//		if (size == 1) {
//			graph[i][j] = 0;
//			return;
//		}
//		int divideSize = size / N;
//		int start = (N - K) / 2;
//		int end = start + K;
//		for (int k = 0; k < N; k++) {
//			for (int l = 0; l < N; l++) {
//				// 조건에 걸리면 continue
//				if ((start <= k && k < end)
//						&& (start <= l && l < end)) continue;
//				divide(i + k*divideSize, j + l*divideSize, divideSize);
//			}
//		}
//	}
	static int getColor(int r, int c) {
		int size = (int)Math.pow(N, s);
		
		while (size > 1) {
			int divideSize = size / N;
			
			int nr = r / divideSize;
			int nc = c / divideSize;
			
			int start = (N-K) / 2;
			int end = start + K;
			
			if (start <= nr && nr < end &&
					start <= nc && nc < end) {
				return 1;
			}
			
			r %= divideSize;
			c %= divideSize;
			size = divideSize;
		}
		
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());
//		graph = new int[(int)Math.pow(N, s)][(int)Math.pow(N, s)];
//		for (int i = 0; i < graph.length; i++) {
//			Arrays.fill(graph[i], 1);
//		}
//		divide(0, 0, (int)Math.pow(N, s));
//		for (int i = R1; i <= R2; i++) {
//			for (int j = C1; j <= C2; j++) {
//				sb.append(graph[i][j]);
//			}
//			sb.append('\n');
//		}
		for (int i = R1; i <= R2; i++) {
			for (int j = C1; j <= C2; j++) {
				sb.append(getColor(i, j));
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
