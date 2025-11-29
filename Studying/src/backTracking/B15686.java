package backTracking;
import java.io.*;
import java.util.*;

public class B15686 {
	static int N, M;
	static int min = Integer.MAX_VALUE;
	// 미리 집 위치를 정리
	static ArrayList<int[]> house;
	// 미리 치킨집 위치를 정리
	static ArrayList<int[]> chicken;
	static int[] selected;
	static void dfs(int depth, int start) {
		if (depth == M) {
			int sum = 0;
			for (int[] yx : house) {
				int y1 = yx[0];
				int x1 = yx[1];
				int dist = Integer.MAX_VALUE;
				for (int index : selected) {
					int[] yx2 = chicken.get(index);
					int y2 = yx2[0];
					int x2 = yx2[1];
					dist = Math.min(dist, Math.abs(y2 - y1) + Math.abs(x2 - x1));
				}
				sum += dist;
			}
			if (sum < min) min = sum;
			return;
		}
		// 1, 2  1, 3  1, 4  2, 3 ...
		for (int i = start; i < chicken.size(); i++) {
			selected[depth] = i;
			dfs(depth+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) house.add(new int[] {i, j});
				if (num == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		selected = new int[M];
		dfs(0, 0);
		System.out.println(min);
	}
}
