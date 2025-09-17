package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeProblem14 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 3;
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + 2*dp[i-2];
			if (dp[i] >= 10007) {
				dp[i] %= 10007;
			}
		}
		System.out.println(dp[n]);
	}
}
