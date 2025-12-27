package dp;
import java.util.*;
import java.io.*;
public class B14728 {
	static int N, T;
	static int[][] arr;
	// 무게를 index로 활용
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		// 무게로 초기화할것!
		dp = new int[N][T+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 0번째에는 예상 공부 시간
			arr[i][0] = Integer.parseInt(st.nextToken());
			// 1번째에는 점수
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// dp의 첫 부분을 초기화할것
		for (int i = 0; i <= T; i++) {
			// arr의 첫 시간보다 큰곳은 전부 해당 시간의 점수로 초기화
			if (arr[0][0] <= i) dp[0][i] = arr[0][1];
		}
		
		// 첫부분은 초기화했으니 다음부터 시작
		for (int i = 1; i < N; i++) {
			// 가장 먼저 시간과 점수를 꺼냄
			int time = arr[i][0];
			int score = arr[i][1];
			// 해당 시간과 점수를 이미 저장된것들과 비교 시작
			for (int j = 0; j <= T; j++) {
				if (time <= j) {
					// 기존의것과 새로운것중 어느것이 더 좋을까?
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time] + score);
				} else {
					// 이러면 그냥 기존것을 계승하는수밖에 읎다
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-1][T]);
	}
}
