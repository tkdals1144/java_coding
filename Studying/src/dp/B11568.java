package dp;
import java.io.*;
import java.util.*;
public class B11568 {
	static int N;
	static int[] arr;
	// 최장증가수열 lis
	static int[] lis;
	// lis는 외부 사이즈로 조절
	static int size = 0;
	static void func() {
		for (int i = 1; i < N; i++) {
			// 만약 증가상태가 유지된다면
			if (lis[size-1] < arr[i]) {
				// 그냥 넣고 외부 사이즈를 증가시킴
				lis[size++] = arr[i];
			} else {
				// arr[i]가 lis에 있는지 탐색. 없다면 넣어야 할 위치 -값으로 반환
				int idx = Arrays.binarySearch(lis, 0, size, arr[i]);
				// 만약 기존에 그 값이 있다면 그냥 넘김
				if (0 <= idx) continue;
				// 기존에 없는 값이라면 update를 위해 변환
				idx = -(idx + 1);
				lis[idx] = arr[i];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		lis = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lis[size++] = arr[0];
		func();
		System.out.println(size);
	}
}
