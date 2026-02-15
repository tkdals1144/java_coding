package greedy;
import java.io.*;
import java.util.*;
public class B1052 {
	static int N, K;
	static int min = Integer.MAX_VALUE;
	static void func(int size) {
		int temp = 1;
		while (N > temp) {
			temp *= 2;
		}
		min = Math.min(min, temp - N);
		temp = 1;
		if (size == 1) return;
		while (N > temp * 2) {
			temp *= 2;
		}
		N -= temp;
//		if (N == 0) {
//			min = 0;
//			return;
//		}
		func(size-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N <= K) {
			System.out.println(0);
		} else {
			func(K);
			System.out.println(min);
		}
	}
}