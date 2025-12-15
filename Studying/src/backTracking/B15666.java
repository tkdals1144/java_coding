package backTracking;
import java.util.*;
import java.io.*;

public class B15666 {
	static int N, M;
	static int size;
	static int[] arr;
	static int[] saved;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int depth) {
		if (depth == M) {
			for (int i : saved) sb.append(i + " ");
			sb.append('\n');
			return;
		}
		for (int i = 0; i < size; i++) {
			if (depth != 0 && arr[i] < saved[depth-1]) continue;
			saved[depth] = arr[i];
			dfs(depth+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 정렬 및 중복제거
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		size = set.size();
		int index = 0;
		arr = new int[size];
		// 정렬과 중복이 제거된 값들을 정적배열에 담음
		for (int i : set) {
			arr[index++] = i;
		}
		saved = new int[M];
		dfs(0);
		System.out.println(sb.toString());
	}
}
