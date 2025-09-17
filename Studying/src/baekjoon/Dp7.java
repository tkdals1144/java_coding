package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp7 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int sum = 0;
		
		//          (0 0)
		//       (1 0) (1 1)
		//    (2 0) (2 1) (2 2)
		// (3 0) (3 1) (3 2) (3 3)

		int[][] dp = new int[30][30];
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 0부터이기 때문에 1씩 빼줘야 함
		R--;
		C--;
		
		// R번째 줄부터 C번째 꼭지점부터 W길이의 변만큼의 합 
		// dp[R][C] + dp[R+1][C] + dp[R+1][C+1] + dp[R+2][C] + dp[R+2][C+1] + ...
		for (int i = 0; i < W; i++) {
			for (int j = 0; j <= i; j++) {
				sum += dp[R+i][C+j];
			}
		}
		
		System.out.println(sum);
	}
}
