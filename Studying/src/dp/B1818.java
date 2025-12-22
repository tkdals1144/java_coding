package dp;
import java.util.*;
import java.io.*;
public class B1818 {
	static int N;
	static int[] arr;
	static int[] lis;
	static int size = 0;
	static int count = 0;
	static void func() {
		for (int i = 1; i < N; i++) {
			if (lis[size-1] < arr[i]) lis[size++] = arr[i];
			else {
				int idx = Arrays.binarySearch(lis, 0, size, arr[i]);
				if (0 <= idx) continue;
				idx = -(idx + 1);
				lis[idx] = arr[i];
				count++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lis[size++] = arr[0];
		func();
		System.out.println(count);
	}
}
