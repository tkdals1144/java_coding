package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int count1 = 1;
		int count2 = 1;
		int max = 0;
		
		int[] dp = new int[N];
		
		String arr = bf.readLine();
		StringTokenizer st = new StringTokenizer(arr);
		
		for (int i = 0; i < N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
			if (i != 0) {
				if (dp[i] > dp[i-1]) {
					if (count2 > max) max = count2;
					count2 = 1;
					count1++;
				} else if (dp[i] == dp[i-1]) {
					count1++;
					count2++;
				} else {
					if (count1 > max) max = count1;
					count1 = 1;
					count2++;
				}
			}
			if (i == N - 1) {
				if (count1 > max) max = count1;
				if (count2 > max) max = count2;
			}
		}
		System.out.println(max);
	}
}
