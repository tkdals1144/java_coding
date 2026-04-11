package greedy;
import java.io.*;
import java.util.*;
public class B30457 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> b - a);
		if (N == 1) {
			System.out.println(1);
			return;
		}
		int big1 = arr[0];
		int big2 = arr[1];
		int count = 2;
		for (int i = 2; i < N; i++) {
			if (arr[i] < big1) {
				big1 = arr[i];
				count++;
			} else if (arr[i] < big2) {
				big2 = arr[i];
				count++;
			}
		}
		System.out.println(count);
	}
}
