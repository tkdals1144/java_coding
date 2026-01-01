package dp;
import java.util.*;
import java.io.*;
public class B16493 {
	static int N, M;
	static int[][] books;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		books = new int[M][2];
		dp = new int[M][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page = Integer.parseInt(st.nextToken());
			books[i][0] = day;
			books[i][1] = page;
		}
		// 초기화 작업 (첫날에 이 날짜수 이상은 이 페이지를 채울수 있다)
		for (int i = 0; i <= N; i++) {
			int day = books[0][0];
			int page = books[0][1];
			if (day <= i) {
				dp[0][i] = page;
			}
		}
		
		for (int i = 1; i < M; i++) {
			int day = books[i][0];
			int page = books[i][1];
			for (int j = 0; j <= N; j++) {
				if (day <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-day] + page);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[M-1][N]);
	}
}
