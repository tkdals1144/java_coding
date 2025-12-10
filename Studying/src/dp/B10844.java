package dp;
import java.util.*;
import java.io.*;

public class B10844 {
	static int N;
	static long[][] dp;
	static long count = 0;

	// 결국 끝쪽의 수가 0 혹은 9 이면 2배로 불어나지 못하고 하나만 증가하게 됨
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 첫 배열은 깊이, 두번째는 수
		dp = new long[N+1][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		// 실제 순회 시작
		for (int i = 2; i <= N; i++) {
			// i번째 수가 0인 것은 이전수가 1인것뿐
			// i번째 수가 9인 것은 이전수가 8인것뿐
			// 또한 얘들은 수가 그대로 들어가니 굳이 MOD 연산이 필요하지 않음
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			// 남은것들도 연산해야겠지
			for (int j = 1; j <= 8; j++) {
				// i번째 수가 j인 것은 이전수가 j-1 혹은 j+1 이니까
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000 ;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			count += dp[N][i];
			if (1000000000 < count) count %= 1000000000;
		}
		System.out.println(count);
	}
}
