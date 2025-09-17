package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int min1 = 0;
		int min2 = 0;
		
		int[] dp = new int[100001];
		dp[0] = -1;
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 3;
		
		dp[4] = dp[2] + dp[2];
		dp[6] = dp[4] + dp[2];
		dp[10] = dp[5] + dp[5];
		dp[10] = dp[8] + dp[2];
		for (int i = 7; i < dp.length; i++) {
			min1 = dp[i-2] + dp[2];
			min2 = dp[i-5] + dp[5];
			
			if (dp[i-2] == -1) {
				dp[i] = min2;
				continue;
			} else if (dp[i-5] == -1) {
				dp[i] = min1;
				continue;
			} else {
				dp[i] = Math.min(min1, min2);	
			}
		}
		
		System.out.println(dp[n]);
	}
}
