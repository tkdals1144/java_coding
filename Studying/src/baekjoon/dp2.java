package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dp1 = new int[46];
		int[] dp2 = new int[46];
		
		dp1[0] = 1;
		dp2[0] = 0;
		
		// A -> B -> BA -> BAB -> BABBA -> BABBABAB -> BABBABABBABBA ...
		// 1 0 -> 0 1 -> 1 1 -> 1 2 -> 2 3 -> 3 5 -> 5 8
		for (int i = 1; i < dp1.length; i++) {
			dp1[i] = dp2[i-1];
			dp2[i] = dp1[i-1] + dp2[i-1];
		}
		
		int K = Integer.parseInt(bf.readLine());
		
		sb.append(dp1[K]).append(" ").append(dp2[K]);
		System.out.println(sb.toString());
	}
}
