package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] R = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        if (N == 1) {
        	System.out.println(0);
        	return;
        }
        
        for (int i = 1; i <= N; i++) {
            R[i] = Long.parseLong(st.nextToken());
        }
        
        long[][] dp = new long[2][N + 1];
        
        // 초기값 설정
        dp[0][1] = 0;         // 첫 번째 칸에 빔을 쏘지 않은 경우
        dp[1][1] = R[1];      // 첫 번째 칸에 빔을 쏘는 경우
        
        for (int i = 2; i <= N; i++) {
        	dp[0][i] = dp[1][i - 1];	// 빔을 쏘지 않기 위해서는 이전에 빔을 쐈어야 하니
        	dp[1][i] = R[i] + Math.min(dp[1][i-1], dp[0][i-1]); // 당장 쏠 생각이라면 이전것은 중요하지 않으니까
        }
        
        // 결과 출력
        System.out.println(Math.min(dp[0][N], dp[1][N]));
    }
}
