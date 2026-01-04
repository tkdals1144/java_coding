package prefixSum;

import java.io.*;
import java.util.*;

public class B16139 {
	static Map<Character, Integer> map = new HashMap<>();
	static int[][] dp;
	static char[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = br.readLine().toCharArray();
		dp = new int[input.length+1][26];
		for (int i = 0; i < input.length; i++) {
			// 이전 상태 계승
			for (int j = 0; j < 26; j++) {
				dp[i+1][j] = dp[i][j];
			}
			dp[i+1][input[i] - 'a']++;
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int idx = c - 'a';
			int answer = dp[r+1][idx] - dp[l][idx];
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}
}
