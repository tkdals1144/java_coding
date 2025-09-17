package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp12 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[n+1];
		int min = 4;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			min = 4;
			for (int j = 1; j*j <= i; j++) {
				min = Math.min(dp[i - j*j], min);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[n]);
	}
}