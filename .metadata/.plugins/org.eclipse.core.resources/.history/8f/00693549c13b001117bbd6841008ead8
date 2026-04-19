package floyd;
import java.io.*;
import java.util.*;
public class B1058 {
	static final int INF = 1000000;
	static int[][] dist;
	static int N;
	static void reset() {
		dist = new int[N][N];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		reset();
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (i == j) dist[i][j] = 0;
				else if (input[j] == 'Y') dist[i][j] = 1;
				else dist[i][j] = INF;
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (i != j && dist[i][j] <= 2) count++;
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
}
