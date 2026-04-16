package greedy;
import java.io.*;
import java.util.*;
public class B33910 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 거꾸로 저장
		for (int i = N-1; i >= 0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N-1; i++) {
			if (arr[i] < arr[i+1]) {
				arr[i+1] = arr[i];
			}
		}
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
