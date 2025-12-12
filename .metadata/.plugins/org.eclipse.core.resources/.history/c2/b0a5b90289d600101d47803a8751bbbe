package dp;
import java.util.*;
import java.io.*;

public class B2156 {
	static int n;
	static int[] arr;
	// dp[현재수][연속된개수]
	static int[][] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1][3];
		// 총 3가지 상태 존재
		// 00 0~1
		// 01 0~1
		// 11 0
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= n; i++) {
			// 0은 이전것만 가져오니
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			// 1은 이전것과 더해 이번걸 더하니
			dp[i][1] = dp[i-1][0] + arr[i];
			// 2는 이전것과 지금것까지 연속된 두개를 더하니
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.println(max);
	}
}
