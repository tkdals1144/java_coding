package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem01 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		StringBuilder sb = new StringBuilder();
		
		// 행의 개수
		int N = Integer.parseInt(st.nextToken());
		// 열의 개수
		int M = Integer.parseInt(st.nextToken());
		// 현재 소유한 블럭을 개수
		int B = Integer.parseInt(st.nextToken());
		
		// 작업시간
		int time = Integer.MAX_VALUE;
		// 최종높이
		int high = 0;
		
		// 초기화 작업
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = bf.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0 ~ 256 까지의 모든 작업 실행
		for (int i = 0; i <= 256; i++) {
			int testItem = B;
			int testTime = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					if (arr[j][k] >= i) {
						testTime += 2 * (arr[j][k] - i);
						testItem += (arr[j][k] - i);
					} else {
						testTime += (i - arr[j][k]);
						testItem -= (i - arr[j][k]);
					}
				}
				if (j == (arr.length - 1)) {
					if (testItem < 0) break;
					if (testTime <= time) {
						time = testTime;
						high = i;
					}
				}
			}
		}
		
		sb.append(time).append(" ").append(high);
		System.out.println(sb.toString());
	}
}
