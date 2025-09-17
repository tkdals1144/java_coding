package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeProblem {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] ar = new int[N];
		// 첫 인덱스 -> 0 : 연속된계단 없음, 1 : 연속된계단 있음
		int[][] dp = new int[2][N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(bf.readLine());
		}
		
//		dp[0][k] = dp[0][k-2] + ar[k]
//		dp[0][k] = dp[1][k-2] + ar[k]
//		위의 두가지를 비교해야 하지 않을까?
		
//		dp[1][k] = dp[0][k-1] + ar[k]
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				dp[0][i] = ar[i];
			} else if (i == 1) {
				dp[0][i] = ar[i];
				dp[1][i] = dp[0][i-1] + ar[i];
			} else {
				if (dp[0][i-2] >= dp[1][i-2]) {
					dp[0][i] = dp[0][i-2] + ar[i];
				} else {
					dp[0][i] = dp[1][i-2] + ar[i];
				}
				dp[1][i] = dp[0][i-1] + ar[i];
			}
		}
		if (dp[0][N-1] >= dp[1][N-1]) System.out.println(dp[0][N-1]);
		else System.out.println(dp[1][N-1]);
	}

}
