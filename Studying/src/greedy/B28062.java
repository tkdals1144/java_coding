package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B28062 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> b - a);
		int sum = 0;
		int last = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] % 2 == 0) {
				sum += arr[i];
			}
			else {
				sum += arr[i];
				last = arr[i];
			}
		}
		if (sum % 2 == 0) System.out.println(sum);
		else System.out.println(sum - last);
	}
}
