package prefixSum;
import java.util.*;
import java.io.*;
public class B25682 {
	static int N, M, K;
	// B: 0, W: 1
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (input[j] == 'B') graph[i][j] = 0;
				else graph[i][j] = 1;
			}
		}
		
	}
}
