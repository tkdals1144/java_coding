package prefixSum;
import java.util.*;
import java.io.*;
public class B2559 {
	static int N, K;
	static int[] arr;
	static int max = 0;
	static int temp = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기화 작업
		for (int i = 0; i < K; i++) {
			max += arr[i];
			temp += arr[i];
		}
		// 비교 작업
		for (int i = 0; i < N-K; i++) {
			temp -= arr[i];
			temp += arr[i+K];
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}
}
