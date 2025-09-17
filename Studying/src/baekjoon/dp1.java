package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class dp1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] dp = new BigInteger[91];
		
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		int i = Integer.parseInt(bf.readLine());
		
		System.out.println(dp[i]);
	}
}
