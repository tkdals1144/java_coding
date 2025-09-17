package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		long sum = 0;
		long[] dp = new long[36];
		
		dp[0] = 1;
		// dp[i] 구하기
		for (int i = 1; i < dp.length; i++) {
			// dp[i] 는 j번 계산
			for (int j = 1; j <= i; j++) {
				sum += (dp[j-1] * dp[i-j]);
			}
			dp[i] = sum;
			sum = 0;
		}
		
		System.out.println(dp[n]);
	}
}
