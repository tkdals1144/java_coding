package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp11 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		// 1 ~ 50000 을 저장할 공간이 필요
		// 해당 숫자에 대한 결과값 저장
		int[] dp = new int[n+1];
		
		// 어차피 많아야 4번이니 기본적으로 4로 초기화
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 4;
		}
		
		// 초기값 필요 (각 제곱수는 1로 저장)
		for (int i = 1; i*i < dp.length; i++) {
			dp[i*i] = 1;
		}
		
		// 2를 구하자 (1 + 1, 1 + 4, 1 + 9 ...)
		for (int i = 1; i*i < dp.length; i++) {
			for (int j = i; j*j < dp.length; j++) {
				if (i*i + j*j >= dp.length) {
					 continue;
				} else if (dp[i*i + j*j] == 1) {
					continue;
				} else {
					dp[i*i + j*j] = dp[i*i] + dp[j*j];
				}
			}
		}
		
		// 3을 구하자
		for (int  i = 1; i*i < dp.length; i++) {
			for (int j = i; j*j < dp.length; j++) {
				for (int k = j; k*k < dp.length; k++) {
					if (i*i + j*j + k*k >= dp.length) {
						continue;
					} else if (dp[i*i + j*j + k*k] == 1 || dp[i*i + j*j + k*k] == 2) {
						continue;
					} else {
						dp[i*i + j*j + k*k] = dp[i*i] + dp[j*j] + dp[k*k];
					}
				}
			}
		}
		
		System.out.println(dp[n]);
	}
}
