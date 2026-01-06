package prefixSum;
import java.util.*;
import java.io.*;
public class B11660 {
	
	// 1 3 6 10
	// 2 5 9 14
	// 3 7 12 18
	// 4 9 15 22
	
	static int N, M;
	static int[][] dp;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		// 각 행 별로 누적합을 저장
		for (int i = 1; i <= N; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st.nextToken());
				dp[i][j] = sum;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int tempSum = 0;
			for (int j = x1; j <= x2; j++) {
				tempSum += (dp[j][y2] - dp[j][y1-1]);
			}
			sb.append(tempSum).append('\n');
		}
		System.out.println(sb.toString());
	}
}
