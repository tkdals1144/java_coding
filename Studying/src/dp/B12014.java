package dp;
import java.util.*;
import java.io.*;
public class B12014 {
	static int N, K;
	static int[] arr;
	static int[] lis;
	static int size;
	static boolean func() {
		for (int i = 1; i < N; i++) {
			if (lis[size-1] < arr[i]) {
				lis[size++] = arr[i];
			} else {
				// 찾아야겠지?
				int idx = Arrays.binarySearch(lis, 0, size, arr[i]);
				// 있어? 그럼 넘겨
				if (0 <= idx) continue;
				// 없어? 그럼 적절한 위치로 가
				idx = -(idx + 1);
				lis[idx] = arr[i];
			}
		}
		return K <= size;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("Case #" + i).append('\n');
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			lis = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			size = 0;
			lis[size++] = arr[0];
			boolean check = func();
			if (check) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}
		System.out.println(sb.toString());
	}
}
