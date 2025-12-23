package dp;
import java.io.*;
import java.util.*;

public class B3745 {
	static int N;
	static int[] arr;
	static int[] lis;
	static int size;
	static void func() {
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
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while ((str = br.readLine()) != null) {
			str = str.trim();
			N = Integer.parseInt(str);
			arr = new int[N];
			lis = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			size = 0;
			lis[size++] = arr[0];
			func();
			sb.append(size).append('\n');
		}
		System.out.println(sb.toString());
	}
}
