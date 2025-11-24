package backTracking;
import java.util.*;
import java.io.*;

public class B15651 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int depth) {
		if (depth == M) {
			for (int i : arr) sb.append(i + " ");
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(0);
		System.out.println(sb.toString());
	}
}
