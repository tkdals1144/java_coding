package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp8 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 0 0 0 0
		// 0 0 0 0 -> 처음으로 일직선으로 이동하는 경로는 1로 초기화하는것이 좋겠다
		
		// 어차피 (1, 1) 부터 (n, m) 까지니 그냥 (0, 0) 부터 (n-1, m-1) 으로 초기화해도 되겠다
		long[][] dp = new long[n][m];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1];
				if (dp[i][j] >= 1000000007) dp[i][j] %= 1000000007;
			}
		}
		
		System.out.println(dp[n-1][m-1]);
	}
}
