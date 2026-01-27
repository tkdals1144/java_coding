package binarySearch;
import java.io.*;
import java.util.*;
public class B2805 {
	static int N, M;
	static long[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(trees);
		long left = 0;
		long right = trees[trees.length-1];
		long answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < trees.length; i++) {
				if (mid <= trees[i]) {
					sum += (trees[i] - mid);
				}
			}
			// 이미 충분한 상태라면 좀 낮춰서 시도해볼까?
			if (M <= sum) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
