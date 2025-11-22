package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice {
	static int N;
	// 순열 저장 배열
	static int[] arr;
	// 방문 체크
	static boolean[] visited;
	
	static void dfs(int depth) {
		StringBuilder sb = new StringBuilder();
		// 순열이 완성되었다면... (base case, 즉 종료조건을 반드시 가장 앞에 둘것)
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		// 완성 전이라면 아직 돌아가야 한다...!!
		for (int i = 1; i <= N; i++) {
			// 유효성 검사 (가지치기)
			if (!visited[i]) {
				// 상태 변화와 상태 복구 (굉장히 중요함!!)
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 1~N 까지의 순열 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N+1];
		dfs(0);
	}
}
