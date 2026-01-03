package dp;
import java.util.*;
import java.io.*;
public class B2073 {
	// 총 길이 D, 수도관 종류 개수 P 
	// 출력 -> 가능한 최대 수도관 용량
	static int D, P;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dp = new int[D+1];
		// 파이프 초기화 작업
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int volume = Integer.parseInt(st.nextToken());
			
			for (int j = D; length <= j; j--) {
				if (j == length) {
					dp[j] = Math.max(dp[j], volume);
				} else if (dp[j-length] > 0) {
					dp[j] = Math.max(dp[j], Math.min(dp[j-length], volume));
				}
			}
		}
		System.out.println(dp[D]);
	}
}
