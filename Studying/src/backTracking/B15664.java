package backTracking;
import java.util.*;
import java.io.*;

public class B15664 {
	static int N, M;
	static int[] arr;
	static int[] saved;
	static StringBuilder sb = new StringBuilder();
	// 어차피 정렬될테니? 이전값이랑 같다면 그걸 continue하면 되지 않나?
	static void dfs(int depth, int idx) {
		if (depth == M) {
			for (int i : saved) sb.append(i + " ");
			sb.append('\n');
			return;
		}
		// 동일한 depth에서의 중복을 방지
		int prev = -1; 
		for (int i = idx; i < N; i++) {
			if (arr[i] == prev) continue;
			saved[depth] = arr[i];
			prev = arr[i];
			dfs(depth+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		saved = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb.toString());
	}
}
