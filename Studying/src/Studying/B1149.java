package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[][] dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] += Math.min(dp[i-1][1], dp[i-1][2]);
				} else if (j == 1) {
					dp[i][j] += Math.min(dp[i-1][0], dp[i-1][2]);
				} else {
					dp[i][j] += Math.min(dp[i-1][0], dp[i-1][1]);
				}
			}
		}
		
		System.out.println(Math.min((Math.min(dp[N-1][0], dp[N-1][1])), dp[N-1][2]));
	}
}

// 6
// 30 19 5
// 64 77 64
// 15 19 97
// 4 71 57
// 90 86 84
// 93 32 91