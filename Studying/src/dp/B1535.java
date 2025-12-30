package dp;
import java.util.*;
import java.io.*;
public class B1535 {
	static int N;
	static int[][] peoples;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		peoples = new int[N][2];
		dp = new int[N][100];
		for (int i = 0; i < N; i++) {
			peoples[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			peoples[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 100; i++) {
			// 첫번째 사람을 초기화 작업
			if (peoples[0][0] <= i) dp[0][i] = peoples[0][1];
		}
		// 0번재 초기화는 했으니 1부터 시작
		for (int i = 1; i < N; i++) {
			int people = peoples[i][0];
			int value = peoples[i][1];
			for (int j = 0; j < 100; j++) {
				if (people <= j) {
					// 그대로 계승할꺼냐 아니면 더한값을 가져올꺼냐
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-people] + value);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-1][99]);
	}
}
