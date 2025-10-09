package Studying;
import java.util.*;
import java.io.*;

public class B17103 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		// 소수면 true
		boolean[] dp = new boolean[1000001];
		Arrays.fill(dp, true);
		dp[0] = false;
		dp[1] = false;
		StringBuilder sb = new StringBuilder();
		
		for (long i = 2; i*i < dp.length; i++) {
			for (long j = i*i; j < dp.length; j+=i) {
				dp[(int)j] = false;
			}
		}
		
		for (int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			int count = 0;
			
			for (int j = 2; j <= input / 2; j++) {
				if (dp[j] && dp[input-j]) {
					count++;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb.toString());
	}
}
