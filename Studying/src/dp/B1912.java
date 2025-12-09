package dp;

import java.io.*;
import java.util.*;

public class B1912 {
	static int[] arr;
	static int[] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 10 6 9 10 15 21 -14 12 33 32
		// 2 3 -1 3 7 3 9 14 9 10
		// -1 -2 -3 -4 -5
		// 일단 누적합이 -가 된다면 더이상 누적할 값어치가 없음
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				dp[i] = arr[i];
				max = dp[i];
			}
			else {
				// 더하는것과 아닌것중 더 높은 값어치를 가지는것을 저장
				dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(max);
	}
}
